package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/member") // ==> /member 로 시작하는 request 만 처리
public class MemberController {
	@RequestMapping(value="/save") // ==> /member + /save ==> /member/save
	public String saveMemeber() {
		return "member/save";
	}
	
	@RequestMapping(value="/load") // = >/member/load
	public String loadMember() {
		return "member/load";
	}
	
	/*
	 * @RequestMapping(value="/search") // ==>/member/search public String
	 * searchMember() { return "member/search"; }
	 */
}
