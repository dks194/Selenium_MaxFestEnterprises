package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzer implements IRetryAnalyzer {

	private static int initialCount=0;
	private static int maxRetryCount=3;
	@Override
	public boolean retry(ITestResult result) {
		if(initialCount<maxRetryCount) {
			initialCount++;
			return true;
		}
		return false;
	}
  
}
