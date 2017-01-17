package com.qmdl.web.api.model.tools;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creditstate.cn.utils.CSStringUtils;
import com.qmdl.web.api.model.base.ResultData;
import com.qmdl.web.data.service.IUserService;
import com.qmdl.web.model.entity.User;

@Component
public class UserTools {

	@Autowired
	private IUserService iUserService;

	public ResultData register(String phone, String nickname, String password) {
		ResultData resultData = new ResultData();
		// 检查手机是否已被注册
		User regUser = new User();
		regUser.setTelephone(phone);
		User userPhone = iUserService.selectOne(regUser);
		if (CSStringUtils.isEmpty(userPhone)) {
			User user = new User();
			user.setTelephone(phone);
			user.setNickname(nickname);
			user.setPassword(password);
			user.setGmtCreate(new Date());
			user.setGmtModified(new Date());
			user.setRole("0");
			if (!iUserService.insertSelective(user)) {
				resultData.setResultCode("2002");
				resultData.setResultMsg("注册失败");
			} 
		} else {
			resultData.setResultCode("2001");
			resultData.setResultMsg("手机号已经存在");
		}
		return resultData;
	}

	public ResultData login(String phone, String password,String phoneType,String deviceId) {
		ResultData resultData = new ResultData();
		User userR = new User();
		userR.setTelephone(phone);
		userR.setPassword(password);
		User user = iUserService.selectOne(userR);
		if (!CSStringUtils.isEmpty(user)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userid", user.getId());
			map.put("phone", user.getTelephone());
			map.put("nickname", user.getNickname());
			map.put("introduction", user.getIntroduction());
			map.put("imageAddress", user.getProfileAddress());
			map.put("role", user.getRole());// 0:代理 1：供应商
			map.put("fhAddress", user.getConsignerAddress());// 发货地址
			
			resultData.setResult(map);
			
			User setUser = new User();
			setUser.setPhoneType(phoneType);
			setUser.setLoginTime(new Date());
			setUser.setGmtModified(new Date());
			setUser.setDeviceId(deviceId);
			
			User whereUser = new User();
			whereUser.setTelephone(phone);
			iUserService.updateSelective(setUser, whereUser);
		} else {
			resultData.setResultCode("2001");
			resultData.setResultMsg("用户名或密码错误");
		}
		return resultData;
	}

	public Map<String, Object> isPhone(String phone) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 检查手机是否已存在
		User regUser = new User();
		regUser.setTelephone(phone);
		User userPhone = iUserService.selectOne(regUser);
		if (CSStringUtils.isEmpty(userPhone)) {
			map.put("flag", "0");
			map.put("message", "手机号未注册");
		} else {
			map.put("flag", "1");
			map.put("message", "手机号已经存在");
		}
		return map;
	}
	
	public ResultData updatePassword(String phone, String password) {
		ResultData resultData = new ResultData();
		User user = new User();
		user.setPassword(password);
		user.setGmtModified(new Date());
		User whereUser = new User();
		whereUser.setTelephone(phone);
		if(!iUserService.updateSelective(user, whereUser)){
			resultData.setResultCode("2001");
			resultData.setResultMsg("修改密码失败");
		}
		return resultData;
	}

	public ResultData updateUserInfo(String userid, String nickname, String introduction,
			String imageAddress, String fhAddress) {
		ResultData resultData = new ResultData();
		User user = new User();
		if (!CSStringUtils.isEmpty(nickname)) {
			user.setNickname(nickname);
		}
		if (!CSStringUtils.isEmpty(introduction)) {
			user.setIntroduction(introduction);
		}
		if (!CSStringUtils.isEmpty(imageAddress)) {
			user.setProfileAddress(imageAddress);
		}
		if (!CSStringUtils.isEmpty(fhAddress)) {
			user.setConsignerAddress(fhAddress);
		}
		user.setGmtModified(new Date());
		User whereUser = new User();
		whereUser.setId(userid);
		if(!iUserService.updateSelective(user, whereUser)){
			resultData.setResultCode("2001");
			resultData.setResultMsg("修改用户信息失败");
		}
		return resultData;
	}

}
