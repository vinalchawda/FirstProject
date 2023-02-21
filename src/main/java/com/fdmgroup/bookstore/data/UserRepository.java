package com.fdmgroup.bookstore.data;

import com.fdmgroup.bookstore.model.User;

public interface UserRepository extends Persistable,Removable,Searchable
{
	boolean validate(String usename, String password);

	User findByUsername(String username);

	
	
	
}
