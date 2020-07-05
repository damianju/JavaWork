package com.lec.sts15_mybatis.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts15_mybatis.board.C;
import com.lec.sts15_mybatis.board.beans.BWriteDTO;
import com.lec.sts15_mybatis.board.beans.IWriteDAO;



public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		/* model.addAttribute("result", dao.update(dto)); */
		 model.addAttribute("result", dao.update(dto.getUid(), dto));
	}

}
