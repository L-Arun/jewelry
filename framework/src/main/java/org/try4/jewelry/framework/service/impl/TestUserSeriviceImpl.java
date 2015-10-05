package org.try4.jewelry.framework.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.try4.jewelry.framework.dao.TestUserDao;
import org.try4.jewelry.framework.model.TestUser;
import org.try4.jewelry.framework.service.ITestUserService;
@Service
public class TestUserSeriviceImpl implements ITestUserService {
    
	@Autowired
	private TestUserDao testUserDao;
	
	public long insertTestUser(TestUser entity) {
		
		return testUserDao.insertTestUser(entity);
	}

	public int updateTestUser(TestUser entity) {
		return testUserDao.updateTestUser(entity);
	}

	public List<TestUser> getTestUser(Map<String, Object> paramMap) {
		
		return testUserDao.getTestUser(paramMap);
	}

}
