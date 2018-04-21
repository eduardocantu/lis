package com.eduardo.lis.business.operation;

import java.util.List;

import com.eduardo.lis.domain.TestVisitor;

public interface Operation extends TestVisitor {

	List<String> getResults();
}
