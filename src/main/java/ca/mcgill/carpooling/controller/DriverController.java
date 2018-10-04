package ca.mcgill.carpooling.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import ca.mcgill.carpooling.model.user.Driver;
import ca.mcgill.carpooling.service.user.DriverService;

@Controller
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
//	@RequestMapping(value="/driver/login")
//	public @ResponseBody Object login(HttpServletRequest request,
//			@RequestParam (value="phone",required=true) String phone,
//			@RequestParam (value="pwd",required=true) String pwd) {
//		
//		Map<String,Object> retMap = new ConcurrentHashMap<String,Object>();
//		//后台再次对接收到的参数进行验证
//		if(StringUtils.isEmpty(phone)) {
//			retMap.put("errorMessage", "Please enter phone number.");
//			return retMap;
//		}
//		
//		if(!Pattern.matches("^1[1-9]\\d{9}$", phone)) {
//			retMap.put("errorMessage", "Please enter valid phone number.");
//			return retMap;
//		}
//		
//		if(StringUtils.isEmpty(pwd)) {
//			retMap.put("errorMessage", "Please enter password.");
//			return retMap;
//		}
//		
//		//------------------login-------------------
//		Driver driver = new Driver();
//		driver.setPhone(phone);
//		driver.setPwd(pwd);
//		Driver sessionDriver = driverService.login(driver);
//		//check if the driver information in in database.
//		if(null == sessionDriver) {
//			//Failed
//			retMap.put("errorMessage", "Incorrect username or password.");
//			return retMap;
//		}
//		
//		//Successed
//		retMap.put("errorMessage", "ok");
//		
//		return retMap;
//	}
	
}
