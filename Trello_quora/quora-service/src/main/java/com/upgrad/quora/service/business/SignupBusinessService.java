package com.upgrad.quora.service.business;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrad.quora.service.dao.UserDao;
import com.upgrad.quora.service.entity.UserEntity;

@Service
public class SignupBusinessService {
	
	@Autowired UserDao userDao;
	@Transactional
	public UserEntity signup(UserEntity entity) {
		return userDao.createUser(entity);
	}

}
