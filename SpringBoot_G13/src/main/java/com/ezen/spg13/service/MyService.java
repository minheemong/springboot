package com.ezen.spg13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.ezen.spg13.dao.ITransactionDao1;
import com.ezen.spg13.dao.ITransactionDao2;


@Service
public class MyService {

	@Autowired
	ITransactionDao1 td1;
	
	@Autowired
	ITransactionDao2 td2;
	
	@Autowired
	PlatformTransactionManager ptm;
	
	@Autowired
	TransactionDefinition td;

	public int buy(String id, int amount, String error) {
		int n = 0;
		
		// 트렌젝션의 시작
		TransactionStatus status = ptm.getTransaction(td);
		
		try {
			td1.buy(id, amount);
			if(error.equals("1")) n = 10/0; // 전달될 error 값이 1이면 강제 에러 발생
			td2.buy(id, amount);
			System.out.println("에러없이 둘 다 실행되었어요");
			ptm.commit(status); // 영역 안의 모든 데이터베이스 작업의 실행적용
			return 1; // 트렌젝션의 끝
		} catch(Exception e) {
			//System.out.println("중간에 에러나서 하나만 실행되었어요");
			System.out.println("중간에 에러나서 둘 다 실행 안됐어요");
			ptm.commit(status); // 영역 안의 모든 데이터베이스 작업의 실행적용
			return 0; // 트렌젝션의 끝
		}
	}
}
