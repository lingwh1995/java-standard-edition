package org.bluebridge.reflect.demo.junit;

public class MockJunitTester {
    @Before
    public void before(){
        System.out.println("before方法执行了...");
    }

    @Test
    public void test(){
        System.out.println("test方法执行了...");
    }

    @After
    public void after(){
        System.out.println("after方法执行了...");
    }
}
