package com.mvn.junittest31;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value= Parameterized.class)
public class AppTest3 {
	
	private String expected;
	private String valueOne;

	
	public AppTest3(String expected, String valueOne) {
		super();
		this.expected = expected;
		this.valueOne = valueOne;

	}
	
	@Parameters
	public static Collection<String[]> getTestParameters(){
		return Arrays.asList(new String[][] {
			{"01045372233", "010-4537-2233"} 
			, {"01045372233", "010/4537:d2233"}
			, {"01045372233", "010?4537!2233"}
		});
	}
	// 실습3
	@Test
	public void test3() {
		App app = new App();
		assertEquals(expected, app.toNumber(valueOne));
		System.out.println(expected);
		
	}

}
