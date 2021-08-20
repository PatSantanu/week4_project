package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface EmployeeDAO {
	
	public int addProduct(Product product)throws BusinessException;

}
