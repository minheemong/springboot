package com.ezen.spg15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.ezen.spg15.dao.ITransactionDao1;
import com.ezen.spg15.dao.ITransactionDao2;
import com.ezen.spg15.dao.ITransactionDao3;

@Service
public class MyService {

	@Autowired
	ITransactionDao1 td1;
	

	@Autowired
	ITransactionDao2 td2;
	

	@Autowired
	ITransactionDao3 td3;
	
	@Autowired
	TransactionTemplate tt;
	
	//@Transactional(propagation=Propagation.REQUIRED) // 관련작업 모두 취소
	@Transactional(propagation=Propagation.REQUIRES_NEW) // 현재 작업은 독립실행 
	public int buy(String id, int amount, String error) {
		
		try {
			tt.execute(new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					td1.buy(id, amount, error);
					if(error.equals("1")) {int n=10/0;}
					td2.buy(id, amount);
					System.out.println("Transaction #1 Commit");
				}
			});
			return 1;
		} catch(Exception e) {
			System.out.println("Transaction #1 RollBack");
			return 0;
		}
	}
}
