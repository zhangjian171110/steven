package com.qmdl.web.api.model.base;

/**
 * {返回结果封装类}
 *  
 *  @author Steven Zhang
 *  @created 2016年7月18日
 *  @lastModified       
 *  @history           
 */
public class ResultData {
	
	public static final String RESULT_CODE_SUCCESS = "0000";

	// 业务结果码
	private String resultCode;

	// 返回消息
	private String resultMsg;

	// 返回结果集
	private Object result;
	
	public ResultData() {
		this.resultCode = RESULT_CODE_SUCCESS;
		this.resultMsg = "成功(0000)";
	}

	public ResultData(String resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
}




