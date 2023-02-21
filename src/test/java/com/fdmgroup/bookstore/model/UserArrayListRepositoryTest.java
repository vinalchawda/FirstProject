package com.fdmgroup.bookstore.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.bookstore.data.UserArrayListRepository;

public class UserArrayListRepositoryTest {

	private  List<User> users;

	@Before
	public  void init() {
		
		//create EBook 
		EBook ebook = new EBook();
		ebook.setAuthor("Robert Munsch");
		ebook.setItemId(101);
		ebook.setTitle("Down The Drain");
		ebook.setPrice(20);
		ebook.sizeMegaBytes=20;
		ebook.setBookGenre(BookGenre.ACTION);
		
		//Create Order
		Order order = new Order();
		order.setOrderId(101);
		order.setUserId(2);
		order.setOrderDateTime(LocalDateTime.now());
		order.setBookOrdered(ebook);
		
		List<Order> orders = new ArrayList<Order>();
		orders.add(order);
		
		User user1 = new User(2, "Vinal", "Chawda", "vinalchawda", "FDM123", "vinalfdm@gmail.com", orders);
		User user2=new User();
		
		user2.setUserId(UserArrayListRepository.getId());
		user2.setEmail("vinalfdm@gmail.com");
		user2.setFirstName("Aayushi");
		user2.setLastName("Chawda");
		user2.setOrders(orders);
		user2.setUserName("AayushiChawda");
		user2.setPassword("FDM234");
		
		users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);

	}

	@Test
	public void testVaidateUserWithValidUserNmaeandPassword() {
		UserArrayListRepository userArrayListRepository = new UserArrayListRepository(users);
		assertTrue(userArrayListRepository.validate("vinalchawda", "FDM123"));
	}

	@Test
	public void testVaidateUserWithInValidUserNameandPassword() {
		UserArrayListRepository userArrayListRepository = new UserArrayListRepository(users);
		assertFalse(userArrayListRepository.validate("vinalchawda1", "FD460"));
	}

	@Test
	public void testFindByValidUserName() {
		UserArrayListRepository userArrayListRepository = new UserArrayListRepository(users);
		assertSame("vinalchawda", userArrayListRepository.findByUsername("vinalchawda").getUserName());
	}

	@Test
	public void testFindByInValidUserName() {
		UserArrayListRepository userArrayListRepository = new UserArrayListRepository(users);
		assertNull(userArrayListRepository.findByUsername("vinalchawda56"));
	}

	@Test
	public void testSaveUser() {
		Book book = new Book();
		Order order = new Order();
		order.setBookOrdered(book);
		List<Order> orders = new ArrayList<Order>();
		orders.add(order);

		User u1 = new User(100, "Vinal1", "Chawda1", "vinalchawda1", "FDM13", "vinalfdm1@gmail.com", orders);
		UserArrayListRepository userArrayListRepository = new UserArrayListRepository(users);
		assertSame("vinalchawda1", userArrayListRepository.save(u1).getUserName());
		
	}
	
	@Test
	public void testDeleteUser() {
		Book book = new Book();
		Order order = new Order();
		order.setBookOrdered(book);

		List<Order> orders = new ArrayList<Order>();
		orders.add(order);

		User u1 = new User(2, "Vinal1", "Chawda1", "vinalchawda1", "FDM13", "vinalfdm1@gmail.com", orders);
		List<User> userList = new ArrayList<User>();
		UserArrayListRepository userArrayListRepository = new UserArrayListRepository();
		userArrayListRepository.setUsers(userList);
		
		userArrayListRepository.delete(u1);
		
		assertTrue(!userArrayListRepository.getUsers().contains(u1));
		
	}
	
	@Test
	public void testGenerateId() {
		
		UserArrayListRepository userArrayListRepository = new UserArrayListRepository();
		assertSame(2, userArrayListRepository.generateID());
	}
	

	@Test
	public void testFindUserByValidId() {
		
		UserArrayListRepository userArrayListRepository = new UserArrayListRepository(users);
		assertNotNull(userArrayListRepository.findById(2));
	}
	
	@Test
	public void testFindUserByInvalidId() {
		
		UserArrayListRepository userArrayListRepository = new UserArrayListRepository(users);
		assertNull(userArrayListRepository.findById(1000));
	}
	
	@Test
	public void testFindAll() {
		
		UserArrayListRepository userArrayListRepository = new UserArrayListRepository(users);
		assertSame(2, userArrayListRepository.findAll().size());
		
	}
}
