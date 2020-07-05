package com.lec.sts19_rest.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;



public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		/* model.addAttribute("result", dao.update(dto)); */
		 model.addAttribute("result", dao.update(dto.getUid(), dto.getSubject(), dto.getContent()));
	}

}
