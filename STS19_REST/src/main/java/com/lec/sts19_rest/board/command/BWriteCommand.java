package com.lec.sts19_rest.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;


public class BWriteCommand implements BCommand {
	
	// 커맨드 객체(request paramter들)를 "dto" 라는 이름으로 Model 에 담아호출됨.
	@Override
	public void execute(Model model) {
		
		// Model 안에 있는 값(attribute) 꺼내는 방법
		Map<String,Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
		// MyBatis 사용
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("result", dao.insert(dto));
		
		System.out.println("생성된 uid는 " + dto.getUid());
		//model.addAttribute("result", dao.insert(dto.getSubject(), dto.getContent(), dto.getName()));
	} // end execute()

} // end command
