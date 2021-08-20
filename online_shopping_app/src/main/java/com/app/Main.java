package com.app;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.customer.service.CustomerService;
import com.app.customer.service.impl.CustomerServiceImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;


public class Main {
	private static Logger log=Logger.getLogger(Main.class);
	static String empMail="psantanu@gmail.com";
	static String empPassword="Sanu@1234";
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		CustomerService customerservice=new CustomerServiceImpl();
		Customer customer=null;
		Product product=null;
		log.info("    ============================    ");
		
		log.info("****| WELCOME TO SHOPPING SPOT |****");
		
		log.info("    ============================    ");
		int ch=0;
		do {
		log.info("\n*****MAIN MENU******");
		log.info("1)Login as customer");
		log.info("2)Register as new Customer");
		log.info("3)Login as employee");
		log.info("4)Exit");
		
		log.info("Enter Your Choice(1-4)");
		try {
			ch=Integer.parseInt(scanner.nextLine());
			}catch(NumberFormatException e) {
				log.warn(e.getMessage());
			}
			
			
			switch (ch) {
			
							//CUSTOMER LOGIN
			
			
			case 1:log.info("###   Welcome To Customer Login   ###");
				
				
				log.info("Enter your mail-->");
				String email=scanner.nextLine();
				log.info("Enter your password-->");
				String password=scanner.nextLine();
				 customer=new Customer(email,password);
				try {
					customer=customerservice.login(customer);
					if(customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
						int option=0;
						
						log.info("You are logged in successfully!!");
						log.info("Welcome "+email+" to SHOPPING SPOT");
						do {
						log.info("1)Search Products");
						log.info("2)Add Product to Cart");
						log.info("3)View Cart");
						log.info("4)Place an order ");
	                    log.info("5)View Order ");
	                    log.info("6)to logout");
	                    
	                    log.info("Enter Your Choice(1-6)");
	                    try {
	            			option=Integer.parseInt(scanner.nextLine());
	            			}catch(NumberFormatException e) {
	            				log.warn(e.getMessage());
	            			}
	                    switch(option) {
	                    case 1:
	                    	int option2=0;
	                    	log.info("Welcome to product search  (Choose below filter to search with)");
	                    	
	                    	do{
	                    		log.info("1)Search By Produt Name");
	                    		log.info("2)Search By Prodcut Catagory");
	                    		
	        
	                    		
	                    		
	                    		log.info("Enter Your Choice(1-2):");
	                    		try {
	                    			option2=Integer.parseInt(scanner.nextLine());
	                    			}catch(NumberFormatException e) {
	                    				log.warn(e.getMessage());
	                    			}
	                    		switch(option2) {
	                    		
	                    		case 1:
	                    			log.info("Enter Product Name to get product details");
	                    			
	                    			String productName=scanner.nextLine();
	                    			try {
	        							List<Product> productList=customerservice.getProductsByProductName(productName);
	        							if(productList!=null && productList.size()>0) {
	        								log.info("Total there are "+productList.size()+" number of products available for the product "+productName.toUpperCase()+" printing the products");
	        								for(Product i:productList) {
	        									log.info(i);
	        								}
//	        								for(int i=0;i<productList.size();i++){
//	        								    System.out.println(productList.get(i));
//	        								} 
	        							}
	        						} catch (BusinessException e) {
	        							log.warn(e.getMessage());
	        						}
	                    			
	                    		
	                    		
	                    		
	                    		
	                    			
	                    			
	                    			
	                    			
	    	        			
		    						break;
	                    		case 2:
	                    			
	                    			
	                    			log.info("Enter Product Catagory to get product details");
                    			
                    			String productCatagory=scanner.nextLine();
                    			try {
        							List<Product> productList1=customerservice.getProductsByProductCatagory(productCatagory);
        							if(productList1!=null && productList1.size()>0) {
        								log.info("Total there are "+productList1.size()+" number of products available for the product "+productCatagory.toUpperCase()+" printing the products");
        								  for(Product i:productList1) {
        									 log.info(i);
        								}
//        								for(int j=0;j<productList1.size();j++){
//        								    System.out.println(productList1.get(j));
//        								} 
        							}
        						} catch (BusinessException e) {
        							log.warn(e.getMessage());
        						}
                    			
                    			
                    			
	    	        			
		    						break;
	                    
	                    		default:
	                				log.warn("Invalid choice....Choice should be only number betwwen 1-2 only!!!");
	                				break;
	                    
	                    		}
	                    	}while(option2!=2);
	                    	
	                    	
	                    	
	                    	
	                    	
	    					break;
	    					
	    					
	                    
	                    case 2:log.info("Under Construction");
	        			
	    					break;
	                    case 3:log.info("Under Construction");
	        			
    					break;
	                    case 4:log.info("Under Construction");
	        			
    					break;
	                    case 5:log.info("Under Construction");
	        			
    					break;
	    					
	    					
	                    case 6:log.info("You Are Logged Out From SHOPPING SPOT");
	        			
	    					break;
	    					
	                    default:
	        				log.warn("Invalid choice....Choice should be only number betwwen 1-6 only!!!");
	        				break;
	                    }
						}while(option!=6);
					
					}
					
				}catch(BusinessException e) {
					log.warn(e);
				}
			
			
					break;
			
					 //NEW CUSTOMER REGISTRATION
			case 2:			
					log.info("\n\nWelcome to SHOPPING SPOT Customer Registration");
					log.info("2. Enter your First Name:");
					String firstName=scanner.nextLine();
					log.info("3. Enter your Last Name: ");
					String lastName=scanner.nextLine();
					log.info("1. Enter your email:");
					String email1=scanner.nextLine();
					log.info("4. Enter your Password to create password:");
					String password1=scanner.nextLine();
					customer = new Customer(firstName,lastName,email1,password1);
				try {
					customerservice.createCustomer(customer);
					log.info("Customer Registered Successfully2");
				} catch (BusinessException e) {
					log.info(e.getMessage());
				}
				
				break;
				
				
							//EMPLOYEE LOGIN
				
			case 3:log.info("Welcome to Employee Login ");
					log.info("Enter your Email");
					String email2=scanner.nextLine();
					log.info("Enter your password");
					String password2=scanner.nextLine();
					if(email2.equals(empMail) && password2.equals(empPassword)) {
						log.info("Employee loggedin successfully");
						
						int option1=0;
						log.info("You are logged in successfully "+email2 );
						log.info("Welcome to Employee Portal of SHOPPING SPOT");
						do {
							log.info("1)Add a new Product");
							log.info("2)Search a Customer");
							log.info("3)Logout");
							
							log.info("Enter Your Choice(1-4)");
							try {
								option1=Integer.parseInt(scanner.nextLine());
								}catch(NumberFormatException e) {
									log.warn(e.getMessage());
									
								}
							switch (option1) {
							 case 1:
								 log.info("Enter Product Details to Add a New Product");
								 
								 
								 log.info("2. Enter Product Name:");
								 String productName1=scanner.nextLine();
								 log.info("3. Enter Product Catagory: ");
								 String productCatagory1=scanner.nextLine();
								 log.info("1. Enter Product Price:");
								 double productPrice1=Double.parseDouble(scanner.nextLine());
								 
								 product = new Product(productName1,productCatagory1,productPrice1);
								 
								 try {
										customerservice.addProduct(product);
										log.info("Product added Successfully");
									} catch (BusinessException e) {
										log.info(e.getMessage());
									}
								 
								 
								 
								 
								 
								 
								 
								 
								 
								 
			        			
								 break;
		    				
							 case 2:log.info("Welcome to Customer Search");
			        			
		    						break;
							 case 3:log.info("You are Logged Out");
			        			
		    						break;
							 default:
									log.warn("Invalid choice....Choice should be only number betwwen 1-3 only!!!");
									break;
							 
							}
							
							
							
							
						}while(option1!=3);
						
						
						
					}
					
				break;
			case 4:log.info("You Are Exited From Our Application");
			
				break;
			default:
				log.warn("Invalid choice....Choice should be only number betwwen 1-4 only!!!");
				break;
			}
		}while(ch!=4 );
	}
}

	