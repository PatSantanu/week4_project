package online_shopping_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.customer.dao.impl.CustomerDAOImpl;
import com.app.customer.service.CustomerService;
import com.app.customer.service.impl.CustomerServiceImpl;
import com.app.dao.CustomerDAO;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Product;

class TestOnlineShoppingApp {
	CustomerService customerService;
	Customer customer;
	Product product;
	Cart cart;
	CustomerDAO customerdao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		customerService = new CustomerServiceImpl();
		customer = new Customer();
		product = new Product();
		cart = new Cart();
		customerdao = new CustomerDAOImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// @org.junit.jupiter.api.Test
	@Test
	void testCreateCustomer() {
		CustomerService customerService = new CustomerServiceImpl();
		Customer customer = new Customer("Santanur", "patraa", "saa@gmail.com", "sankar1234");
		try {
			assertEquals(1, customerService.createCustomer(customer));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	void testLogin() {
		customer.setEmail("sankar@gmail.com");
		customer.setPassword("sankar1234");
		try {
			assertEquals(1, customerService.login(customer));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	void loginWithWrongCreadential() {
		customer.setEmail("abcd@gmail.com");
		customer.setPassword("sankar12");
		try {
			assertEquals(0, customerService.login(customer));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	void getProductsByProductName() {
		List<Product> productlist = new ArrayList<>();
		product.setProductName("SamsungTV");
		product.setProductCatagory("TV");
		product.setProductPrice(5600.0);
		product.setProd_id(200);
		productlist.add(product);
		try {
			assertEquals(productlist, customerService.getProductsByProductName("SamsungTV"));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	void getProductsByProductCatagory() {
		List<Product> productlist = new ArrayList<>();
		product.setProductName("Iphone");
		product.setProductCatagory("Mobile");
		product.setProductPrice(9876.0);
		product.setProd_id(203);
		productlist.add(product);
		try {
			assertEquals(productlist, customerService.getProductsByProductCatagory("Mobile"));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	void getCustomerByCustomerId() {
		int d = 103;
		customer.setC_id(103);
		customer.setFirstName("Ashis");
		customer.setLastName("kumar");
		customer.setEmail("ashis@gmail.com");

		try {
			assertEquals(customer, customerService.getCustomerByCustomerId(d));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	void getProductByProductId() {
		int productChoice = 204;
		product.setProd_id(204);
		product.setProductName("RealmeBud");
		product.setProductCatagory("earphone");
		product.setProductPrice(3456.0);
		try {
			assertEquals(product, customerService.getProductByProductId(productChoice));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	void addProductToCart() {
		cart.setCartid(3);
		cart.setCartcustid(107);
		cart.setCartprodid(200);
		cart.setQuantity(2);
		cart.setPrice(11200.0);
		try {
			assertEquals(1, customerService.addProductToCart(cart));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	void addProductToCartWithWrongDetails() {
		cart.setCartid(4);
		cart.setCartcustid(108);
		cart.setCartprodid(345);
		cart.setQuantity(4);
		cart.setPrice(11223.0);
		try {
			assertEquals(0, customerService.addProductToCart(cart));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	void getCustomerByEmailId() {
		String email3 = "sumanta@gmail.com";
		customer.setC_id(108);
		customer.setEmail("sumanta@gmail.com");
		customer.setFirstName("Sumanta");
		customer.setLastName("Patra");
		customer.setPassword("sumanta1234");
		try {
			assertEquals(customer, customerService.getCustomerByEmailId(email3));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void isValidCustomerEmailId() {
		try {
			assertTrue(customerService.isValidCustomerEmailId("sankar@gmail.com"));

		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void isValidCustomerWrongEmailId() {
		try {
			assertFalse(customerService.isValidCustomerEmailId("sankargmail.com"));

		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void isValidCustomerPassword() {
		try {
			assertTrue(customerService.isValidCustomerPassword("Santanu@1456231"));

		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void isValidCustomerWrongPassword() {
		try {
			assertTrue(customerService.isValidCustomerPassword("Sa231"));

		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void isPasswordAlreadyExist() {
		try {
			String email="prabhat@gmail.com";
			String password="prabhat1234";
			assertTrue(customerdao.isPasswordAlreadyExist(email,password));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}
	@Test
	void isPasswordAlreadyNotExist() {
		try {
			String email="prabhat11232@gmail.com";
			String password="prabhat14";
			assertFalse(customerdao.isPasswordAlreadyExist(email,password));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}
	@Test
	void isEmailAlreadyExist() {
		try {
			String email="prabhat@gmail.com";
			assertTrue(customerdao.isEmailAlreadyExist(email));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}
	
	@Test
	void isEmailAlreadyNotExist() {
		try {
			String email="prabhat11232@gmail.com";
			
			assertFalse(customerdao.isEmailAlreadyExist(email));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}
	
	
}
