package com.eduardo.lis.domain.test;

import java.util.Map;

import com.eduardo.lis.domain.TestVisitor;
import com.eduardo.lis.domain.VisitableTest;
import com.eduardo.lis.domain.sample.Sample;

import lombok.Data;

@Data
public abstract class Test implements VisitableTest {

	private Map<String, Object> properties;

	private Sample sample;

	@Override
	public void accept(TestVisitor visitor) {
		visitor.visit(this);
	}

}
