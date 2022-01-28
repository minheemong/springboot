package com.ezen.spn01.service;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spn01.dao.IQnaDao;
import com.ezen.spn01.dto.QnaVO;

@Service
public class QnaService {

	@Autowired
	IQnaDao qdao;

	public ArrayList<QnaVO> listQna(String id) {
		return qdao.listQna(id);
	}

	public void insertQna(QnaVO qnavo) {
		qdao.insertQna(qnavo);
		
	}

	public QnaVO getQna(int qseq) {
		return qdao.getQna(qseq);
	}
}
