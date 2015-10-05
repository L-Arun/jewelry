package org.try4.jewelry.controller.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.try4.jewelry.framework.model.TestUser;
import org.try4.jewelry.framework.service.ITestUserService;
import org.try4.jewelry.framework.util.JsonUtil;

@Controller
@RequestMapping(value = "/api/common")
public class TestController {
	
	@Autowired
	private ITestUserService iTestUserService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void password(
            HttpServletRequest req,HttpServletResponse response,
            Model model) {
		List<TestUser> list=iTestUserService.getTestUser(null);
		String res = JsonUtil.getSuccessJsonFromList(list, "SUCCESS");
		
		response.setContentType("application/Json");
        response.setCharacterEncoding("UTF-8"); 
        PrintWriter out;
        try { 
           	out = response.getWriter();  
           	out.print(res);
           	// 用于返回对象参数 
        } catch (IOException e) {  
           		e.printStackTrace();  
        }
	}	
}