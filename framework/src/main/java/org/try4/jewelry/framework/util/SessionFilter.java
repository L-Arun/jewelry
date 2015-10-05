package org.try4.jewelry.framework.util;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class SessionFilter implements Filter {
	private static Logger logger = Logger.getLogger(SessionFilter.class);
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        String servletPath = req.getServletPath()+req.getQueryString();
        logger.debug("SessionFilter:"+servletPath);
        
        if(servletPath.contains("main.jsp") || servletPath.contains("street.jsp") || servletPath.contains("follow.jsp")){
        	boolean need_login = true;
        	Cookie[] cookies = req.getCookies();
        	if(cookies != null){
        		for(Cookie cookie : cookies){
        			if(cookie.getName().equals("user")){
        				need_login = false;
        			}
        		}
        	}
        	if(need_login){
        		resp.sendRedirect("/login.jsp");
        	}else{
        		chain.doFilter(req, resp); 
        	}
        }else if(servletPath.contains("login.jsp") ||servletPath.contains("/login") || servletPath.contains("/register")
        		||servletPath.contains(".jpg")  || servletPath.contains(".bmp") 
                || servletPath.contains("images") || servletPath.contains("css") 
                || servletPath.contains("js")
               ){
        	chain.doFilter(req, resp); 
        }else{
            	boolean need_login = true;
            	Cookie[] cookies = req.getCookies();
            	if(cookies != null){
            		for(Cookie cookie : cookies){
            			if(cookie.getName().equals("user")){
            				request.setAttribute("current_user", URLDecoder.decode(cookie.getValue(),"UTF-8"));
            				need_login = false;
            			}
            			if(cookie.getName().equals("user_type")){
            				request.setAttribute("current_user_type", cookie.getValue());
            			}
            			if(cookie.getName().equals("corp_name")){
            				request.setAttribute("corp_name", cookie.getValue());
            			}
            			if(cookie.getName().equals("phone")){
            				request.setAttribute("phone", cookie.getValue());
            			}
            			if(cookie.getName().equals("address")){
            				request.setAttribute("address", cookie.getValue());
            			}
            		}
            	}
            	if(need_login){
            		resp.sendRedirect("/login.jsp");
            	}else{
            		chain.doFilter(req, resp); 
            	}
            }
        
        
    }
	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}










