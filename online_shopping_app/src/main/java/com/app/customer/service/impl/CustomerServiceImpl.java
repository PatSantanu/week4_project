package com.app.customer.service.impl;

import java.util.List;

import com.app.customer.dao.impl.CustomerDAOImpl;
import com.app.customer.dao.impl.EmployeeDAOImpl;
import com.app.customer.service.CustomerService;
import com.app.dao.CustomerDAO;
import com.app.dao.EmployeeDAO;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Product;

public class CustomerServiceImpl implements CustomerService {
	CustomerDAO customerdao=new CustomerDAOImpl();
	EmployeeDAO employeedao=new EmployeeDAOImpl();
	@Override
	public int login(Customer customer) throws BusinessException {
		int var=0;
		if(customer.getEmail()!=null && customer.getPassword()!=null) {
			var=customerdao.login(customer);
		}
		return var;
	}
	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		int c=customerdao.createCustomer(customer);
		return c;
	}
	@Override
	public List<Product> getProductsByProductName(String productName) throws BusinessException {
		List<Product> productList=null;
//		if(productName.matches("[a-zA-Z]{2,10}")) {
			//code here to DAO
			productList=customerdao.getProductsByProductName(productName);
//		}else {
//			throw new BusinessException("Invalid product name : "+productName);
//		}
		
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
	@Override
	public Customer getCustomerByCustomerId(int c_id) throws BusinessException {
		Customer customer=null;
		if (c_id<101 || c_id>199) {
			throw new BusinessException("Invalid Id it Must be in Between 100-199");			
		}else {
			customer=customerdao. getCustomerByCustomerId(c_id);
		}
		
		return customer;
	}
	@Override
	public Product getProductByProductId(int productId) throws BusinessException {
		Product product=null;
		product=customerdao.getProductByProductId(productId);
		
		return product;
	}
	@Override
	public int addProductToCart(Cart cart) throws BusinessException {
		int d1=0;
		
			d1=customerdao.addProductToCart(cart);
		
		return d1;
	}
	@Override
	public Customer getCustomerByEmailId(String email) throws BusinessException {
		Customer customer1=null;
		customer1=customerdao.getCustomerByEmailId(email);
		
		
		return customer1;
	}
	@Override
	public Cart viewCart(int customerId) throws BusinessException {
		Cart cart=new Cart();
		
		cart=customerdao.viewCart(customerId);
		return cart;
	}
	
	 @Override
	    public boolean isValidCustomerEmailId(String customerUsername) throws BusinessException {
	        if (customerUsername.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
	                return true;
	        } else {
	            throw new BusinessException("The username you entered is not valid.\n\nYour username needs to:\n * include only lowercase characters.\n * be at least 5 characters long.");
	        }
	    }

	 @Override
	    public boolean isValidCustomerPassword(String customerPassword) throws BusinessException {
	        if (customerPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()]).{8,20}$")) {
	            return true;
	        }
	        throw new BusinessException("The password you entered is not valid. \n\nYour password needs to:\n * include both lower and uppercase characters.\n * include at least one number or symbol.\n * be at least 8 characters long.");
	    }
	


}
