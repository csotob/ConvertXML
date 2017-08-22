package com.jaxb.test.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="categoryList2")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryList2 {
	List<Category2> categories = new ArrayList<Category2>();

	public List<Category2> getCategories() {
		return categories;
	}

	public void setCategories(List<Category2> categories) {
		this.categories = categories;
	}
	
}
