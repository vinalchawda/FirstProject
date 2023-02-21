package com.fdmgroup.bookstore.data;

import java.util.List;

import com.fdmgroup.bookstore.model.User;

/**
 * @author vinal
 *
 */
public class UserArrayListRepository implements UserRepository {

	private List<User> users;
	public static int id = 1;

	public UserArrayListRepository(List<User> users) {
		this.users = users;
	}

	public UserArrayListRepository() {
		}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		UserArrayListRepository.id = id;
	}

	public int generateID() {
		return id++;
	}

	@Override
	public User save(User user) {
	
		user.setUserId(generateID());
		users.add(user);
		return user;
	}

	@Override
	public User delete(User user) {
		users.remove(user);
		if (!users.contains(user)) {
			return user;
			}
		
		return null;
	}

	@Override
	public User findById(int id) {
		for (User user : users) {
			if (user.getUserId() == id)
				return user;
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return users;
	}

	@Override
	public boolean validate(String usename, String password) {
		for (User user : users) {
			if (user.getUserName().equals(usename) && user.getPassword().equals(password))
				return true;
		}

		return false;
	}

	@Override
	public User findByUsername(String username) {
		for (User user : users) {
			if (user.getUserName().equals(username))
				return user;
		}

		return null;
	}

}
