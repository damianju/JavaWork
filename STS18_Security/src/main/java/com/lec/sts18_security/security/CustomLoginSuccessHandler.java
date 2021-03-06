package com.lec.sts18_security.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		
		System.out.println("Login Success");
		
		// Authentication 객체를 이용해서 사용자가 가진 모든 권한을 문자열로 체크가능
		List<String> roleNames = new ArrayList<>();
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		System.out.println("ROLE NAMES: "+ roleNames);
		
		// 만약 사용자가 ROLE_ADMIN 권한을 가졌다면 로그인 후 곧바로 /sample/admin 으로 이동
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect(request.getContextPath() + "/sample/admin");
			return;
		}
		
		// 아니면 /sample/member로 이동
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect(request.getContextPath() + "/sample/member");
			return;
		}
		
		response.sendRedirect(request.getContextPath());
		
		
		
		
		
	}

}
