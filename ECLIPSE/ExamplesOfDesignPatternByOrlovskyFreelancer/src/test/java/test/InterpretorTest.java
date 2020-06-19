package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interpretorexample.AndExpression;
import interpretorexample.Expression;
import interpretorexample.OrExpression;
import interpretorexample.TerminalExpression;

class InterpretorTest {
	
	private TerminalExpression terminalExpressionObj;
	private OrExpression orExpressionObj;
	private AndExpression andExpressionObj;

	@BeforeEach
	public void setUp() {
		terminalExpressionObj = new TerminalExpression("John");
		orExpressionObj = new OrExpression(terminalExpressionObj, terminalExpressionObj);
		andExpressionObj = new AndExpression(terminalExpressionObj, terminalExpressionObj);
	}
	
	@Test
	public void checkIfTerminalExpressionExists() {
		assertNotNull(terminalExpressionObj,"terminal expression was not created!");
	}

	@Test
	public void checkIfOrExpressionExists() {
		assertNotNull(orExpressionObj, "or expression was not created!");
	}

	@Test
	public void checkIfAndExpressionExists() {
		assertNotNull(andExpressionObj, "and expression was not created!");
	}

	@Test
	public void InterpretorShowRun() {
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();

		System.out.println("John is male? " + isMale.interpret("John"));
		System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
	}

	// Rule: Robert and John are male
	public static Expression getMaleExpression() {
		Expression robert = new TerminalExpression("Robert");
		Expression john = new TerminalExpression("John");
		return new OrExpression(robert, john);
	}

	// Rule: Julie is a married women
	public static Expression getMarriedWomanExpression() {
		Expression julie = new TerminalExpression("Julie");
		Expression married = new TerminalExpression("Married");
		return new AndExpression(julie, married);
	}

}
