package com.lec.sts19_rest.board.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;


@MapperScan
public interface IWriteDAO {
	public List<BWriteDTO> select();
	public int insert(final BWriteDTO dto);
	public int insert(String subject, String content, String name);
	// public List<BWriteDTO> readByUid(final int uid);
	public List<BWriteDTO> selectByUid(final int uid);
	//public int update(final BWriteDTO dto);
	public int update(int uid, String subject, String content);
	public int deleteByUid(final int uid);
	public int incViewCnt(int uid); // 조회수 증가
	
	
	public BWriteDTO searchBySubject(String subject);
	
	public int countAll();
	public List<BWriteDTO> selectFromRow(int from, int rows);
}
