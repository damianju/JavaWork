package com.lec.sts19_rest.board.command;


import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;


public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		//MyBatis 사용
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("list", dao.select());
	}

}
