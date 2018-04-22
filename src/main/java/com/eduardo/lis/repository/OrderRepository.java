package com.eduardo.lis.repository;

import com.eduardo.lis.domain.Order;

public interface OrderRepository {

	Order getOrderById(String id);
}
