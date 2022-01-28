package com.ezen.spn01.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spn01.dao.ICartDao;
import com.ezen.spn01.dto.CartVO;

@Service
public class CartService {

	@Autowired
	ICartDao cdao;

	public void insertCart(CartVO cvo) {
		cdao.insertCart(cvo);		
	}

	public ArrayList<CartVO> listCart(String id) {
		return cdao.listCart( id );
	}

	public void deleteCart(int cseq) {
		cdao.deleteCart(cseq);		
	}
}
