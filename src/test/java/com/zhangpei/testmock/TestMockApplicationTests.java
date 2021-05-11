package com.zhangpei.testmock;

import com.zhangpei.testmock.provider.TestProvider;
import com.zhangpei.testmock.rpc.TestRpcService;
import com.zhangpei.testmock.service.TestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestMockApplication.class)
public class TestMockApplicationTests {
    @Autowired
    private TestProvider testProvider;

    @Autowired
    private TestService testService;

    private TestRpcService testRpcService;

    @Before
    public void setup() {
        testRpcService = Mockito.mock(TestRpcService.class);

        ReflectionTestUtils.setField(testService, "testRpcService", testRpcService);
    }

    /**
     * mock A -> B -> C
     */
    @Test
    public void test() {

        when(testRpcService.test(any(String.class))).thenReturn("ddd123");

        System.out.println(testProvider.test("123"));
    }

}
