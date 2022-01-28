package com.ezen.spn01.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.spn01.dto.CartVO;
import com.ezen.spn01.dto.OrderVO;

@Mapper
public interface IOrderDao {

	void insertOders(String id);
	int LookupMaxOseq();
	void insertOderDetail(CartVO cvo, int oseq);
	void deleteCart(Integer cseq);
	ArrayList<OrderVO> listOrderByOseq(int oseq);
	ArrayList<Integer> selectOseqOrderIng(String id);
	ArrayList<Integer> oseqListAll(String id);

}
