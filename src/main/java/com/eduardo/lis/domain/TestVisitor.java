package com.eduardo.lis.domain;

import com.eduardo.lis.domain.test.Biochemistry;
import com.eduardo.lis.domain.test.Hematology;
import com.eduardo.lis.domain.test.Immunology;
import com.eduardo.lis.domain.test.Microbiology;
import com.eduardo.lis.domain.test.Test;

public interface TestVisitor {

	void visit(Test test);

	void visit(Biochemistry test);

	void visit(Hematology test);

	void visit(Immunology test);

	void visit(Microbiology test);

}