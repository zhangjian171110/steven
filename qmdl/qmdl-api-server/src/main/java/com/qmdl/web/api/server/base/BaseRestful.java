package com.qmdl.web.api.server.base;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.creditstate.cn.utils.CSJSONUtils;
import com.qmdl.web.api.model.base.ResultData;

/**
 * {该处请说明该class的含义和作用}
 *  
 *  @author Steven Zhang
 *  @lastModified       
 *  @history           
 */
public class BaseRestful {

	/**
	 * LOG
	 */
	private static Logger LOG = Logger.getLogger(BaseRestful.class);
	
	/**
	 * 
	 *  {返回状态200}
	 *  @param resultData
	 *  @return
	 *  @author Steven Zhang
	 *  @created 2016年7月18日 上午11:16:07
	 *  @lastModified       
	 *  @history
	 */
	public Response toResponse(ResultData resultData){
		if(resultData!=null && resultData.getResult()==null){
			resultData.setResult("");
		}
		return Response.status(200).entity(resultData).build();
	}
	
	/**
	 * 
	 *  {将返回响应转成字符串}
	 *  @param resultData
	 *  @return String
	 *  @author Steven Zhang
	 *  @created 2016年7月18日 上午11:20:02
	 *  @lastModified       
	 *  @history
	 */
	public String toJson(ResultData resultData) {
		if(resultData!=null && resultData.getResult()==null){
			resultData.setResult("");
		}
		convertMapNull(resultData.getResult());
		String jsonStr = CSJSONUtils.toJson(resultData);
		LOG.info("接口返回结果为:"+jsonStr);
		return jsonStr; 
	}
	
	/**
	 * 
	 *  {转换map、list}
	 *  @param srcObj
	 *  @author Steven Zhang
	 *  @created 2016年7月18日 上午11:17:35
	 *  @lastModified       
	 *  @history
	 */
	@SuppressWarnings({ "unchecked" })
	private void convertMapNull(Object srcObj){
		if(srcObj instanceof Map){
			Map<Object,Object> resultMap = (Map<Object,Object>)srcObj;
			for(Object key:resultMap.keySet()){
				if(resultMap.get(key)==null)
					resultMap.put(key, "");
			}
		}
		if(srcObj instanceof List){
			List<Object> resultList = (List<Object>)srcObj;
			for(Object res:resultList){
				convertMapNull(res);
			}
		}
	}

}




