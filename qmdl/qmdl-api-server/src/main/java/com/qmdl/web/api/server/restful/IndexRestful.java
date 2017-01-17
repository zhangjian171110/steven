package com.qmdl.web.api.server.restful;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import com.creditstate.cn.utils.CSStringUtils;
import com.qmdl.web.api.model.base.ResultCodeMsg;
import com.qmdl.web.api.model.base.ResultData;
import com.qmdl.web.api.model.entity.CarouselInfoRequest;
import com.qmdl.web.api.model.entity.IsUpdateRequest;
import com.qmdl.web.api.model.tools.IndexTools;
import com.qmdl.web.api.server.base.BaseRestful;
import com.qmdl.web.model.entity.CarouselInfo;

@Controller
@Path("/index")
public class IndexRestful extends BaseRestful{
	
	@Resource
	private IndexTools indexTools;
	
	/**
	 * 自动更新
	 * @param isUpdateRequest
	 * @return
	 */
	@POST
	@Path("/isUpdate")
	public String isPhone(@BeanParam IsUpdateRequest isUpdateRequest) {
		ResultData resultData = new ResultData();
		// 判断参数是否为空
		if (CSStringUtils.isEmpty(isUpdateRequest.getVersion(),isUpdateRequest.getPhoneType())) {
			resultData.setResultCode(ResultCodeMsg.INVALID_PARAMS_NULL.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.INVALID_PARAMS_NULL.getResultMsg());
			return toJson(resultData);
		}
		try {
			Map<String, Object> map = indexTools.isUpdate(isUpdateRequest.getVersion(),isUpdateRequest.getPhoneType());
			resultData.setResult(map);
			return toJson(resultData);
		} catch (Exception e) {
			resultData.setResultCode(ResultCodeMsg.SYSTEM_EXCEPTION.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.SYSTEM_EXCEPTION.getResultMsg());
			return toJson(resultData);
		}
	} 
	
	/**
	 * 轮播图
	 * @param carouselInfoRequest
	 * @return
	 */
	@POST
	@Path("/carousel")
	public String getCarouselInfo(@BeanParam CarouselInfoRequest carouselInfoRequest) {
		ResultData resultData = new ResultData();
		// 判断参数是否为空
		if (CSStringUtils.isEmpty(carouselInfoRequest.getType())) {
			resultData.setResultCode(ResultCodeMsg.INVALID_PARAMS_NULL.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.INVALID_PARAMS_NULL.getResultMsg());
			return toJson(resultData);
		}
		try {
			List<Map<String,Object>> list = indexTools.getCarouselInfo(carouselInfoRequest.getType());
			resultData.setResult(list);
			return toJson(resultData);
		} catch (Exception e) {
			resultData.setResultCode(ResultCodeMsg.SYSTEM_EXCEPTION.getResultCode());
			resultData.setResultMsg(ResultCodeMsg.SYSTEM_EXCEPTION.getResultMsg());
			return toJson(resultData);
		}
	} 
}
