package com.qmdl.web.api.model.base;

/**
 * {错误代码}
 *  
 *  @author Steven Zhang
 *  @lastModified       
 *  @history           
 */
public enum ResultCodeMsg {
	//自行定义
	INVALID_INTERACE("4001","接口未定义(4001)"),
	INVALID_TOKEN("4002","不合格token令牌(4002)"),
	INVALID_IP("4003","非法请求IP(4003)"),
	INVALID_AUTH("4004","接口权限不足(4004)"),
	INVALID_PARAMS_LOSE("4005","缺少请求数据(4005)"),
	INVALID_PARAMS_NULL("4006","参数不为空(4006)"),
	INVALID_PARAMS_FORMAT("4007","参数不是标准格式(4007)"),
	INVALID_PARAMS_FAIL("4008","获取请求数据失败(4008)"),
	SAVE_INFO_FAIL("4009","保存数据失败(4009)"),
	INVALID_DATE_FORMAT("4010","时间不是标准格式(4010)"),
	SYSTEM_EXCEPTION("5000","远程服务异常(5000)"),
	SYSTEM_TIMEOUT("5001","请求远程服务超时(5001)");
	
	private String resultCode;
	
	private String resultMsg;
	
	private ResultCodeMsg(String resultCode,String resultMsg){
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}
	
	public String getResultCode(){
		return this.resultCode;
	}
	
	public String getResultMsg(){
		return this.resultMsg;
	}
}




