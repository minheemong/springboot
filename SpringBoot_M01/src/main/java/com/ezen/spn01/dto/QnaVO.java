package com.ezen.spn01.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class QnaVO {

	private Integer qseq; 
	@NotEmpty
	private String subject;
	@NotEmpty
	private String content;
	private String reply;
	private String id; 
	private String rep;
	private Timestamp indate;
	
}
