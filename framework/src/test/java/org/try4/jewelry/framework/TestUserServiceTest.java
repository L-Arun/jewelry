package org.try4.jewelry.framework;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.try4.jewelry.framework.model.TestUser;
import org.try4.jewelry.framework.service.ITestUserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conf/applicationContext-mybatis.xml","classpath:conf/applicationContext-context.xml"})
public class TestUserServiceTest extends TestCase {
  @Autowired
  private ITestUserService iTestUserService;
  @Test
  public void testSave(){
	  
	  TestUser user=new TestUser();
	  user.setNickName("彬彬");
	  user.setState(1);
	  iTestUserService.insertTestUser(user);
  }
  @Test
 public void testUpdate(){
	  
	  TestUser user=new TestUser();
	  user.setId(5);
	  user.setNickName("彬彬-binbin");
	  user.setState(1);
	  iTestUserService.updateTestUser(user);
  }
  @Test
  public void testGetTestUser(){
	  
	 List<TestUser> list=iTestUserService.getTestUser(null);
	 for(TestUser i:list){
		 System.out.println(i.getNickName());
	 }
	 
  }
  
}
