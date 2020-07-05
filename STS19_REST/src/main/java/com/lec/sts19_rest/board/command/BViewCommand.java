package com.lec.sts19_rest.board.command;

import java.util.List;
import java.util.Map;


import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;


public class BViewCommand implements BCommand {
	
	
	@Override
	public void execute(Model model) {
		Map<String,Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		//MyBatis 사용
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		dao.incViewCnt(uid);
		model.addAttribute("view", dao.selectByUid(uid));
		
	}

}

//Arrays.asList(new String[]{"aaa", "bbb"})
// Arrays.asList("aaa", "bbb")

