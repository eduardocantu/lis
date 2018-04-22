package com.eduardo.lis.service;

import java.util.List;

import com.eduardo.lis.domain.Order;

public interface OrderProcessor {

	List<String> process(Order order);
}
