package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    public void testEmptyConstructor(){
        Customer cust = new Customer();
        Assertions.assertNotNull(cust);
    }

    @Test
    public void testSettersAndGetters(){
        Customer cust = new Customer();
        cust.setCustomer_id(2);
        cust.setFirst_name("john");
        cust.setLast_name("smith");
        Assertions.assertEquals(2, cust.getCustomer_id(), "Customer Id is not set correctly");
        Assertions.assertEquals("john", cust.getFirst_name(), "Customer first name is not set correctly");
        Assertions.assertEquals("smith", cust.getLast_name(), "Customer last name is not set correctly");
    }
}
