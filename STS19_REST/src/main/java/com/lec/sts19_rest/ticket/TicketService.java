package com.lec.sts19_rest.ticket;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lec.sts19_rest.board.C;

public class TicketService {
	// MyBatis
	private SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		
	}
	
	// TransactionTemplate 사용
	TransactionTemplate transactionTemplate;
	
	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	public void buyTicket(final TicketDTO dto) {
		// Mybatis 를 사용하여이 트랜젝션 안의 여러 동작(쿼리들) 실행
		// 중간에 실패하면 드랜잭션 실패하고 자동으로 rollback 된다.
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				ITicketDAO dao = C.sqlSession.getMapper(ITicketDAO.class);
				dao.insertCard(dto.getUserId(), dto.getTicketCount());
				dao.insertTicket(dto.getUserId(), dto.getTicketCount());
			}
		});
	}
	
	
}
