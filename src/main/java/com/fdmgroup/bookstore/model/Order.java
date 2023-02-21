package com.fdmgroup.bookstore.model;

import java.time.LocalDateTime;

public class Order {
	int orderId;
	Book bookOrdered;
	int userId;
	LocalDateTime orderDateTime;

	public Order() {

	}

	public Order(int orderId, Book bookOrdered, int userId, LocalDateTime orderDateTime) {
		super();
		this.orderId = orderId;
		this.bookOrdered = bookOrdered;
		this.userId = userId;
		this.orderDateTime = orderDateTime;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Book getBookOrdered() {
		return bookOrdered;
	}

	public void setBookOrdered(Book bookOrdered) {
		this.bookOrdered = bookOrdered;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookOrdered == null) ? 0 : bookOrdered.hashCode());
		result = prime * result + ((orderDateTime == null) ? 0 : orderDateTime.hashCode());
		result = prime * result + orderId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (bookOrdered == null) {
			if (other.bookOrdered != null)
				return false;
		} else if (!bookOrdered.equals(other.bookOrdered))
			return false;
		if (orderDateTime == null) {
			if (other.orderDateTime != null)
				return false;
		} else if (!orderDateTime.equals(other.orderDateTime))
			return false;
		if (orderId != other.orderId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", bookOrdered=" + bookOrdered + ", userId=" + userId + ", orderDateTime="
				+ orderDateTime + "]";
	}

}
