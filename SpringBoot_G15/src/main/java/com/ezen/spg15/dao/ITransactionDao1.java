package com.ezen.spg15.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransactionDao1 {

	public void buy(String id, int amount, String error);
}
