package com.eduardo.lis.business.operation;

import java.util.ArrayList;
import java.util.List;

import com.eduardo.lis.domain.test.Biochemistry;
import com.eduardo.lis.domain.test.Hematology;
import com.eduardo.lis.domain.test.Immunology;
import com.eduardo.lis.domain.test.Microbiology;
import com.eduardo.lis.domain.test.Test;

public class Calculation implements Operation {

	ArrayList<String> results = new ArrayList<>();

	@Override
	public void visit(Test test) {
		baseTest(test);
	}

	@Override
	public void visit(Biochemistry test) {
		results.add("Executing calculation under Biochemistry test.");
		test.getProperties().keySet().forEach(key -> {
			results.add(key + "=>" + test.getProperties().get(key));
		});

		test.getSpecificProperties().keySet().forEach(key -> {
			results.add(key + "=>" + test.getSpecificProperties().get(key));
		});
	}

	@Override
	public void visit(Hematology test) {
		baseTest(test);
	}

	@Override
	public void visit(Immunology test) {
		baseTest(test);
	}

	@Override
	public void visit(Microbiology test) {
		baseTest(test);
	}

	private void baseTest(Test test) {
		results.add("Executing calculation under basic test.");
		test.getProperties().keySet().forEach(key -> {
			results.add(key + "=>" + test.getProperties().get(key));
		});
	}

	@Override
	public List<String> getResults() {
		return results;
	}
}
