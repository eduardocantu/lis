package com.eduardo.lis.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eduardo.lis.business.exception.InvalidOrderException;
import com.eduardo.lis.business.operation.Calculation;
import com.eduardo.lis.business.operation.Operation;
import com.eduardo.lis.domain.Order;
import com.eduardo.lis.domain.test.Biochemistry;
import com.eduardo.lis.domain.test.Test;

public class OrderProcessorImplTest {

	private static final String RESULTS_LINE_5_KEY = "bio prop2";
	private static final String RESULTS_LINE_5_VAL = "bio val2";
	private static final String RESULTS_LINE_5 = RESULTS_LINE_5_KEY + "=>" + RESULTS_LINE_5_VAL;

	private static final String RESULTS_LINE_4_KEY = "bio prop1";
	private static final String RESULTS_LINE_4_VAL = "bio val1";
	private static final String RESULTS_LINE_4 = RESULTS_LINE_4_KEY + "=>" + RESULTS_LINE_4_VAL;

	private static final String RESULTS_LINE_3_KEY = "prop1";
	private static final String RESULTS_LINE_3_VAL = "val1";
	private static final String RESULTS_LINE_3 = RESULTS_LINE_3_KEY + "=>" + RESULTS_LINE_3_VAL;

	private static final String RESULTS_LINE_2_KEY = "prop2";
	private static final String RESULTS_LINE_2_VAL = "val2";
	private static final String RESULTS_LINE_2 = RESULTS_LINE_2_KEY + "=>" + RESULTS_LINE_2_VAL;

	private static final String RESULTS_LINE_1 = "Executing calculation under Biochemistry test.";

	@org.junit.Test
	public void given_order_then_should_return_list_of_results() throws InvalidOrderException {
		List<String> actual = new OrderProcessorImpl().process(getOrder());
		assertThat(actual.size(), is(5));
		assertThat(actual.get(0), is(RESULTS_LINE_1));
		assertThat(actual.get(1), is(RESULTS_LINE_2));
		assertThat(actual.get(2), is(RESULTS_LINE_3));
		assertThat(actual.get(3), is(RESULTS_LINE_4));
		assertThat(actual.get(4), is(RESULTS_LINE_5));
	}

	private Order getOrder() {
		Order order = new Order();

		List<Test> tests = new ArrayList<>();
		Biochemistry biochemistryTest = new Biochemistry();

		Map<String, Object> properties = new HashMap<>();
		properties.put(RESULTS_LINE_3_KEY, RESULTS_LINE_3_VAL);
		properties.put(RESULTS_LINE_2_KEY, RESULTS_LINE_2_VAL);
		biochemistryTest.setProperties(properties);

		Map<String, Object> specificProperties = new HashMap<>();
		specificProperties.put(RESULTS_LINE_4_KEY, RESULTS_LINE_4_VAL);
		specificProperties.put(RESULTS_LINE_5_KEY, RESULTS_LINE_5_VAL);
		biochemistryTest.setSpecificProperties(specificProperties);

		tests.add(biochemistryTest);
		order.setTests(tests);

		List<Operation> operations = new ArrayList<>();
		operations.add(new Calculation());
		order.setOperations(operations);
		return order;
	}
}
