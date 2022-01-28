package com.ezen.spn01.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.spn01.dto.CartVO;

@Mapper
public interface ICartDao {

	void insertCart(CartVO cvo);
	ArrayList<CartVO> listCart(String id);
	void deleteCart(int cseq);

}
