package com.li.house.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.li.house.api.AppointmentService;
import com.li.house.common.config.AliPayConfig;
import com.li.house.common.domain.Appointment;
import com.li.house.common.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Controller
public class PayController {

	@Autowired
	private AppointmentService appointmentService;

	/**
	 * 支付宝支付
	 * @param map
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "pay",method = RequestMethod.POST)
	public void pay(@RequestBody Map<String,Object> map,
					HttpServletRequest request,
					HttpServletResponse response) {
		System.out.println(map.get("WIDout_trade_no"));
		try {
		if(map.get("WIDout_trade_no")!=null){
			// 商户订单号，商户网站订单系统中唯一订单号，必填
		    String out_trade_no = map.get("WIDout_trade_no").toString();
			// 订单名称，必填
		    String subject = map.get("WIDsubject").toString();
		    // 付款金额，必填
		    String total_amount= map.get("WIDtotal_amount").toString();
		    // 商品描述，可空
		    String body = map.get("WIDbody").toString();
		    // 超时时间 可空
		   String timeout_express="2m";
		    // 销售产品码 必填
		    String product_code="QUICK_WAP_WAY";
		    /**********************/
		    // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签     
		    //调用RSA签名方式
			AlipayClient client = new DefaultAlipayClient(AliPayConfig.URL, AliPayConfig.APPID,
					AliPayConfig.RSA_PRIVATE_KEY, AliPayConfig.FORMAT,
					AliPayConfig.CHARSET, AliPayConfig.ALIPAY_PUBLIC_KEY,AliPayConfig.SIGNTYPE);
		    AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();
		    // 封装请求支付信息
		    AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
		    model.setOutTradeNo(out_trade_no);
		    model.setSubject(subject);
		    model.setTotalAmount(total_amount);
		    model.setBody(body);
		    model.setTimeoutExpress(timeout_express);
		    model.setProductCode(product_code);
		    alipay_request.setBizModel(model);
		    // 设置异步通知地址
		    alipay_request.setNotifyUrl(AliPayConfig.notify_url);
		    // 设置同步地址
		    alipay_request.setReturnUrl(AliPayConfig.return_url);
		    // form表单生产
		    String form = "";
			// 调用SDK生成表单
				form = client.pageExecute(alipay_request).getBody();
				response.setContentType("text/html;charset=" + AliPayConfig.CHARSET);
			    response.getWriter().write(form);//直接将完整的表单html输出到页面 
			    response.getWriter().flush(); 
			    response.getWriter().close();
			String uId = map.get("UID").toString();
			String rId = map.get("RID").toString();
			Appointment appointment = new Appointment();
			appointment.setApId(UUIDUtils.UUIDGenerate());
			appointment.setrId(rId);
			appointment.setuId(uId);
			appointment.setOrderNum(out_trade_no);
			appointment.setPrice(total_amount);
			appointment.setApCreatetime(new Date());
			appointment.setApLooktime(new Date());
			appointmentService.insertOrder(appointment);
		}else{
			   response.setContentType("text/html;charset=" + AliPayConfig.CHARSET);
			   response.getWriter().write("test");//直接将完整的表单html输出到页面 
			    response.getWriter().flush(); 
			    response.getWriter().close();
		}
			} catch (Exception e) {
				e.printStackTrace();
			} 
}
	
	@RequestMapping("result")
	public void payreturn(@RequestBody Map<String,Object> map, HttpServletRequest request, HttpServletResponse response) {
		try {
				System.out.println("===============>");
		
			} catch (Exception e) {
				e.printStackTrace();
			} 
}
}
