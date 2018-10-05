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
	public ResultObject addDriver(Driver driver) {
		ResultObject resultObject = new ResultObject();
		resultObject.setErrorCode(1);
		resultObject.setErrorMsg("Registeration success!");
		
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		String name = driver.getName();
		String phone = driver.getPhone();
		String pwd = "";
		String licence_no = driver.getLicence_no();
		try {
			pwd = MD5Util.getMD5Str(driver.getPwd());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String age = driver.getAge();
		String sex = driver.getSex();
		
		if (name == null || phone == null || pwd == "" || licence_no == "null" || age == "null" || sex == "null") {
			resultObject.setErrorCode(0);
			resultObject.setErrorMsg("Information not complete!");
		} else {
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
