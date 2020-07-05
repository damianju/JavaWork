package com.lec.sts13_jdbc.board.command;

import java.util.List;
import java.util.Map;


import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;

public class BViewCommand implements BCommand {
	
	
	@Override
	public void execute(Model model) {
		Map<String,Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		BWriteDAO dao = new BWriteDAO();

		List<BWriteDTO> view = dao.readByUid(uid);
		model.addAttribute("view", view);
	}

}

//Arrays.asList(new String[]{"aaa", "bbb"})
// Arrays.asList("aaa", "bbb")

