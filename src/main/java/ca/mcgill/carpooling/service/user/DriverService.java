package ca.mcgill.carpooling.service.user;

import java.util.Map;

import ca.mcgill.carpooling.model.vo.ResultObject;

public interface DriverService {
	
	ResultObject addDriver (Map<String, Object> paramMap);

}
