package testsuites;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import testlib.AmazonTest;
import testlib.GootleTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	GootleTest.class,
	AmazonTest.class
})

public class TestSuite {
 
}