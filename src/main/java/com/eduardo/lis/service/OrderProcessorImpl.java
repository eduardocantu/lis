package com.eduardo.lis.service;

import java.util.ArrayList;
import java.util.List;

import com.eduardo.lis.domain.Order;

public class OrderProcessorImpl implements OrderProcessor {

	@Override
	public List<String> process(Order order) {
		List<String> results = new ArrayList<>();
		order.getOperations().forEach(operation -> {
			order.getTests().stream().forEach(test -> {
				test.accept(operation);
				results.addAll(operation.getResults());
			});
		});
		return results;
	}

}
