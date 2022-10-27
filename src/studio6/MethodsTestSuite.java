package studio6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import studio6.tests.RecursiveGCDTestSuite;
import studio6.tests.RecursiveGeometricSumTestSuite;
import studio6.tests.IterativeTestSuite;
import studio6.tests.RecursiveToReversedTestSuite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ IterativeTestSuite.class, RecursiveGeometricSumTestSuite.class, RecursiveGCDTestSuite.class,
		RecursiveToReversedTestSuite.class, })
public class MethodsTestSuite {

}
