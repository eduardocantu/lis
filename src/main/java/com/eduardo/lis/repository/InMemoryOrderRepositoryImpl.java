package com.eduardo.lis.repository;

import java.util.Map;

import com.eduardo.lis.domain.Order;

public class InMemoryOrderRepositoryImpl implements OrderRepository {

	private Map<String, Order> orders;

	public InMemoryOrderRepositoryImpl(Map<String, Order> orders) {
		this.orders = orders;
	}

	@Override
	public Order getOrderById(String id) {
		return orders.get(id);
	}

}
