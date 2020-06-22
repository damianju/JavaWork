package com.lec.sts10_request;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/common") // /common 으로 요청이 오면
	public String cccmmm() { // cccmmm() 핸들러가 수행되고,
		return "comn"; // ==> /WEB-INF/views/comn.jsp 를 리턴하여 response 되게 한다
	}
	
	@RequestMapping(value="/member/search") // /common 으로 요청이 오면
	public String searchMember() { // cccmmm() 핸들러가 수행되고,
		return "member/search"; // ==> /WEB-INF/views/comn.jsp 를 리턴하여 response 되게 한다
	}
	
	@RequestMapping(value="/member/infoView")
	public String infoMember(Model model) {
		model.addAttribute("mbAge", 30);
		model.addAttribute("mbName", "홍길동");
		
		return "member/info";
	}
	
	@RequestMapping(value="/member/find")
	public ModelAndView findMember() {
		ModelAndView mv = new ModelAndView();
		
		// 데이터 담기
		mv.addObject("mbName", "다스베이더");
		mv.addObject("mbDate", "2020/06/22");
		
		// 뷰 지정
		mv.setViewName("member/find");
		
		return mv;
	}
	
	// 확장자 패턴 사용 가능
	@RequestMapping(value="/member/*.do")
	public String doMember() {
		return "member/doMember";
	}
}
