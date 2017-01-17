package com.qmdl.web.data.service.base;

import org.mybatis.plus.mybatisplus.mapper.AutoMapper;
import org.mybatis.plus.mybatisplus.service.impl.SuperServiceImpl;

public class BaseServiceImpl<M extends AutoMapper<T>, T> extends SuperServiceImpl<M, T> {

}
