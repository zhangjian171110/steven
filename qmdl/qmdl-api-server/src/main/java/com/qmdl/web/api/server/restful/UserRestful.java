package com.qmdl.web.api.server.restful;

import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import com.creditstate.cn.utils.CSStringUtils;
import com.qmdl.web.api.model.base.ResultCodeMsg;
import com.qmdl.web.api.model.base.ResultData;
import com.qmdl.web.api.model.entity.UserRequest;
import com.qmdl.web.api.model.tools.UserTools;
import com.qmdl.web.api.server.base.BaseRestful;

@Controller
@Path("/user")
public class UserRestful extends BaseRestful{
	
	@Resource
	private UserTools userTools;
	
	@POST
	@Path("/register")
	public String register(@FormParam("phone") String phone,@FormParam("nickname") String nickname,
			@FormParam("password") String password) {
		ResultData resultData = new ResultData();
		// 判断参数是否为空
		if (CSStringUtils.isEmpty(phone,nickname,password)) {
			resultData.setResultCode(ResultCodeMsg.INVALID_PARAMS_NULL.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.INVALID_PARAMS_NULL.getResultMsg());
			return toJson(resultData);
		}
		try {
			resultData = userTools.register(phone,nickname,password);
			return toJson(resultData);
		} catch (Exception e) {
			resultData.setResultCode(ResultCodeMsg.SYSTEM_EXCEPTION.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.SYSTEM_EXCEPTION.getResultMsg());
			return toJson(resultData);
		}
	}
	
	@POST
	@Path("/login")
	public String login(@BeanParam UserRequest userRequest) {
		ResultData resultData = new ResultData();
		// 判断参数是否为空
		if (CSStringUtils.isEmpty(userRequest.getPhone(),userRequest.getPassword(),
				userRequest.getPhoneType())) {
			resultData.setResultCode(ResultCodeMsg.INVALID_PARAMS_NULL.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.INVALID_PARAMS_NULL.getResultMsg());
			return toJson(resultData);
		}
		try {
			resultData = userTools.login(userRequest.getPhone(),userRequest.getPassword(),
					userRequest.getPhoneType(),userRequest.getDeviceId());
			return toJson(resultData);
		} catch (Exception e) {
			resultData.setResultCode(ResultCodeMsg.SYSTEM_EXCEPTION.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.SYSTEM_EXCEPTION.getResultMsg());
			return toJson(resultData);
		}
	}
	
	@POST
	@Path("/isPhone")
	public String isPhone(@FormParam("phone") String phone) {
		ResultData resultData = new ResultData();
		// 判断参数是否为空
		if (CSStringUtils.isEmpty(phone)) {
			resultData.setResultCode(ResultCodeMsg.INVALID_PARAMS_NULL.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.INVALID_PARAMS_NULL.getResultMsg());
			return toJson(resultData);
		}
		try {
			Map<String,Object> map = userTools.isPhone(phone);
			resultData.setResult(map);
			return toJson(resultData);
		} catch (Exception e) {
			resultData.setResultCode(ResultCodeMsg.SYSTEM_EXCEPTION.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.SYSTEM_EXCEPTION.getResultMsg());
			return toJson(resultData);
		}
	}
	
	@POST
	@Path("/updatePassword")
	public String updatePassword(@FormParam("phone") String phone,@FormParam("password") String password) {
		ResultData resultData = new ResultData();
		// 判断参数是否为空
		if(CSStringUtils.isEmpty(phone,password)) {
			resultData.setResultCode(ResultCodeMsg.INVALID_PARAMS_NULL.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.INVALID_PARAMS_NULL.getResultMsg());
			return toJson(resultData);
		}
		try {
			resultData = userTools.updatePassword(phone,password);
			return toJson(resultData);
		} catch (Exception e) {
			resultData.setResultCode(ResultCodeMsg.SYSTEM_EXCEPTION.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.SYSTEM_EXCEPTION.getResultMsg());
			return toJson(resultData);
		}
	}
	
	@POST
	@Path("/updateUser")
	public String updateUserInfo(@FormParam("userid") String userid,@FormParam("nickname") String nickname,
			@FormParam("introduction") String introduction,@FormParam("imageAddress") String imageAddress,
			@FormParam("fhAddress") String fhAddress) {
		ResultData resultData = new ResultData();
		// 判断参数是否为空
		if(CSStringUtils.isEmpty(userid)) {
			resultData.setResultCode(ResultCodeMsg.INVALID_PARAMS_NULL.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.INVALID_PARAMS_NULL.getResultMsg());
			return toJson(resultData);
		}
		try {
			resultData = userTools.updateUserInfo(userid,nickname,introduction,imageAddress,fhAddress);
			return toJson(resultData);
		} catch (Exception e) {
			resultData.setResultCode(ResultCodeMsg.SYSTEM_EXCEPTION.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.SYSTEM_EXCEPTION.getResultMsg());
			return toJson(resultData);
		}
	}
}
