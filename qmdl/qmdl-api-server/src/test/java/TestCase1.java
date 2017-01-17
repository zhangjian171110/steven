import java.util.HashMap;
import java.util.Map;

import com.creditstate.cn.utils.CSHttpUtils;
import com.creditstate.cn.utils.CSJSONUtils;

/**	
 * <br>
 * Copyright 2016 CreditState. All rights reserved.<br>
 * <br>			 
 * Package:  <br>
 * FileName: TestCase.java <br>
 * <br>
 * @version
 * @author Steven Zhang
 * @created 2016年10月24日
 * @last Modified 
 * @history
 */

/**
 * {该处请说明该class的含义和作用}
 * 
 * @author Steven Zhang
 * @lastModified
 * @history
 */
public class TestCase1 {

	public static void main(String[] args) {
		//统计分析
		Map<String, String> params = new HashMap<String, String>();
		params.put("type", "0");
		params.put("phoneType", "0");
		try {
			//String str = CSHttpUtils.post("http://60.167.58.32:8080/qmdlapi/user/updateUser", params);
			String str = CSHttpUtils.post("http://localhost:8086/qm/index/carousel", params);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
