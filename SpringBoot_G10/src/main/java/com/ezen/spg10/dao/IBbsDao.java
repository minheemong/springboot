package com.ezen.spg10.dao;

import java.util.List;

import com.ezen.spg10.BbsDto;

public interface IBbsDao {
	
	public List<BbsDto> list(); // 리스트 리턴
	public int write(BbsDto bdto); // 게시물 쓰기
	public int update(BbsDto bdto); // 수정
	public int delete(String id);  // 삭제
	public BbsDto view(String id); // 게시물 하나 보기
}
