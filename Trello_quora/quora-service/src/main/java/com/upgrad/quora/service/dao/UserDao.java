package com.upgrad.quora.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.upgrad.quora.service.entity.UserEntity;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public UserEntity createUser(UserEntity userEntity) {
		 entityManager.persist(userEntity);
		 return userEntity;
	}
}
