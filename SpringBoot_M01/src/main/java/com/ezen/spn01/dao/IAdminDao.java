package com.ezen.spn01.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.spn01.dto.Paging;
import com.ezen.spn01.dto.ProductVO;

@Mapper
public interface IAdminDao {

	String workerCheck(String workId);
	int getAllCount(String tablename, String fieldname, String key);
	ArrayList<ProductVO> listProduct(Paging paging, String key);
	void insertProduct(ProductVO pvo);

}
