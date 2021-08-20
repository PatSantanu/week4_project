package com.app.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;

public class CustomerDAOImpl implements CustomerDAO {
	private static Logger log=Logger.getLogger(CustomerDAOImpl.class);
	
	//public int customerRegister(String firstName,String lastName,String email,String password) throws BusinessException{
		// TODO Auto-generated method stub
	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		int c=0;
		try(Connection connection=MySqlDbConnection.getConnection()){
			//Customer customer=new Customer();
			String sql="INSERT INTO customer(c_id,firstName,lastName,email, password)VALUES(?,?,?,?,?)";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getC_id());
			preparedStatement.setString(2, customer.getFirstName());
   		    preparedStatement.setString(3, customer.getLastName());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5,customer.getPassword());
			c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured, please contact support");
		}

			// TODO Auto-generated method stub
			return c;
	
	}

	@Override
	public Customer login(Customer customer) throws BusinessException {
        try(Connection connection=MySqlDbConnection.getConnection()){
        	String sql="select email,password from customer where c_id=?";
        	PreparedStatement preparedstatement=connection.prepareStatement(sql);
        	preparedstatement.setInt(1, customer.getC_id());
        	ResultSet resultset=preparedstatement.executeQuery();
        	if(resultset.next()) {
        		customer.setEmail(resultset.getString("email"));
        		customer.setPassword(resultset.getString("password"));
        		
        	}
        	
        }catch(ClassNotFoundException | SQLException e) {
        	log.warn(e);
        	log.info("internal error occured.....!");
        }
		return customer;
	}

	@Override
	public List<Product> getProductsByProductName(String productName) throws BusinessException {
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select prod_id,productName,productCatagory,productPrice from product where productName=? ";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product=new Product();
				product.setProd_id(resultSet.getInt("prod_id"));
				product.setProductName(resultSet.getString("productName"));
				product.setProductCatagory(resultSet.getString("productCatagory"));
				product.setProductPrice(resultSet.getDouble("productPrice"));
				productList.add(product);
			}
			
			if(productList.size()==0) {
				throw new BusinessException("No Products available for product "+productName);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return productList;
	}

	@Override
	public List<Product> getProductsByProductCatagory(String productCatagory) throws BusinessException {
		// TODO Auto-generated method stub
		List<Product> productList1=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select prod_id,productName,productCatagory,productPrice from product where productCatagory=? ";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, productCatagory);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Product product=new Product();
				product.setProd_id(resultSet.getInt("prod_id"));
				product.setProductName(resultSet.getString("productName"));
				product.setProductCatagory(resultSet.getString("productCatagory"));
				product.setProductPrice(resultSet.getDouble("productPrice"));
				productList1.add(product);
			}
			if(productList1.size()==0) {
				throw new BusinessException("No Products available for product "+productCatagory);
			}
			} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
			}
			
			
		
		
		return productList1;
	}
	
}

