package com.li.house.admin.impl;

import com.li.house.admin.AdminService;
import com.li.house.common.dao.*;
import com.li.house.common.domain.*;
import com.li.house.common.dto.KeyWordsDTO;
import com.li.house.common.dto.RoomDTO;
import com.li.house.common.dto.UserDTO;
import com.li.house.common.util.RestResult;
import com.li.house.common.util.RestResultBuilder;
import com.li.house.common.util.ResultCode;
import com.li.house.common.util.UUIDUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


@Transactional
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private HouseKeeperMapper houseKeeperMapper;
    @Autowired
    private AdministrationMapper administrationMapper;
    @Autowired
    private SubwayMapper subwayMapper;
    @Autowired
    private AtlasMapper atlasMapper;


    /**
     * 登录
     * @param admin
     * @return
     */
    @Override
    public RestResult loginAdmin(Admin admin) {
        if (admin == null) {
            return new RestResultBuilder().setMsg("信息为空").setCode(ResultCode.ERROR.getCode()).build();
        }
        Admin newAdmin = adminMapper.loginAdmin(admin.getAdAccount());
        if (newAdmin==null){
            return new RestResultBuilder().setMsg("管理员不存在").setCode(ResultCode.ERROR.getCode()).build();
        }
        if (!newAdmin.getAdPassword().equals(admin.getAdPassword())){
            return new RestResultBuilder().setMsg("密码不正确").setCode(ResultCode.ERROR.getCode()).build();
        }
        return new RestResultBuilder().setMsg("登录成功").setData(newAdmin).setCode(ResultCode.SUCCESS.getCode()).build();
    }


    /**
     * 用户列表
     * @return
     */
    @Override
    public RestResult userList() {
        List<User> users = userMapper.selectUserList();
        return new RestResultBuilder().setData(users).setMsg("用户列表").setCode(ResultCode.SUCCESS.getCode()).build();
    }

    /**
     * 添加用户
     * @return
     */
    @Override
    public RestResult insertUser(User user) {
        User user1 = new User();
        user1.setuId(UUIDUtils.UUIDGenerate());
        user1.setuNickname(user.getuNickname());
        user1.setuEmail(user.getuEmail());
        user1.setuPassword(user.getuPassword());
        user1.setuPhonenum(user.getuPhonenum());
        user1.setuCreatetime(new Date());
        userMapper.insertSelective(user1);
        return new RestResultBuilder().setMsg("添加成功").setCode(ResultCode.SUCCESS.getCode()).build();
    }


    /**
     * 修改用户
     * @param userDTO
     * @return
     */
    @Override
    public RestResult updataUser(UserDTO userDTO) {
        User user = new User();
        user.setuId(userDTO.getuId());
        user.setuNickname(userDTO.getNickname());
        user.setuEmail(userDTO.getEmail());
        user.setuPassword(userDTO.getPassword());
        user.setuPhonenum(userDTO.getPhoneNum());
        userMapper.updateByPrimaryKeySelective(user);
        return new RestResultBuilder().setMsg("修改成功").setCode(ResultCode.SUCCESS.getCode()).build();
    }


    /**
     * 查找用户
     * @param account
     * @return
     */
    @Override
    public RestResult findUserByUserAccount(String account) {
        if (account==null){
            return new RestResultBuilder().setMsg("账号为空").setCode(ResultCode.ERROR.getCode()).build();
        }
        User user = userMapper.selectByUserPhoneNum(account);
        List<User> users = new ArrayList<>();
        users.add(user);
        return new RestResultBuilder().setData(users).setMsg("查找成功").setCode(ResultCode.SUCCESS.getCode()).build();
    }

    /**
     * 删除用户
     * @param uId
     * @return
     */
    @Override
    public RestResult deleteUser(String uId) {
        if (uId==null){
            return new RestResultBuilder().setMsg("用户id为空").setCode(ResultCode.SUCCESS.getCode()).build();
        }
       int n = userMapper.deleteByPrimaryKey(uId);
        return new RestResultBuilder().setMsg("删除成功").setCode(ResultCode.SUCCESS.getCode()).build();
    }


    /**
     * 房管员列表
     * @return
     */
    @Override
    public RestResult houserKeeperList() {
        List<HouseKeeper> houseKeepers = houseKeeperMapper.getHouserKeeperList();
        return new RestResultBuilder().setData(houseKeepers).setMsg("房管列表").setCode(ResultCode.SUCCESS.getCode()).build();
    }

    /**
     * 添加房管
     * @return
     */
    @Override
    public RestResult insertHouserKeeper(HouseKeeper houseKeeper) {
        if (houseKeeper==null){
            return new RestResultBuilder().setMsg("添加失败").setCode(ResultCode.ERROR.getCode()).build();
        }
        HouseKeeper houseKeeper1 = new HouseKeeper();
        houseKeeper1.setHkId(UUIDUtils.UUIDGenerate());
        houseKeeper1.setHkName(houseKeeper.getHkName());
        houseKeeper1.setHkPhonenum(houseKeeper.getHkPhonenum());
        int n = houseKeeperMapper.insertSelective(houseKeeper1);
        return new RestResultBuilder().setMsg("添加成功").setCode(ResultCode.SUCCESS.getCode()).build();
    }

    /**
     * 修改
     * @param houseKeeper
     * @return
     */
    @Override
    public RestResult updateHouserKeeper(HouseKeeper houseKeeper) {
        if (houseKeeper.getHkId()==null){
            return new RestResultBuilder().setMsg("房管员id为空").setCode(ResultCode.ERROR.getCode()).build();
        }
        houseKeeperMapper.updateByPrimaryKeySelective(houseKeeper);
        return new RestResultBuilder().setMsg("修改成功").setCode(ResultCode.SUCCESS.getCode()).build();
    }


    /**
     *
     * @param houseKeeper
     * @return
     */
    @Override
    public RestResult findHouserByPhone(HouseKeeper houseKeeper) {
        String account = houseKeeper.getHkPhonenum();
        if (account==null){
            return new RestResultBuilder().setMsg("账号为空").setCode(ResultCode.ERROR.getCode()).build();
        }
        HouseKeeper houseKeeper1 = houseKeeperMapper.getHouserByPhone(account);
        List<HouseKeeper> houseKeepers = new ArrayList<>();
        houseKeepers.add(houseKeeper1);
        return new RestResultBuilder().setData(houseKeepers).setMsg("查找成功").setCode(ResultCode.SUCCESS.getCode()).build();
    }


    /**
     * 删除房管
     * @return
     */
    @Override
    public RestResult deleteKeeper(HouseKeeper houseKeeper) {
        if (houseKeeper.getHkId()==null){
            return new RestResultBuilder().setMsg("房管Id为空").setCode(ResultCode.ERROR.getCode()).build();
        }
        houseKeeperMapper.deleteByPrimaryKey(houseKeeper.getHkId());
        return new RestResultBuilder().setMsg("删除成功").setCode(ResultCode.SUCCESS.getCode()).build();
    }


    /**
     * 房源列表
     * @return
     */
    @Override
    public RestResult roomList(KeyWordsDTO keyWordsDTO) {
        List<Room> rooms = roomMapper.getRoomList();
       return new RestResultBuilder().setData(rooms).setMsg("房源列表").setCode(ResultCode.SUCCESS.getCode()).build();
    }

    /**
     * 房源统计
     * @return
     */
    @Override
    public RestResult roomAdministrationCount() {
        List<Map> list = roomMapper.roomAdministrationCount();
        return new RestResultBuilder().setData(list).setMsg("房源统计数据").setCode(ResultCode.SUCCESS.getCode()).build();
    }

    /**
     * 房管员统计
     * @return
     */
    @Override
    public RestResult hkCount() {
        List<Map> list = houseKeeperMapper.hkCount();
        return new RestResultBuilder().setData(list).setMsg("房管员统计数据").setCode(ResultCode.SUCCESS.getCode()).build();
    }

    /**
     * 用户租房占比
     * @return
     */
    @Override
    public RestResult userGetRoomCount() {
        Integer totalNum = userMapper.getUserCountNum();//用户总数
        List list = userMapper.userGetRoomNum();
        Integer rentAlreadyNum = list.size();//已租用户数量
        Integer noRentNum = totalNum- rentAlreadyNum;//未租数量
        List<Map> resultMap = new ArrayList<>();
        Map map = new HashMap();
        Map map1 = new HashMap();
        map.put("name","未租");
        map.put("value",noRentNum);
        map1.put("name","已租");
        map1.put("value",rentAlreadyNum);
        resultMap.add(map);
        resultMap.add(map1);
        return new RestResultBuilder().setData(resultMap).setMsg("用户统计数据").setCode(ResultCode.SUCCESS.getCode()).build();
    }


    /**
     * 地铁统计
     * @return
     */
    @Override
    public RestResult subwayCount() {
        List<Map> list = roomMapper.roomAdminSubwayCount();
        return new RestResultBuilder().setData(list).setMsg("房屋地铁统计数据").setCode(ResultCode.SUCCESS.getCode()).build();
    }


    /**
     * 价格统计
     * @return
     */
    @Override
    public RestResult priceCount() {
        List<Map> list = roomMapper.priceCount();
        return new RestResultBuilder().setData(list).setMsg("房屋价格统计数据").setCode(ResultCode.SUCCESS.getCode()).build();
    }

    /**
     *
     * @param file
     * @return
     */
    @Override
    public RestResult uploadExcel(MultipartFile file) throws FileNotFoundException {
        try {
            InputStream is = file.getInputStream();
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
            XSSFRow titleCell = xssfSheet.getRow(0);
            List<Room> roomlist = new ArrayList<>();
            List<Atlas> atlasList = new ArrayList<>();
            for (int i = 1; i <= xssfSheet.getLastRowNum(); i++) {
                XSSFRow xssfRow = xssfSheet.getRow(i);
                int minCell = xssfRow.getFirstCellNum();
                int maxCell = xssfRow.getLastCellNum();
                XSSFCell price1 = xssfRow.getCell(0);
                String price = price1.toString();//价格
                if (price==null){
                    break;
                }
                XSSFCell orientation1 = xssfRow.getCell(1);
                String orientation = orientation1.toString();//朝向
                XSSFCell village1 = xssfRow.getCell(2);
                String village = village1.toString();//小区
                XSSFCell aID1 = xssfRow.getCell(3);
                String aID = aID1.toString();//行政区域id
                XSSFCell floor1 = xssfRow.getCell(4);
                Double floor = floor1.getNumericCellValue() ;//楼层
                XSSFCell totalFloor1 = xssfRow.getCell(5);
                Double totalFloor = totalFloor1.getNumericCellValue();
                XSSFCell rsID1 = xssfRow.getCell(6);
                String rsId = rsID1.toString();
                XSSFCell rhkId1 = xssfRow.getCell(7);
                String rhkId= rhkId1.toString();
                XSSFCell url1 = xssfRow.getCell(8);
                String url4 = url1.toString();
                XSSFCell url2 = xssfRow.getCell(9);
                String url5 = url2.toString();
                XSSFCell url3 = xssfRow.getCell(10);
                String url6 = url3.toString();
                //实例room
                Room room = new Room();
                String roomId = UUIDUtils.UUIDGenerate();
                room.setrId(roomId);
                room.setrPrice(Float.valueOf(price));
                room.setrOrientation(orientation);
                room.setrVillage(village);
                room.setrAId(aID);
                room.setrFloor(floor.intValue());
                room.setrTotalFloor(totalFloor.intValue());
                room.setrSId(rsId);
                room.setrHouseKeeperId(rhkId);
                room.setrCreatetime(new Date());
                roomlist.add(room);
                //实例图集
                Atlas atlas = new Atlas();
                atlas.setAtId(UUIDUtils.UUIDGenerate());
                atlas.setAtUrl(url4);
                atlas.setrId(roomId);
                atlasList.add(atlas);
                Atlas atlas1 = new Atlas();
                atlas1.setAtId(UUIDUtils.UUIDGenerate());
                atlas1.setAtUrl(url5);
                atlas1.setrId(roomId);
                atlasList.add(atlas1);
                Atlas atlas2 = new Atlas();
                atlas2.setAtId(UUIDUtils.UUIDGenerate());
                atlas2.setAtUrl(url6);
                atlas2.setrId(roomId);
                atlasList.add(atlas2);
            }
            System.out.println("aa"+roomlist+"AA"+roomlist.size());
            System.out.println("bb"+atlasList+"BB"+atlasList.size());
            roomMapper.insertByBach(roomlist);
            atlasMapper.insertByBach(atlasList);
        } catch (IOException e) {
            e.printStackTrace();
            return new RestResultBuilder().setMsg("添加失败").setData(ResultCode.ERROR.getCode()).build();
        }
        return new RestResultBuilder().setMsg("添加成功").setData(ResultCode.SUCCESS.getCode()).build();
    }

    /**
     * 删除
     * @param roomDTO
     * @return
     */
    @Override
    public RestResult deleteRoomById(RoomDTO roomDTO) {
        if (roomDTO.getrId()==null){
            return new RestResultBuilder().setMsg("id为空").setData(ResultCode.SUCCESS.getCode()).build();
        }
        String rId = roomDTO.getrId();
        roomMapper.deleteByPrimaryKey(rId);
        return new RestResultBuilder().setMsg("删除成功").setData(ResultCode.SUCCESS.getCode()).build();
    }
}
