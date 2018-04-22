package com.eduardo.lis.domain;

import java.util.List;

import com.eduardo.lis.business.operation.Operation;
import com.eduardo.lis.domain.test.Test;

import lombok.Data;

@Data
public class Order {

	private String id;

	private List<Test> tests;

	private Container<?> container;

	private List<Operation> operations;
}
