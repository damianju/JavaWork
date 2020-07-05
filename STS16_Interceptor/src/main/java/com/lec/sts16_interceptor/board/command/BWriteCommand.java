package com.lec.sts16_interceptor.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts16_interceptor.board.beans.BWriteDAO;
import com.lec.sts16_interceptor.board.beans.BWriteDTO;

public class BWriteCommand implements BCommand {
	
	// 커맨드 객체(request paramter들)를 "dto" 라는 이름으로 Model 에 담아호출됨.
	@Override
	public void execute(Model model) {
		
		// Model 안에 있는 값(attribute) 꺼내는 방법
		Map<String,Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
		BWriteDAO dao = new BWriteDAO();
		int result = dao.insert(dto);
		model.addAttribute("result", result);
	} // end execute()

} // end command
