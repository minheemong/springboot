package com.ezen.spg13.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITransactionDao2 {

	void buy(String id, int amount);

}
