package com.jaxb.test.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="categoryList")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryList {
	List<Category> categories = new ArrayList<Category>();

	public List<Category> getCatList() {
		return categories;
	}

	public void setCatList(List<Category> catList) {
		this.categories = catList;
	}
	
	
}
