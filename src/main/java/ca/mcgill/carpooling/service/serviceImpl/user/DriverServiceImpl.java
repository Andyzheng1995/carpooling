package ca.mcgill.carpooling.service.serviceImpl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

import ca.mcgill.carpooling.mapper.user.DriverMapper;
import ca.mcgill.carpooling.model.user.Driver;
import ca.mcgill.carpooling.model.vo.ResultObject;
import ca.mcgill.carpooling.service.user.DriverService;
import ca.mcgill.carpooling.utils.MD5Util;

@Service("DriverServiceImpl")
public class DriverServiceImpl implements DriverService{

	@Autowired
	private DriverMapper driverMapper;
	
	
	@Override
	public ResultObject addDriver(Map<String, Object> paramMap) {
		ResultObject resultObject = new ResultObject();
		resultObject.setErrorCode(1);
		resultObject.setErrorMsg("Registeration success!");
		
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		String name = (String) paramMap.get("name");
		String phone = (String) paramMap.get("phone");
		String pwd = "";
		String licence_no = (String) paramMap.get("licence_no");
		try {
			pwd = MD5Util.getMD5Str((String) paramMap.get("pwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String age = (String) paramMap.get("age");
		String sex = (String) paramMap.get("sex");
		
		Driver driver = new Driver();
		
		if (name == null || phone == null || pwd == "" || licence_no == "null" || age == "null" || sex == "null") {
			resultObject.setErrorCode(0);
			resultObject.setErrorMsg("Information not complete!");
		} else {
			driver.setId(id);
			driver.setName(name);
			driver.setPhone(phone);
			driver.setLicence_no(licence_no);
			driver.setPwd(pwd);
			driver.setAge(age);
			driver.setSex(sex);
			int errorCode = driverMapper.insertDriver(driver);
			String errorMsg = "";
			if (errorCode == 0) {
				errorMsg = "Fail to insert information into database, please double-check information.";
			} else {
				errorMsg = "Registration success!";
			}
			resultObject.setErrorCode(errorCode);
			resultObject.setErrorMsg(errorMsg);
		}
		
		return resultObject;
	}
	
}
