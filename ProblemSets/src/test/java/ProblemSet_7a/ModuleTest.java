package ProblemSet_7a;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ModuleTest {

    Module module = null;

    @Test
    public void ps7a_testInvalidName2() {
	this.module = new Module("test");
	assertEquals("Error", this.module.getName());
    }

    @Test
    public void testIncorrectCase() {
	this.module = new Module("com1026");
	assertEquals("Error", this.module.getName());
    }

    @Test
    public void testInvalidName() {
	this.module = new Module("co1027");
	assertEquals("Error", this.module.getName());
    }

    @Test
    public void testModuleConstruction() {
	this.module = new Module("COM1027");
	assertEquals("COM1027", this.module.getName());
    }

    @Test
    public void testModuleConstruction2() {
	this.module = new Module("COM1025");
	assertEquals("COM1025", this.module.getName());
    }

    @Test
    public void testModuleConstructionManagement() {
	this.module = new Module("MAN1032");
	assertEquals("Error", this.module.getName());
    }
}
