package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chainsofresponsibility.AbstractLogger;
import chainsofresponsibility.ConsoleLogger;
import chainsofresponsibility.ErrorLogger;
import chainsofresponsibility.FileLogger;

class ChainofResponsibilityTest {

	private ConsoleLogger consoleloggerobj;
	private ErrorLogger errorLoggerObj;
	private FileLogger fileLoggerObj;

	@BeforeEach
	public void setUp() {
		consoleloggerobj = new ConsoleLogger(AbstractLogger.ERROR);
		errorLoggerObj = new ErrorLogger(AbstractLogger.DEBUG);
		fileLoggerObj = new FileLogger(AbstractLogger.INFO);
	}

	@Test
	public void checkIfConsoleLoggerObjectCanBeCreated() {
		assertNotNull(consoleloggerobj);
	}

	@Test
	public void checkIfErrorLoggerObjectCanBeCreated() {
		assertNotNull(errorLoggerObj);
	}

	@Test
	public void checkIfFileLoggerObjectCanBeCreated() {
		assertNotNull(fileLoggerObj);
	}

	@Test
	public void showExecutionOfLoggers() {
		errorLoggerObj.setNextLogger(fileLoggerObj);
		errorLoggerObj.logMessage(AbstractLogger.INFO, "This is an information.");
		errorLoggerObj.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
		errorLoggerObj.logMessage(AbstractLogger.ERROR, "This is an error information.");
	}

}
