package com.qmdl.web.api.model.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.plus.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creditstate.cn.utils.CSStringUtils;
import com.qmdl.web.data.service.ICarouselInfoService;
import com.qmdl.web.data.service.IIsupdateService;
import com.qmdl.web.model.entity.CarouselInfo;
import com.qmdl.web.model.entity.Isupdate;


@Component
public class IndexTools {

	@Autowired
	private IIsupdateService iIsupdateService;
	
	@Autowired
	private ICarouselInfoService iCarouselInfoService;
	
	public Map<String, Object>  isUpdate(String version, String phoneType) {
		Map<String, Object> map = new HashMap<String, Object>();
		Isupdate isupdate = new Isupdate();
		isupdate.setAppType(phoneType);
		isupdate.setIsDeploy("1");
		Isupdate isupdateR  = iIsupdateService.selectOne(isupdate);
		if (CSStringUtils.isEmpty(isupdateR)) {
			 map.put("isUpdate", "0");
		} else {
			//判断是否需要更新，设置isUpdate字段
			   String versionR = isupdateR.getVersion();
			   if(!CSStringUtils.isEmpty(version)&&!CSStringUtils.isEmpty(versionR)){
				   versionR = versionR.replace('.', 'a').replaceAll("a", "");
				   version =version.replace('.', 'a').replaceAll("a", "");
				   //判断版本号，若已是最新版本，则不需要更新
				   if(Integer.parseInt(version)>=Integer.parseInt(versionR)){
					   map.put("isUpdate", "0");
				   }else{
					   map.put("isUpdate", isupdateR.getIsUpdate());
					   map.put("updateTxt", isupdateR.getUpdateTxt());
					   map.put("updateUrl", isupdateR.getUpdateUrl());
				   }
			   }
		}
		return map;
	}
	
	public List<Map<String,Object>> getCarouselInfo(String type){
		EntityWrapper<CarouselInfo> ew = new EntityWrapper<CarouselInfo>();
		ew.where("deleteFlag='0'").andNew("type='"+type+"'");
		List<CarouselInfo> list = iCarouselInfoService.selectList(ew);
		List<Map<String,Object>> maplist = new ArrayList<Map<String,Object>>();
		if(list.size()>0){
			for(CarouselInfo cInfo : list){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("title", cInfo.getTitle());
				map.put("contentUrl", cInfo.getContentUrl());
				map.put("imageUrl", cInfo.getImageUrl());
				map.put("description", cInfo.getDescription());
				map.put("type", cInfo.getType());
				maplist.add(map);
			}
		}
		return maplist;
	}
}
