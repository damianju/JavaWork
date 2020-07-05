package com.lec.sts19_rest.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.AjaxWriteList;
import com.lec.sts19_rest.board.beans.AjaxWriteResult;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

@RestController
@RequestMapping("/board")
public class AjaxController {
	IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
	
	@RequestMapping(value="/list.ajax", method=RequestMethod.GET)
	public AjaxWriteList list(Model model, HttpServletRequest request) {
		AjaxWriteList result = new AjaxWriteList();
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		// 페이징 관련 세팅값들
		int page = 1;  // 현재 페이지 (디폴트는 1 page)
		int pageRows = 8;   // 한 '페이지' 에 몇개의 글을 리스트? (디폴트 8개)
		int writePages = 10;  // 한 [페이징] 에 몇개의 '페이지' 를 표시? (디폴트 10)
		int totalCnt = 0;    // 글은 총 몇개인지?
		int totalPage = 0;   // 총 몇 '페이지' 분량인지?
		
		String param;
		
		// page 값 : 현재 몇 페이지?
		param = request.getParameter("page");
		if(param != null && param.trim().length() != 0) {
			try {				
				page = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		
		// pageRows 값 :  '한 페이지' 에 몇개의 글?
		param = request.getParameter("pageRows");
		if(param != null && param.trim().length() != 0) {
			try {				
				pageRows = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		
		// 글 전체 개수 구하기
		totalCnt = dao.countAll();
		
		// 총 몇 페이지 분량인가?
		totalPage = (int)Math.ceil(totalCnt / (double)pageRows);
		
		// 몇번재 row 부터 ?
		int fromRow = (page - 1) * pageRows + 1;  // ORACLE 은 1부터 ROWNUM시작
		List<BWriteDTO> list = dao.selectFromRow(fromRow, fromRow+pageRows);
		
		if(list.isEmpty()) {
			message.append("[리스트할 데이터가 없습니다]");
		} else {
			status = "OK";
		}
		
		result.setStatus(status);
		result.setMessage(message.toString());
		result.setCount(list.size());
		
		result.setList(list);
		result.setPage(page);
		result.setTotalPage(totalPage);
		result.setWritePages(writePages);
		result.setPageRows(pageRows);
		result.setTotalCnt(totalCnt);
		
		return result;
	}
	
	@RequestMapping(value = "/view.ajax", method=RequestMethod.GET)
	public AjaxWriteList view(Model model, HttpServletRequest request) {
		AjaxWriteList result = new AjaxWriteList();
		List<BWriteDTO> list = null;
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		String param = request.getParameter("uid");
		
		if(param == null) {
			message.append("[유효하지 않은 parameter 0 or null]");
		} else {
			try {
				int uid = Integer.parseInt(param);
				list = dao.selectByUid(uid);
				
				
				if(list.isEmpty()) {
					message.append("[해당 데이터가 없습니다]");
				} else {
					status ="OK";
				}
				
			} catch(Exception e) {
				message.append("[예외발생:" + e.getMessage() + "]");
			}
		
		}
		result.setStatus(status);
		result.setMessage(message.toString());
		result.setList(list);
		
		return result;
	}
	
	@RequestMapping(value="/writeOk.ajax", method=RequestMethod.POST)
	public AjaxWriteResult write(Model model, HttpServletRequest request) {
		int cnt = 0;
		AjaxWriteResult result = new AjaxWriteResult();
		
		
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		if(name == null || name.trim().length() == 0) {
			message.append("[유효하지 않은 parameter: 작성자 필수]");
		} else if(subject == null || subject.trim().length() == 0) {
			message.append("[유효하지 않은 parameter: 글제목 필수]");
		} else {
			cnt = dao.insert(subject, content, name);
			
			if(cnt == 0) {
				message.append("[트랜젝션 실패: 0개 insert");
			} else {
				status = "OK";
			}
					
		}
		
		result.setCount(cnt);
		result.setMessage(message.toString());
		result.setStatus(status);
		
		return result;
	}
	
	
	@RequestMapping(value="/updateOk.ajax", method=RequestMethod.POST)
	public AjaxWriteResult update(Model model, HttpServletRequest request) {
		int cnt = 0;
		AjaxWriteResult result = new AjaxWriteResult();
		
		
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL

		String param = request.getParameter("uid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		if(param ==null) {
			message.append("[유효하지 않은 parameter 0 or null]");
		} else if(subject == null|| subject.trim().length() ==0) {
			message.append("[유효하지 않은 parameter: 글 제목 필수]");
		} else {
			
			try {
				
				int uid = Integer.parseInt(param);
				
				cnt = dao.update(uid, subject, content);
				
				if(cnt == 0) {
					message.append("[0개 update]");
				} else {
					status = "OK";
				}
			}  catch (Exception e) {
				message.append("[유효하지 않은 parameter] "+param);
			}
			
		}
		
		result.setCount(cnt);
		result.setMessage(message.toString());
		result.setStatus(status);
		
		return result;
	}
	
	@RequestMapping(value="/deleteOk.ajax", method=RequestMethod.POST)
	public AjaxWriteResult delete(Model model, HttpServletRequest request) {
		int cnt = 0;
		AjaxWriteResult result = new AjaxWriteResult();
		
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		String [] params = request.getParameterValues("uid");
		int[] uids = null;
		
		if(params == null || params.length == 0) {
			message.append("[유효하지 않은 parameter 0 or null]");
		} else {
			uids = new int[params.length];
			
			try {
				for(int i=0; i< params.length; i++) {
					uids[i] = Integer.parseInt(params[i]);
				}
				
				for(int i=0; i< uids.length; i++) {
					dao.deleteByUid(uids[i]);
					cnt++;
				}
				
				if(cnt == 0) {
					message.append("[0 update]");
				} else {
					status = "OK";
				}
				
			} catch (Exception e) {
				message.append("[유효하지 않은 parameter]"+ Arrays.toString(params));
			}
		}
		
		result.setCount(cnt);
		result.setMessage(message.toString());
		result.setStatus(status);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
