package com.lec.sts16_interceptor.board.command;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts16_interceptor.board.beans.BWriteDAO;
import com.lec.sts16_interceptor.board.beans.BWriteDTO;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		BWriteDAO dao = new BWriteDAO();
		int delete = dao.deleteByUid(uid);
		model.addAttribute("delete", delete);
		
	}

}
