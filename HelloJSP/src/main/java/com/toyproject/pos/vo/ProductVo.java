package com.toyproject.pos.vo;

public class ProductVo {
	// 필드
	private Long id;
	private String name;
	private Long price;

	// 생성자
	public ProductVo() {
	}

	public ProductVo(Long id, String name, Long price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Long getid() {
		return id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVo [name=" + name + ", price=" + price + "]";
	}

}
