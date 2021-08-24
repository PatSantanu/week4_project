package com.app;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.customer.dao.impl.CustomerDAOImpl;
import com.app.customer.service.CustomerService;
import com.app.customer.service.impl.CustomerServiceImpl;
import com.app.dao.CustomerDAO;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Product;

public class Main {

	private static Logger log = Logger.getLogger(Main.class);
	static String empMail = "psantanu@gmail.com";
	static String empPassword = "Sanu@1234";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Customer customerStatic = new Customer();
		CustomerService customerservice = new CustomerServiceImpl();
		Customer customer = null;
		Product product = null;
		Cart cart = new Cart();
		CustomerDAO customerDAO = new CustomerDAOImpl();
		log.info("    ============================    ");

		log.info("****| WELCOME TO SHOPPING SPOT |****");

		log.info("    ============================    ");
		int ch = 0;
		do {
			log.info("\n*****MAIN MENU******");
			log.info("1)Login as customer");
			log.info("2)Register as new Customer");
			log.info("3)Login as employee");
			log.info("4)Exit");

			log.info("Enter Your Choice(1-4)");
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				log.warn(e.getMessage());
			}
			switch (ch) {
			// CUSTOMER LOGIN
			
			case 1:
				try {
				log.info("###   Welcome To Customer Login   ###");

				log.info("Enter your mail-->");
				String email = scanner.nextLine();
				
					if (customerDAO.isEmailAlreadyExist(email)) {

						log.info("Enter your password-->");
						String password = scanner.nextLine();
						if (customerDAO.isPasswordAlreadyExist(email, password)) {

							customer = new Customer(email, password);
							try {
								int var = customerservice.login(customer);
								if (var == 1) {
									int option = 0;
									customerStatic = customerservice.getCustomerByEmailId(email);

									log.info("You are logged in successfully!!");
								
									log.info("Welcome " + email + " to SHOPPING SPOT");
									do {
										log.info("1)Search Products");
										// log.info("2)Add Product to Cart");
										log.info("2)Go to my Cart");

										// TO DO viewCart(Customer customer)

										log.info("3)view Order ");
										log.info("4)logout ");
										// log.info("6)");

										log.info("Enter Your Choice(1-6)");
										try {
											option = Integer.parseInt(scanner.nextLine());
										} catch (NumberFormatException e) {
											log.warn(e.getMessage());
										}
										switch (option) {
										case 1:
											int option2 = 0;
											log.info("Welcome to product search  (Choose below filter to search with)");

											do {
												log.info("1)Search By Produt Name");
												log.info("2)Search By Prodcut Catagory");

												log.info("Enter Your Choice(1-2):");
												try {
													option2 = Integer.parseInt(scanner.nextLine());
												} catch (NumberFormatException e) {
													log.warn(e.getMessage());
												}
												switch (option2) {

												case 1:
													log.info("Enter Product Name to get product details");

													String productName = scanner.nextLine();

													try {
														List<Product> productList = customerservice
																.getProductsByProductName(productName);
														if (productList != null && productList.size() > 0) {
															log.info("Total there are " + productList.size()
																	+ " number of products available for the product "
																	+ productName.toUpperCase()
																	+ " printing the products");
															for (Product i : productList) {
																log.info(i);
															}
//			        								
														}
													} catch (BusinessException e) {
														log.warn(e.getMessage());
													}

													break;
												case 2:

													log.info("Enter Product Catagory to get product details");

													String productCatagory = scanner.nextLine();
													int success = 0;
													do {

														try {
															List<Product> productList1 = customerservice
																	.getProductsByProductCatagory(productCatagory);
															if (productList1 != null && productList1.size() > 0) {
																log.info("Total there are " + productList1.size()
																		+ " number of products available for the product "
																		+ productCatagory.toUpperCase()
																		+ " printing the products");
																for (Product i : productList1) {
																	log.info(i);
																}
																log.info("Enter your choice : ");
																int productChoice = Integer
																		.parseInt(scanner.nextLine());
																Product product2 = new Product();
																product2 = customerservice
																		.getProductByProductId(productChoice);

																log.info("Enter quantity of product");
																int quantity1 = Integer.parseInt(scanner.nextLine());
																int cartprodid1 = product2.getProd_id();
																// int cartcustid1=customerStatic.getC_id();
																// double price1=quantity1*(product2.getProductPrice());

																cart.setQuantity(quantity1);
																cart.setPrice(quantity1 * product2.getProductPrice());
																cart.setCartcustid(customerStatic.getC_id());
																cart.setCartprodid(cartprodid1);
																// cart= new
																// Cart(quantity1,cartprodid1,cartcustid1,price1);

																success = customerservice.addProductToCart(cart);
																if (success == 1) {
																	log.info("Product added to cart successfully");
																}

															}
														} catch (BusinessException e) {
															log.warn(e.getMessage());
														}

													} while (success != 1);
													break;

												default:
													log.warn(
															"Invalid choice....Choice should be only number betwwen 1-2 only!!!");
													break;

												}

											} while (option2 != 2);

											break;

										case 2:
											log.info("Welcome to your cart");
											// viewCart(Customer customer)
											log.info("Enter your customer id to view your cart");
											int customerId = Integer.parseInt(scanner.nextLine());
											Cart cart1 = new Cart();
											cart1 = customerservice.viewCart(customerId);
											log.info("Details of your cart Is listed below");
											log.info(cart1);

											// log.info("Enter cart id to place order");

											break;

										case 3:
											log.info("Under Construction");

											break;
										case 4:
											log.info("You Are Logged Out From SHOPPING SPOT");

											break;

										default:
											log.warn(
													"Invalid choice....Choice should be only number betwwen 1-6 only!!!");
											break;
										}
									} while (option != 4);

								}

							} catch (BusinessException e) {
								log.warn(e);
							}

						}

					}
				} catch (NumberFormatException | BusinessException e1) {
					// TODO Auto-generated catch block
					log.warn(e1.getMessage());
				}

				break;

			// NEW CUSTOMER REGISTRATION
			case 2:
				int c1 = 0;
				do {

					try {

						log.info("\n\nWelcome to SHOPPING SPOT Customer Registration");
						log.info("2. Enter your First Name:");
						String firstName = scanner.nextLine();

						log.info("3. Enter your Last Name: ");
						String lastName = scanner.nextLine();
						log.info("1. Enter your email:");
						String email1 = scanner.nextLine();

						if (customerservice.isValidCustomerEmailId(email1)) {
							log.info("4. Enter your Password to create password:");
							String password1 = scanner.nextLine();
							if (customerservice.isValidCustomerPassword(password1)) {
								customer = new Customer(firstName, lastName, email1, password1);

								c1 = customerservice.createCustomer(customer);
								if (c1 == 1) {
									log.info("Customer Registered Successfully");
								}

							}

						}

					} catch (BusinessException e) {
						log.warn(e.getMessage());
					}
				} while (c1 != 1);

				break;

			// EMPLOYEE LOGIN

			case 3:
				log.info("Welcome to Employee Login ");
				log.info("Enter your Email");
				String email2 = scanner.nextLine();
				log.info("Enter your password");
				String password2 = scanner.nextLine();
				if (email2.equals(empMail) && password2.equals(empPassword)) {
					log.info("Employee loggedin successfully");

					int option1 = 0;
					log.info("You are logged in successfully " + email2);
					log.info("Welcome to Employee Portal of SHOPPING SPOT");
					do {
						log.info("1)Add a new Product");
						log.info("2)Search a Customer");
						log.info("3)Logout");

						log.info("Enter Your Choice(1-4)");
						try {
							option1 = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
							log.warn(e.getMessage());

						}
						switch (option1) {
						case 1:
							log.info("Enter Product Details to Add a New Product");

							log.info("2. Enter Product Name:");
							String productName1 = scanner.nextLine();
							log.info("3. Enter Product Catagory: ");
							String productCatagory1 = scanner.nextLine();
							log.info("1. Enter Product Price:");
							double productPrice1 = Double.parseDouble(scanner.nextLine());

							product = new Product(productName1, productCatagory1, productPrice1);

							try {
								customerservice.addProduct(product);
								log.info("Product added Successfully");
							} catch (BusinessException e) {
								log.info(e.getMessage());
							}

							break;

						case 2:
							log.info("Welcome to Customer Search");

							log.info("\nEnter the Customer_id");
							int b = Integer.parseInt(scanner.nextLine());
							Customer customer1 = null;
							try {
								customer1 = customerservice.getCustomerByCustomerId(b);
							} catch (BusinessException e) {
								log.info(e);
							}

							if (customer1 != null) {
								log.info("Details of Customer Is listed below");
								log.info(customer1);
							}

							break;

						case 3:
							log.info("You are Logged Out");

							break;
						default:
							log.warn("Invalid choice....Choice should be only number betwwen 1-3 only!!!");
							break;

						}

					} while (option1 != 3);

				} else {
					log.info("Invalid username or password given please enter valid password or username");
				}

				break;
			case 4:
				log.info("You Are Exited From Our Application");

				break;
			default:
				log.warn("Invalid choice....Choice should be only number betwwen 1-4 only!!!");
				break;
			}
		} while (ch != 4);
	}
}
