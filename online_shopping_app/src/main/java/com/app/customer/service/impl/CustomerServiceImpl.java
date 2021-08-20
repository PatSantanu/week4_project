package com.app.customer.service.impl;

import java.util.List;

import com.app.customer.dao.impl.CustomerDAOImpl;
import com.app.customer.dao.impl.EmployeeDAOImpl;
import com.app.customer.service.CustomerService;
import com.app.dao.CustomerDAO;
import com.app.dao.EmployeeDAO;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;

public class CustomerServiceImpl implements CustomerService {
	CustomerDAO customerdao=new CustomerDAOImpl();
	EmployeeDAO employeedao=new EmployeeDAOImpl();
	@Override
	public Customer login(Customer customer) throws BusinessException {
		if(customer.getEmail()!=null && customer.getPassword()!=null) {
			customer=customerdao.login(customer);
		}
		return customer;
	}
	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		customerdao.createCustomer(customer);
		return 0;
	}
	@Override
	public List<Product> getProductsByProductName(String productName) throws BusinessException {
		List<Product> productList=null;
		if(productName.matches("[a-zA-Z]{2,10}")) {
			//code here to DAO
			productList=customerdao.getProductsByProductName(productName);
		}else {
			throw new BusinessException("Invalid team name : "+productName);
		}
		
		return productList;
	}
	@Override
	public int addProduct(Product product) throws BusinessException {
		// TODO Auto-generated method stub
		employeedao.addProduct(product);
		return 0;
	}
	@Override
	public List<Product> getProductsByProductCatagory(String productCatagory) throws BusinessException {
		List<Product> productList1=null;
		if(productCatagory.matches("[a-zA-Z]{2,10}")) {
			//code here to DAO
			productList1=customerdao.getProductsByProductCatagory(productCatagory);
		}else {
			throw new BusinessException("Invalid team name : "+productCatagory);
		}
		return productList1;
	}
	
	

}
