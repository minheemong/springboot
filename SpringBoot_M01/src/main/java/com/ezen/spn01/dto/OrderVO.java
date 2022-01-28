package com.ezen.spn01.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderVO {

	private int odseq;
	private int oseq;
	private String id; 
	private Timestamp indate;
	private String mname;
	private String zip_num;
	private String address;
	private String phone;  
	private int pseq;
	private String pname;
	private int quantity;
	private int price2;  
	private String result;
	
}
