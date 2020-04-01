package org.mybatis.domain;

import java.io.Serializable;

// mybatis에서 자동 주입 (DTO 역할 담당)
public class Shop implements Serializable {
		
	private int shopNo;
	private String shopName;
	private String shopLocation;
	private String shopStatus;
	
	/* 기본생성자 */
	public Shop() {
	}
	
	/* 생성자 */
	public Shop(int shopNo, String shopName, String shopLocation, String shopStatus){
		this.shopNo = shopNo;
		this.shopName = shopName;
		this.shopLocation = shopLocation;
		this.shopStatus = shopStatus;
	}

	public int getShopNo() {
		return shopNo;
	}

	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopLocation() {
		return shopLocation;
	}

	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}

	public String getShopStatus() {
		return shopStatus;
	}

	public void setShopStatus(String shopStatus) {
		this.shopStatus = shopStatus;
	}

}
