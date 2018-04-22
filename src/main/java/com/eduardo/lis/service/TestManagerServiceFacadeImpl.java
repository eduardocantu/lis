package com.eduardo.lis.service;

import java.util.List;

import com.eduardo.lis.business.exception.InvalidOrderException;
import com.eduardo.lis.domain.Order;
import com.eduardo.lis.repository.OrderRepository;

public class TestManagerServiceFacadeImpl implements TestManagerServiceFacade {

	private OrderRepository orderRepository;

	private OrderProcessor orderProcessor;

	public TestManagerServiceFacadeImpl(OrderRepository orderRepository, OrderProcessor orderProcessor) {
		this.orderRepository = orderRepository;
		this.orderProcessor = orderProcessor;
	}

	@Override
	public List<String> process(String orderId) throws InvalidOrderException {
		Order order = orderRepository.getOrderById(orderId);
		if (order == null) {
			throw new InvalidOrderException("The order [" + orderId + "] does not exists.");
		}
		return orderProcessor.process(order);
	}

}
