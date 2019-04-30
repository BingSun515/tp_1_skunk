import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Test;

public class TestConstants {

	@Test
	public void test() {
		//Hashtable<String, String> uiMessages = new Hashtable<String, String>();
		Constants c1 = new Constants();
		String key = "abc";
		String value = "123";
		c1.addUiMessage(key, value);
		assertEquals("123",c1.getUiMessage(key));
	}

}
