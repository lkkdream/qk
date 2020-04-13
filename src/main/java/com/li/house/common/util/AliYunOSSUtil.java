package com.li.house.common.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.li.house.common.config.AliYunOSS;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class AliYunOSSUtil {

    public static String upload(File file){
        String bucketName =AliYunOSS.bucketname;
        String fileHost=AliYunOSS.file_filehost;
        String endpoint = AliYunOSS.endpoint;
        String accessKeyId = AliYunOSS.APPKEY;
        String accessKeySecret = AliYunOSS.SECRET;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());
        if(null == file){
            return "";
        }
        OSSClient ossClient =new OSSClient(endpoint,accessKeyId,accessKeySecret);
        try {
            //容器不存在，就创建
            if(! ossClient.doesBucketExist(bucketName)){
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //创建文件路径
            String fileUrl = fileHost+"/"+(dateStr + "/" + UUIDUtils.UUIDGenerate()+file.getName());
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);

            String url = "https://likuiting.oss-cn-shenzhen.aliyuncs.com/";
            if(null != result){
                System.out.println(url+fileUrl);
                return fileUrl;
            }
        }catch (OSSException oe){
            System.out.println((oe.getMessage()));

        }catch (ClientException ce){
            System.out.println((ce.getMessage()));
        }finally {
        ossClient.shutdown();
        }
        return null;
    }





    public static void main(String[] args) {
        File file = new File("F:\\chromedown\\b.jpg");
        System.out.println(file.getName());
        AliYunOSSUtil.upload(file);
    }

}
