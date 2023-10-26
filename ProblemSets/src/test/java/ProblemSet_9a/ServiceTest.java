package ProblemSet_9a;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ServiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCase() {
	new Service("news35652", "News", VATRate.STANDARD);
    }

    @Test(expected = NullPointerException.class)
    public void testInvalidCodeNull() {
	new Service(null, "Room", VATRate.STANDARD);
    }

    @Test(expected = NullPointerException.class)
    public void testInvalidNameNull() {
	new Service("ROOM1234", null, VATRate.STANDARD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumCharacter() {
	new Service("DRIN356", "Drinks", VATRate.STANDARD);
    }

    @Test
    public void testValid() {
	Service service = new Service("ROOM12345", "Room", VATRate.STANDARD);

	assertEquals("ROOM12345", service.getCode());
	assertEquals("Room", service.getName());
	assertEquals(VATRate.STANDARD, service.getRate());
    }

}
