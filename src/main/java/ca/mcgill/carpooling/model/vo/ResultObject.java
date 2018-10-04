package ca.mcgill.carpooling.model.vo;

public class ResultObject {
	
/*	
 * For insert, update and delete method, errorCode presenting the state.
 * 0 stands for fail, 1 stands for success.
 */	
	private int errorCode;
	private String errorMsg;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
