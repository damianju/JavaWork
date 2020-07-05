package com.lec.sts16_interceptor.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// session 객체 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		// 컨트롤러 실행전(Handler 실행전)
		System.out.println("[preHandle]"+id);
		
		if(id == null) {
			// 만약 로그인 되어 있지 않다면, 로그인 페이지로 redirect
			
			// 직전 요청 url을 세션에 기록
			String urlPrior = request.getRequestURL().toString() + "?" + request.getQueryString();
			request.getSession().setAttribute("url_prior_login", urlPrior);
			
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false; // ★더이상 컨트롤서 핸들러 진행하지 않도록 false 리턴
		}
		
		return true; //★true 리턴하면 컨트롤러 핸들러 진행
	}
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 컨트롤러 실행후(Handler 실행직후), 뷰 직전
		System.out.println("[postHandle]");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 뷰 response 후
		System.out.println("[afterCompletion]");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
