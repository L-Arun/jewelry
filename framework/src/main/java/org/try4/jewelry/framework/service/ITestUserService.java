package org.try4.jewelry.framework.service;

import java.util.List;
import java.util.Map;

import org.try4.jewelry.framework.model.TestUser;

public interface ITestUserService {
	public long insertTestUser(TestUser entity);

	public int updateTestUser(TestUser entity);

	public List<TestUser> getTestUser(Map<String, Object> paramMap);
}
