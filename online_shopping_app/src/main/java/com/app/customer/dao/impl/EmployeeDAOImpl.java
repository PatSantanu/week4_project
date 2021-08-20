package com.app.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.EmployeeDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int addProduct(Product product) throws BusinessException {
		int d=0;
		try(Connection connection=MySqlDbConnection.getConnection()){
			
			String sql="INSERT INTO product(prod_id,productName,productCatagory,productPrice)VALUES(?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, product.getProd_id());
			preparedStatement.setString(2, product.getProductName());
   		    preparedStatement.setString(3, product.getProductCatagory());
			preparedStatement.setDouble(4, product.getProductPrice());
			d=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured, please contact support");
		}
		
		return d;
	}

}
