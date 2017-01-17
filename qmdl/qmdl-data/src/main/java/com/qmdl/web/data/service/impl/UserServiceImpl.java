package com.qmdl.web.data.service.impl;

import org.springframework.stereotype.Service;

import com.qmdl.web.data.mapper.UserMapper;
import com.qmdl.web.data.service.IUserService;
import com.qmdl.web.data.service.base.BaseServiceImpl;
import com.qmdl.web.model.entity.User;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {


}