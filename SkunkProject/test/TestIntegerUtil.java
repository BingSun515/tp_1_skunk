import static org.junit.Assert.*;

import org.junit.Test;

public class TestIntegerUtil {

	@Test
	public void GetParsedValue() {
		IntegerUtil iu1 = new IntegerUtil();
		assertEquals(123, iu1.getParsedValue("123"));
	}

	@Test
	public void testParseValueException()
	{
		IntegerUtil iu1 = new IntegerUtil();
		iu1.getParsedValue("123.34");
	}
}
