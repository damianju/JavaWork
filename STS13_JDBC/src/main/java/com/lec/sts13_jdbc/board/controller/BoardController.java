package com.lec.sts13_jdbc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.sts13_jdbc.board.C;
import com.lec.sts13_jdbc.board.beans.BWriteDAO;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;
import com.lec.sts13_jdbc.board.command.BCommand;
import com.lec.sts13_jdbc.board.command.BDeleteCommand;
import com.lec.sts13_jdbc.board.command.BListCommand;
import com.lec.sts13_jdbc.board.command.BSelectCommand;
import com.lec.sts13_jdbc.board.command.BUpdateCommand;
import com.lec.sts13_jdbc.board.command.BViewCommand;
import com.lec.sts13_jdbc.board.command.BWriteCommand;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BCommand command;
	private JdbcTemplate template;
	private BWriteDAO dao;
	
	@Autowired
	public void setDao(BWriteDAO dao) {
		this.dao = dao;
	}
	
	public BoardController() {
		super();
		System.out.println("BoardController() 생성");
	}


	@Autowired
	public void setTemplate(JdbcTemplate template) {
		System.out.println("setTemplate() invoke");
		this.template = template;
		C.template = template;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "board/list";
	}
	
	@RequestMapping("/write.do")
	public String write(Model model) {
		return "board/write";
	}
	
	@RequestMapping(value="/writeOk.do", method= RequestMethod.POST)
	public String writeOk(BWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new BWriteCommand().execute(model);
		return "board/writeOk";
	}
	
	@RequestMapping(value="/view.do", method=RequestMethod.GET)
	public String view(Model model, @RequestParam("uid") int uid) {
		model.addAttribute("uid", uid);
		new BViewCommand().execute(model);
		return "board/view";
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public String select(Model model, @RequestParam("uid") int uid) {
		model.addAttribute("uid", uid);
		new BSelectCommand().execute(model);
		return "board/update";
	}
	
	@RequestMapping(value="/updateOk.do", method=RequestMethod.POST)
	public String update(BWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new BUpdateCommand().execute(model);
		return "board/updateOk";
	}
	
	@RequestMapping(value="/deleteOk.do", method=RequestMethod.GET)
	public String delete(Model model, @RequestParam("uid") int uid) {
		model.addAttribute("uid", uid);
		new BDeleteCommand().execute(model);
		return "board/deleteOk";
	}
	
} // end Controller
