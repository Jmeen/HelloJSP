package com.toyproject.pos.dao;

import java.util.List;

import com.toyproject.pos.vo.ProductVo;

public interface ProductDao {
	public List<ProductVo> getlist(); // db에서 읽어오기
	public int Insert(ProductVo vo); // db에 상품 추가
	public int delete(ProductVo vo); // db에서 상품 삭제

	public List<ProductVo> cart(Long pk);

}
