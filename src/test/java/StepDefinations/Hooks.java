package StepDefinations;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before
	public void BeforeScenario() {
		System.out.println("*****Before Scenarios*****");
		System.out.println("Open browser");
		System.out.println("browse to https:\\swiggy.com");
		System.out.println("**************************");
	}
	
	@After
	public void AfterScenario() {
		System.out.println("*****After Scenarios*****");
		System.out.println("Close browser");
		System.out.println("*************************");
	}

}
