package org.try4.jewelry.framework.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.try4.jewelry.framework.model.TestUser;

@Component
public interface TestUserDao {
   public long insertTestUser(TestUser entity);
   public int updateTestUser(TestUser entity);
   public List<TestUser> getTestUser(Map<String,Object> paramMap);
   
   
}
