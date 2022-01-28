package com.ezen.spn01.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.spn01.dto.QnaVO;

@Mapper
public interface IQnaDao {

	ArrayList<QnaVO> listQna(String id);
	void insertQna(QnaVO qnavo);
	QnaVO getQna(int qseq);

}
