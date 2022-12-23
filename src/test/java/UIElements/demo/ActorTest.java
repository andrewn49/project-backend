package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorTest {

    @Test
    public void testEmptyConstructor(){
        Actor actor = new Actor();
        Assertions.assertNotNull(actor);
    }

    @Test
    public void testConstructor(){
        Actor actor = new Actor("firstname", "surname");
        Assertions.assertEquals("firstname", actor.getFirstname(), "Actor first name is not set correctly");
        Assertions.assertEquals("surname", actor.getLastname(), "Actor surname is not set correctly");
        actor.setActorid(2);
        Assertions.assertEquals(2, actor.getActorid(), "Actor id not set correctly");
        actor.setFirstname("new");
        Assertions.assertEquals("new", actor.getFirstname(), "Actor first name is not set correctly");
        actor.setLastname("new");
        Assertions.assertEquals("new", actor.getLastname(), "Actor surname is not set correctly");
    }
}
