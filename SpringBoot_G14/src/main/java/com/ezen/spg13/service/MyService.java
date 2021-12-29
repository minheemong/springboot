package com.ezen.spg13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.ezen.spg13.dao.ITransactionDao1;
import com.ezen.spg13.dao.ITransactionDao2;


@Service
public class MyService {

	@Autowired
	ITransactionDao1 td1;
	
	@Autowired
	ITransactionDao2 td2;
	
	@Autowired
	TransactionTemplate tt;

	//@Transactional(propagation=Propagation.REQUIRED) // 관련작업 모두 취소
	//@Transactional(propagation=Propagation.REQUIRES_NEW) // 현재 작업은 독립실행 
	public int buy(String id, int amount, String error) {
		try {
			tt.execute( new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					td1.buy(id, amount);
					int n = 0;
					if(error.equals("1")) n = 10/0; // 전달될 error 값이 1이면 강제 에러 발생
					td2.buy(id, amount);
					System.out.println("Transaction Commit");
				}});
			return 1;
		} catch(Exception e) {
			System.out.println("Transaction RollBack");
			return 0;
		}
	}
}
