package com.jaxb.test.main;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.jaxb.test.entity.Category;
import com.jaxb.test.entity.Category2;
import com.jaxb.test.entity.CategoryList;
import com.jaxb.test.entity.CategoryList2;

public class MainTest {

	public static void main(String[] args) throws JAXBException{
	
		List<Category> category = new ArrayList<Category>();
		category.add(new Category(1,"Muebles"));
		category.add(new Category(2,"Juguetes"));
		category.add(new Category(3,"Tecnología"));
		category.add(new Category(4,"Cocinas"));
	
		CategoryList list = new CategoryList();
		list.setCatList(category);
		
		System.out.println("--Marshalling--");
		
		marshalIt(list);
		
		System.out.println("--End Marshalling--");
		
		unmarshallIt(CategoryList.class, "");
	}
	
	public static void marshalIt(Object objectName) throws JAXBException{
		JAXBContext ctx = JAXBContext.newInstance(objectName.getClass());
		System.out.println(objectName.getClass());
		Marshaller marshaller = ctx.createMarshaller();
		
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		try {
			marshaller.marshal(objectName, new File("category.xml"));
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error en conversión");
		}
		
	}
	
	public static void unmarshallIt(Class<?> className, String xml) throws JAXBException{
		JAXBContext ctx = JAXBContext.newInstance(className);
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		CategoryList unmarshalled  = (CategoryList) unmarshaller.unmarshal(new File("category.xml"));
		System.out.println("unmarshalled = " + unmarshalled.getCatList());
		
		JAXBContext context = JAXBContext.newInstance(com.jaxb.test.entity.CategoryList2.class);
		CategoryList2 catList2 = new CategoryList2();
		List<Category2> list2 = new ArrayList<Category2>();
		LocalDate today = LocalDate.now();
		System.out.println(today);
		for (Category cat : unmarshalled.getCatList()) {
			list2.add(new Category2(cat.getCategoryId(),"Static Value",cat.getCategoryName(),today+""));
		}
		
		catList2.setCategories(list2);
		
		Marshaller marsh = context.createMarshaller();
		marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marsh.marshal(catList2, new File("category2.xml"));
		
		
	}

}
