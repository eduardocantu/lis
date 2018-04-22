package com.eduardo.lis.service;

import java.util.List;

import com.eduardo.lis.business.exception.InvalidOrderException;

public interface TestManagerServiceFacade {

	List<String> process(String orderId) throws InvalidOrderException;
}
