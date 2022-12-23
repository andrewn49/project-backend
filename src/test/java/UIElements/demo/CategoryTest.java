package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    public void testEmptyConstructor(){
        Category cat = new Category();
        Assertions.assertNotNull(cat);
    }

    @Test
    public void testConstructor(){
        Category cat = new Category("testname");
        Assertions.assertEquals("testname", cat.getCatname(), "Category name is not set correctly");
        cat.setCategoryid(2);
        Assertions.assertEquals(2, cat.getCategoryid(), "Category id not set correctly");
        cat.setCatname("new");
        Assertions.assertEquals("new", cat.getCatname(), "Category name is not set correctly");
    }
}
