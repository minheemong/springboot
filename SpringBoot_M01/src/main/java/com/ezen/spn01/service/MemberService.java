package com.ezen.spn01.service;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spn01.dao.IMemberDao;
import com.ezen.spn01.dto.AddressVO;
import com.ezen.spn01.dto.MemberVO;

@Service
public class MemberService {

	@Autowired
	IMemberDao mdao;

	public MemberVO getMember(String id) {
		return mdao.getMember(id);
	}

	public ArrayList<AddressVO> selectAddressByDong(String dong) {
		return mdao.selectAddressByDong( dong );
	}

	public void insertMember(MemberVO membervo) {
		mdao.insertMember(membervo);		
	}

	public void updateMember(MemberVO membervo) {
		mdao.updateMember(membervo);
		
	}
}











