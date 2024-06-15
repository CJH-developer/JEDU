package com.geomin.project.security;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.geomin.project.user.service.UserMapper;

public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	private String redirectURL;
	private static final int lockyn = 5;
	private Map<String, Integer> loginAttemps = new HashMap<>();
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String username = request.getParameter("username");
		String msg;
		System.out.println("로그인 실패");
		
		if(exception instanceof BadCredentialsException) {
			int attempts = loginAttemps.getOrDefault(username, 0);
			attempts++;
			loginAttemps.put(username, attempts);
			
			if(attempts >= lockyn) {
				lockCnt(username);
				msg = "잠김 계정이오니, 관리자에게 문의바랍니다.";
			}else {
				System.out.println(attempts + " / " + lockyn);
				msg = "아이디와 비밀번호를 확인해주세요. 로그인 시도 : " + attempts + "/ 총" + lockyn;
			}
			
		}else if(exception instanceof InsufficientAuthenticationException) {
			msg = "아이디 혹은 비밀번호가 틀렸습니다.";
		}
		
		response.sendRedirect(redirectURL);
	}
	
	private void lockCnt(String username) {
		userMapper.lock(username);
		System.out.println("잠긴 계정 : " + username);
	}
	
	public String getRedirectURL() {
		return redirectURL;
	}
	
	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}
	
}
