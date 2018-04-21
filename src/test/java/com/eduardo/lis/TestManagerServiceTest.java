package com.eduardo.lis;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eduardo.lis.business.operation.Calculation;
import com.eduardo.lis.business.operation.Operation;
import com.eduardo.lis.domain.Order;
import com.eduardo.lis.domain.test.Biochemistry;
import com.eduardo.lis.domain.test.Test;
import com.eduardo.lis.service.TestManagerServiceImpl;

public class TestManagerServiceTest {

	@org.junit.Test
	public void what() {
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

		List<String> actual = new TestManagerServiceImpl().process(order);
		assertThat(actual.size(), is(5));
		assertThat(actual.get(0), is("Executing calculation under Biochemistry test."));
		assertThat(actual.get(1), is("prop2=>val2"));
		assertThat(actual.get(2), is("prop1=>val1"));
		assertThat(actual.get(3), is("bio prop1=>bio val1"));
		assertThat(actual.get(4), is("bio prop2=>bio val2"));
	}
}
