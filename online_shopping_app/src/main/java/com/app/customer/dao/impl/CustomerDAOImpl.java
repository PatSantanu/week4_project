package com.app.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
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
	public int login(Customer customer1) throws BusinessException {
		//Customer customer=null;
		int var=0;
		
		try(Connection connection=MySqlDbConnection.getConnection()){
		
			String sql="select email, password from customer where email=? and password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, customer1.getEmail());
			preparedStatement.setString(2, customer1.getPassword());
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				return 1;
				
		
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return var;
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

	@Override
	public Customer getCustomerByCustomerId(int c_id) throws BusinessException {
		Customer customer=null;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select c_id, firstName,lastName, email from customer where c_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, c_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer=new Customer();
				customer.setC_id(resultSet.getInt("c_id"));
				customer.setFirstName(resultSet.getString("firstName"));
				customer.setLastName(resultSet.getString("lastName"));
				customer.setEmail(resultSet.getString("email"));
				
				
				
			
			}else {
				throw new BusinessException("Entered Customer id doesnt exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
	
	
	
	
	return customer;
	}

	@Override
	public Product getProductByProductId(int productId) throws BusinessException {
		Product product=new Product();
		try(Connection connection=MySqlDbConnection.getConnection()) {
			String sql="select prod_id, productName, productCatagory, productPrice from product where prod_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				product.setProd_id(resultSet.getInt("prod_id"));
				product.setProductName(resultSet.getString("productName"));
				product.setProductCatagory(resultSet.getString("productCatagory"));
				product.setProductPrice(resultSet.getDouble("productPrice"));
			}
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal error occured contact sysadmin");
			
		}
		
		return product;
	}

	@Override
	public int addProductToCart(Cart cart) throws BusinessException {
		int d1=0;
		
		try(Connection connection=MySqlDbConnection.getConnection()) {
			
			
			
			String sql="INSERT INTO  cart( cartcustid, cartprodid, quantity, price)VALUES(?,?,?,?)";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			//preparedStatement.setInt(1, cart.getCartid());
			preparedStatement.setInt(1, cart.getCartcustid());
   		    preparedStatement.setInt(2, cart.getCartprodid());
			preparedStatement.setInt(3, cart.getQuantity());
			preparedStatement.setDouble(4,cart.getPrice());
			d1=preparedStatement.executeUpdate();
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal error occured, please contact support");
		}
		
		return d1;
	}

	@Override
	public Customer getCustomerByEmailId(String email) throws BusinessException {
		Customer customer1=new Customer();
		try(Connection connection=MySqlDbConnection.getConnection()) {
			
			String sql="select c_id, firstName, lastName, email, password from customer where email=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer1.setC_id(resultSet.getInt("c_id"));
				customer1.setFirstName(resultSet.getString("firstName"));
				customer1.setLastName(resultSet.getString("lastName"));
				customer1.setEmail(resultSet.getString("email"));
				customer1.setPassword(resultSet.getString("password"));
				
			}
			
			
			
			}catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal error occured, please contact support");
		}
		
		return customer1;
	}

	@Override
	public Cart viewCart(int customerId) throws BusinessException {
		Cart cart=new Cart();
		try(Connection connection=MySqlDbConnection.getConnection()) {
			String sql="select cartid, cartcustid, cartprodid, quantity, price from cart where cartcustid=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				cart.setCartid(resultSet.getInt("cartid"));
				cart.setCartcustid(resultSet.getInt("cartcustid"));
				cart.setCartprodid(resultSet.getInt("cartprodid"));
				cart.setQuantity(resultSet.getInt("quantity"));
				cart.setPrice(resultSet.getDouble("price"));
				
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal error occured, please contact support");
		}
		return cart;
	}
	
	@Override
    public boolean isEmailAlreadyExist(String customerEmail) throws BusinessException {
        //boolean result = false;
		try(Connection connection =MySqlDbConnection.getConnection()) {
            String sql = "SELECT email FROM customer WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customerEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               return  true;
            
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e);
            throw new BusinessException("Internal error occurred! contact systemAdmin");
        }
		return false;
        
    }

    @Override
    public boolean isPasswordAlreadyExist(String customerEmail, String customerPassword) throws BusinessException {
        try(Connection connection = MySqlDbConnection.getConnection()) {
            String sql = "SELECT password FROM customer WHERE password = ? AND email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customerPassword);
            preparedStatement.setString(2,customerEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new BusinessException("Internal error occurred! contact systemAdmin");
        }
        return false;
    }
	
	
   }



