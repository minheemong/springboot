package com.ezen.spn01.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spn01.dao.IAdminDao;
import com.ezen.spn01.dto.Paging;
import com.ezen.spn01.dto.ProductVO;

@Service
public class AdminService {

	@Autowired
	IAdminDao adao;

	public int workerCheck(String workId, String workPwd) {
		
		String pwd = adao.workerCheck(workId);
		
		int result=0;
		if(pwd == null) result = -1;   // 검색된 아이디가 없을때
		else if( workPwd.equals(pwd)) result =  1;  // 정상 로그인
		else if( !workPwd.equals(pwd)) result =  0;  // 비번이 틀렸을때
		
		return result;
	}

	public int getAllCount(String tablename, String fieldname, String key) {
		return adao.getAllCount( tablename, fieldname, key);
	}

	public ArrayList<ProductVO> listProduct(Paging paging, String key) {
		return adao.listProduct(paging, key);
	}

	public void insertProduct(ProductVO pvo) {
		adao.insertProduct(pvo);		
	}
}








