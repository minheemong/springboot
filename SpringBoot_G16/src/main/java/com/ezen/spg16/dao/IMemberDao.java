package com.ezen.spg16.dao;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.spg16.dto.MemberVO;

@Mapper
public interface IMemberDao {

	public MemberVO getMember(String id);

	public void insertMember(@Valid MemberVO membervo);

	public void updateMember(@Valid MemberVO membervo);

}
