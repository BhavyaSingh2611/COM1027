package ProblemSet_9a;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChargeTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidStandard() {
	Service service = new Service("ROOM12345", "Room", VATRate.STANDARD);
	Charge charge = new Charge(service, -100.5);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidZero() {
	Service service = new Service("DRIN32165", "Drinks", VATRate.ZERO);
	Charge charge = new Charge(service, 0);
    }

    @Test
    public void testLow() {
	Service service = new Service("ROOM12345", "Room", VATRate.LOW);
	Charge charge = new Charge(service, 100);

	assertEquals(service, charge.getService());
	assertEquals(100, charge.getCharge(), 0);
	assertEquals(5, charge.calculateVAT(), 0);
    }

    @Test
    public void testStandard() {
	Service service = new Service("ROOM12345", "Room", VATRate.STANDARD);
	Charge charge = new Charge(service, 100);

	assertEquals(service, charge.getService());
	assertEquals(100, charge.getCharge(), 0);
	assertEquals(20.0, charge.calculateVAT(), 0);
    }

}