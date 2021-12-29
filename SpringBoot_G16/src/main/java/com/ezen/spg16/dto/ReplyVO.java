package com.ezen.spg16.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplyVO {
	private int num;
	private int boardnum;
	private String userid;
	private Timestamp writedate;
	private String content;
}
