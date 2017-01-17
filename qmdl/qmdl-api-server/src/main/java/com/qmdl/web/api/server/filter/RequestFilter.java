package com.qmdl.web.api.server.filter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import com.creditstate.cn.utils.CSStringUtils;
import com.qmdl.web.api.server.base.BaseRestful;


/**
 * {该处请说明该class的含义和作用}
 * 
 * @author zhangxiaota
 * @created 2016年7月12日
 * @lastModified
 * @history
 */
public class RequestFilter extends BaseRestful implements ContainerRequestFilter {
	
	/**
	 * LOG
	 */
	//private static Logger LOG = Logger.getLogger(RequestFilter.class);
	
	/**
	 * 常量
	 */
	private static final String METHOD_GET = "GET";
	private static final String METHOD_POST = "POST";
//	private static final String FILTER_URL = "/rest/";//拦截URL
	
	@Context
	HttpServletRequest request;
	@Context
	private HttpServletResponse response;
	
//	@Autowired
//	private InterfaceAuthService interfaceAuthService;
	
	/**
	 * 
	 *  @see 拦截器javax.ws.rs.container.ContainerRequestFilter#filter(javax.ws.rs.container.ContainerRequestContext)
	 *  @author Steven Zhang
	 *  @created 2016年7月22日 上午11:06:58
	 *  @lastModified      
	 *  @history
	 */
	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		
//		//获取接口方法名
//		String method = context.getMethod().toUpperCase();
//		//获取接口url
//		String uri = context.getUriInfo().getRequestUri().toString();
//		//获取头信息
		String headerString = context.getHeaderString("content-type");
//		//获取请求IP地址
//		String ipStr = getIpAddress(request);
		
//		if(uri.contains(FILTER_URL)){
//			long s =  System.currentTimeMillis();
//			//获取请求参数
//			String requestStr = getRequestStr(method, uri, context);
//			LOG.info("接口地址为："+uri+"||"+"请求参数为："+requestStr+"||"+"请求IP为："+ipStr);
//			//初始化返回实例
//			ResultData resultData = new ResultData();
//			if(!CSStringUtils.isEmpty(requestStr)){
//				//解析参数，并验证参数
//				Map<String,Object> map = splitParams(requestStr);
//				if(CSStringUtils.isEmpty(map.get("token"))||CSStringUtils.isEmpty(map.get("method"))){
//					resultData.setResultCode(ResultCodeMsg.INVALID_PARAMS_LOSE.getResultCode());
//					resultData.setResultMsg(ResultCodeMsg.INVALID_PARAMS_LOSE.getResultMsg());
//					context.abortWith(toResponse(resultData));
//					return;
//				}else{
//					//第一步：判断接口Token令牌是否合法
//					TApp app = interfaceAuthService.getByToken(map.get("token").toString());
//					if(CSStringUtils.isEmpty(app)){
//						resultData.setResultCode(ResultCodeMsg.INVALID_TOKEN.getResultCode());
//						resultData.setResultMsg(ResultCodeMsg.INVALID_TOKEN.getResultMsg());
//						context.abortWith(toResponse(resultData));
//						return;
//					}else{
//						//第二步：判断接口IP是否合法
//						if(app.getAppips().contains(ipStr)){
//							//第三步：判断接口是否合法
//							TInterface inter = interfaceAuthService.getByMethod(map.get("method").toString());
//							if(CSStringUtils.isEmpty(inter)){
//								resultData.setResultCode(ResultCodeMsg.INVALID_INTERACE.getResultCode());
//								resultData.setResultMsg(ResultCodeMsg.INVALID_INTERACE.getResultMsg());
//								context.abortWith(toResponse(resultData));
//								return;
//							}else{
//								//第四步：判断接口是否有权限
//								TAppInterface appInter = interfaceAuthService.getAppInterface(app.getAppid(), inter.getInterfaceid());
//								if(CSStringUtils.isEmpty(appInter) || !uri.contains(map.get("method").toString())){
//									resultData.setResultCode(ResultCodeMsg.INVALID_AUTH.getResultCode());
//									resultData.setResultMsg(ResultCodeMsg.INVALID_AUTH.getResultMsg());
//									context.abortWith(toResponse(resultData));
//									return;
//								}
//								LOG.info("接口验证成功:"+uri.contains(map.get("method").toString()));
//							}
//						}else{
//							resultData.setResultCode(ResultCodeMsg.INVALID_IP.getResultCode());
//							resultData.setResultMsg(ResultCodeMsg.INVALID_IP.getResultMsg());
//							context.abortWith(toResponse(resultData));
//							return;
//						}
//					}
//				}
//			}else{
//				resultData.setResultCode(ResultCodeMsg.INVALID_PARAMS_FAIL.getResultCode());
//				resultData.setResultMsg(ResultCodeMsg.INVALID_PARAMS_FAIL.getResultMsg());
//				context.abortWith(toResponse(resultData));
//				return;
//			}
//			//POST重新加载参数
//			if("POST".equals(method)){
//				InputStream   inputStream = CSStringUtils.stringToInputStream(requestStr);
//				context.setEntityStream(inputStream);
//			}	
//			LOG.info("接口验证是否合法耗时："+(System.currentTimeMillis()-s));
//		}
		if (headerString != null) {
			// 如果content-type 以“application/x-www-form-urlencoded”开头，则处理
			if (headerString.startsWith(MediaType.APPLICATION_FORM_URLENCODED)) {
				context.getHeaders().putSingle("content-type", MediaType.APPLICATION_FORM_URLENCODED);
			}
		}
	}
	
	/**
	 * 
	 *  {获取url请求参数，暂只支持GET/POST方法}
	 *  @param method
	 *  @param uri
	 *  @param context
	 *  @return
	 *  @author zhangxiaota
	 *  @created 2016年7月22日 上午11:12:21
	 *  @lastModified       
	 *  @history
	 */
	public String getRequestStr(String method,String uri,ContainerRequestContext context){
		String requestStr = "";
		if(METHOD_GET.equals(method)){
			//截取GET方法后面的参数
			if(uri.indexOf("?")>-1){
				requestStr = uri.substring(uri.indexOf("?")+1);
			}
		}else if(METHOD_POST.equals(method)){
			//将请求流转为字符串
			requestStr = CSStringUtils.inputStreamToString(context.getEntityStream());
		}else{
			requestStr = "";
		}
		return requestStr;
	}
	
	/**
	 * 
	 *  {参数格式化}
	 *  @param requestStr
	 *  @return
	 *  @author Steven Zhang
	 *  @created 2016年10月24日 下午5:47:10
	 *  @lastModified       
	 *  @history
	 */
	public Map<String, Object> splitParams(String requestStr){
		Map<String, Object> map = new HashMap<String, Object>(); 
		if(CSStringUtils.isEmpty(requestStr)){
			return map;
		}
	    String[] params = requestStr.split("&");  
	    for (int i = 0; i < params.length; i++) {  
	        String[] p = params[i].split("=");  
	        if (p.length == 2) {  
	            map.put(p[0], p[1]);  
	        }  
	    }  
	    return map;  
	}
	
	/**
	 * 
	 *  {获取IP地址}
	 *  @param request
	 *  @return
	 *  @author Steven Zhang
	 *  @created 2016年10月24日 下午8:08:44
	 *  @lastModified       
	 *  @history
	 */
	public static String getIpAddress(HttpServletRequest request) {
			String ip = request.getHeader("X-Forwarded-For");
			if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("X-Real-IP");
			}
			if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
			if ("127.0.0.1".equals(ip)) {
				InetAddress inet = null;
				try { // 根据网卡取本机配置的IP
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ip = inet.getHostAddress();
			}
			// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
			if (ip != null && ip.length() > 15) {
				if (ip.indexOf(",") > 0) {
					ip = ip.substring(0, ip.indexOf(","));
				}
			}
			return ip;
	}
}
