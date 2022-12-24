package day05_junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {

    @Before
    public void setUp(){
        System.out.println("Her test methodundan once calısır.");
    }

    @After
    public void tearDown(){
        System.out.println("Her test methodundan sonra calısır.");
    }

    @Test
    public void test01(){
        System.out.println("First test");
    }
    @Test
    public void test02(){
        System.out.println("Second test");
    }


}
