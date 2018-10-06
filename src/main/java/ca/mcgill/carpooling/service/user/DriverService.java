package ca.mcgill.carpooling.service.user;

import ca.mcgill.carpooling.model.user.Driver;
import ca.mcgill.carpooling.model.vo.ResultObject;

public interface DriverService {
	
	ResultObject addDriver (Driver driver);
	
	Driver queryDriverByPhone (String phone);

}
