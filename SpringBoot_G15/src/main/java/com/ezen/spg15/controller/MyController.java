package com.ezen.spg15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.spg15.dao.ITransactionDao3;
import com.ezen.spg15.service.MyService;

@Controller
public class MyController {
	
	@Autowired
	MyService ms;
	
	@Autowired
	ITransactionDao3 td3;

	@Autowired
	TransactionTemplate tt;
	
	@RequestMapping("/")
	public String root() {
		return "buy_ticket";
	}
	
	@RequestMapping("/buyTicketCard")
	public String buy_ticket_card(@RequestParam("id") String id, 
			@RequestParam("amount") int amount, @RequestParam("error") String error,
			 Model model) {
		model.addAttribute("id",id);
		model.addAttribute("amount",amount);
		
		try {
			tt.execute( new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					int result = ms.buy(id, amount, error);
					if(error.equals("2")) {int n=10/0;}
					td3.buy(id, amount);
					System.out.println("Transaction #2 Commit");
				}
			});
			return "buy_ticket_end";
		} catch(Exception e) {
			System.out.println("Transaction #2 RollBack");
			return "buy_ticket_error";
		}
	}
}
