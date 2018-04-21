package com.eduardo.lis.domain.test;

import java.util.Map;

import com.eduardo.lis.domain.TestVisitor;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Biochemistry extends Test {

	private Map<String, Object> specificProperties;

	@Override
	public void accept(TestVisitor visitor) {
		visitor.visit(this);
	}

}
