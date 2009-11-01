package org.grumpysoft.pl;

import java.util.ArrayList;

import junit.framework.TestCase;

public class JSONResponseTranslatorTest extends TestCase {
	
	public void testTranslator() {
		String in = "{\n" +
				"pubs: [\n" +
				"{\n" +
                "\"id\": 1001,\n" +
                "\"name\": \"Old Suffolk Punch (ex O.S.P.)\",\n" +
                "\"latitude\": 51.4887,\n" +
                "\"longitude\": -0.222812\n" +
                "},\n"+
                "{\n" +
                "\"id\": 1002,\n" +
                "\"name\": \"Henry Holland\",\n" +
                "\"latitude\": 51.5148,\n" +
                "\"longitude\": -0.151689\n" +
                "}\n" +
                "],\n" +
                "error: {\n" +
                "message: \"\"\n" +
       			"}\n"+
				"}";
		System.err.println(in);
		JSONResponseTranslator to_test = new JSONResponseTranslator();
		ArrayList<Pub> resulting_pubs = to_test.fromString(in);
		assertEquals(2, resulting_pubs.size());
		Pub one = resulting_pubs.get(0);
		assertEquals(1001, one.id());
		assertEquals("Old Suffolk Punch (ex O.S.P.)",one.name());
		assertEquals(51.4887, one.latitude());
		assertEquals(-0.222812, one.longitude());
	}
}
