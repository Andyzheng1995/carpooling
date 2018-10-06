package ca.mcgill.carpooling.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.mcgill.carpooling.model.user.Driver;
import ca.mcgill.carpooling.model.user.Passenger;
import ca.mcgill.carpooling.model.vo.ResultObject;
import ca.mcgill.carpooling.service.user.DriverService;
import ca.mcgill.carpooling.utils.MD5Util;

@Controller
@RequestMapping(value="/user")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@RequestMapping(value="/login")
	public @ResponseBody Object login(HttpServletRequest request,
			@RequestParam (value="phone",required=true) String phone,
			@RequestParam (value="pwd",required=true) String pwd,
			@RequestParam (value="role",required=true) String role) {
		
		Map<String,Object> retMap = new ConcurrentHashMap<String,Object>();

		if(StringUtils.isEmpty(phone)) {
			retMap.put("errorMessage", "Please enter phone number.");
			return retMap;
		}
		
		if(!Pattern.matches("^1[1-9]\\d{9}$", phone)) {
			retMap.put("errorMessage", "Please enter valid phone number.");
			return retMap;
		}
		
		if(StringUtils.isEmpty(pwd)) {
			retMap.put("errorMessage", "Please enter password.");
			return retMap;
		}
		
		if (StringUtils.isEmpty(role)) {
			retMap.put("errorMessage", "Please select role.");
		}
		
		//------------------login-------------------
		if ("0".equals(role)) {
			//admin
			return retMap;
		} else if ("1".equals(role)) {
			Driver driver = driverService.queryDriverByPhone(phone);
			if (driver != null) {
				try {
					if (driver.getPwd().equals(MD5Util.getMD5Str(pwd))){
						retMap.put("errorMessage","Successully login.");
						return retMap;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} else {
				retMap.put("errorMessage","Invalid phone number or password.");
				return retMap;
			}
		} else if ("2".equals(role)) {
			//passenger
			return retMap;
		}
		return retMap;
	}
//  The idea of "method" is to limit request access to ajax and html form submit
	@RequestMapping(value="/driver/register", method=RequestMethod.POST)
	public @ResponseBody Object register (HttpServletRequest request,
			@RequestParam (value="name",required=true) String name,
			@RequestParam (value="phone",required=true) String phone,
			@RequestParam (value="pwd",required=true) String pwd,
			@RequestParam (value="repwd",required=true) String repwd,
			@RequestParam (value="licence_no",required=true) String licence_no,
			@RequestParam (value="sex",required=true) String sex,
			@RequestParam (value="age",required=true) String age) {
		Map<String, Object> retMap = new ConcurrentHashMap<>();
		
		//backend confirmation of input information
		if(StringUtils.isEmpty(phone)) {
			retMap.put("errorMessage", "Please enter phone number.");
			return retMap;
		}
		
		if(!Pattern.matches("[1-9]\\d{9}$", phone)) {
			retMap.put("errorMessage", "Please enter valid phone number.");
			return retMap;
		}
		
		if(StringUtils.isEmpty(pwd)) {
			retMap.put("errorMessage", "Please enter password.");
			return retMap;
		}
		
		if(StringUtils.isEmpty(repwd)) {
			retMap.put("errorMessage", "Please confirm password.");
			return retMap;
		}
		
		if(!StringUtils.equals(pwd, repwd)) {
			retMap.put("errorMessage", "Password is not consistent.");
			return retMap;
		}
		
		if(StringUtils.isEmpty(licence_no)) {
			retMap.put("errorMessage", "Please enter licence number.");
			return retMap;
		}

		if(StringUtils.isEmpty(sex)) {
			retMap.put("errorMessage", "Please enter gender.");
			return retMap;
		}
		
		if(StringUtils.isEmpty(age)) {
			retMap.put("errorMessage", "Please enter age.");
			return retMap;
		}
		
		//------------------ check if the user existed -----------------//
		Driver driver = new Driver();
		driver.setAge(age);
		driver.setLicence_no(licence_no);
		driver.setName(name);
		driver.setPhone(phone);
		driver.setPwd(repwd);
		driver.setSex(sex);
		
		ResultObject resultObject = driverService.addDriver(driver);
		
		if (resultObject.getErrorCode()==1) {
			retMap.put("errorMessage", "Successfully create a driver");
			return retMap;
		}
		else {
			retMap.put("errorMessage", "Request failed");
			return retMap;
		}
	}
}
