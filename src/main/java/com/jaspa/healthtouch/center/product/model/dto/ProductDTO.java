package com.jaspa.healthtouch.center.product.model.dto;

import lombok.Data;

@Data
public class ProductDTO {
	
	private int no;
	private int categoryNo;
	private String name;
	private int price;
	private String contents;
	private int usePeriod;
	private int useCount;
	private java.util.Date date;
	private String status;
	
	private ProCategoryDTO category;

}
