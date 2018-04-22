package com.eduardo.lis.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.eduardo.lis.business.exception.InvalidOrderException;
import com.eduardo.lis.business.operation.Calculation;
import com.eduardo.lis.business.operation.Operation;
import com.eduardo.lis.domain.Order;
import com.eduardo.lis.domain.test.Biochemistry;
import com.eduardo.lis.domain.test.Test;
import com.eduardo.lis.repository.OrderRepository;
import com.eduardo.lis.service.OrderProcessor;
import com.eduardo.lis.service.TestManagerServiceFacade;
import com.eduardo.lis.service.TestManagerServiceFacadeImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestManagerServiceFacadeTest {

	private static final String ORDER_ID = "orderId";

	private static final String RESULTS_LINE_1 = "Executing calculation under Biochemistry test.";
	private static final String RESULTS_LINE_2 = "prop2=>val2";
	private static final String RESULTS_LINE_3 = "prop1=>val1";
	private static final String RESULTS_LINE_4 = "bio prop1=>bio val1";
	private static final String RESULTS_LINE_5 = "bio prop2=>bio val2";

	@Mock
	private OrderRepository orderRepository;

	@Mock
	private OrderProcessor orderProcessor;

	@InjectMocks
	private TestManagerServiceFacade lenderService = new TestManagerServiceFacadeImpl(orderRepository, orderProcessor);

	@Before
	public void setUp() {
		Order order = getOrder();
		List<String> orderResult = Arrays.asList(
				new String[] { RESULTS_LINE_1, RESULTS_LINE_2, RESULTS_LINE_3, RESULTS_LINE_4, RESULTS_LINE_5 });

		when(orderRepository.getOrderById(ORDER_ID)).thenReturn(order);
		when(orderProcessor.process(order)).thenReturn(orderResult);
	}

	private Order getOrder() {
		Order order = new Order();

		List<Test> tests = new ArrayList<>();
		Biochemistry biochemistryTest = new Biochemistry();

		Map<String, Object> properties = new HashMap<>();
		properties.put("prop1", "val1");
		properties.put("prop2", "val2");
		biochemistryTest.setProperties(properties);

		Map<String, Object> specificProperties = new HashMap<>();
		specificProperties.put("bio prop1", "bio val1");
		specificProperties.put("bio prop2", "bio val2");
		biochemistryTest.setSpecificProperties(specificProperties);

		tests.add(biochemistryTest);
		order.setTests(tests);

		List<Operation> operations = new ArrayList<>();
		operations.add(new Calculation());
		order.setOperations(operations);
		return order;
	}

	@org.junit.Test
	public void given_order_id_then_should_return_list_of_results() throws InvalidOrderException {
		List<String> actual = lenderService.process(ORDER_ID);
		assertThat(actual.size(), is(5));
		assertThat(actual.get(0), is(RESULTS_LINE_1));
		assertThat(actual.get(1), is(RESULTS_LINE_2));
		assertThat(actual.get(2), is(RESULTS_LINE_3));
		assertThat(actual.get(3), is(RESULTS_LINE_4));
		assertThat(actual.get(4), is(RESULTS_LINE_5));
	}

	@org.junit.Test(expected = InvalidOrderException.class)
	public void given_wrong_order_id_then_should_throw_exception() throws InvalidOrderException {
		lenderService.process("");
	}
}
