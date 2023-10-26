package ProblemSet_8a;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A simple class used to test the "Customer" class.
 *
 * @author Stella Kazamia
 */
public class CustomerTest {

    Customer customer = new Customer("Bob", "Ross");

    @Test
    public void testCustomerConstruction() {
	assertEquals('B', customer.getName());
	assertEquals("Ross", customer.getSurname());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCustomerConstruction() {
	customer = new Customer("alice", "wOnderland");
    }

    @Test
    public void testNewCustomerConstruction() {
	customer = new Customer("Stella", "Kazamia");
	assertEquals('S', customer.getName());
	assertEquals("Kazamia", customer.getSurname());
    }

    @Test
    public void testNewValidateInfo() {
	customer = new Customer("Shujun", "Li");
	assertEquals('S', customer.getName());
	customer.setSurname("li");
	assertEquals(false, customer.validateInfo(customer.getSurname()));
    }

    @Test
    public void testtoString() {
	customer = new Customer("Maria", "Zaid");
	assertEquals("M. Zaid", customer.toString());
    }

    @Test
    public void testValidateInfo() {
	customer = new Customer("Maria", "Zaid");
	assertEquals(true, customer.validateInfo(customer.getSurname()));
    }

}
