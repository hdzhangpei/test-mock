package com.zhangpei.testmock;

import com.zhangpei.testmock.provider.TestProvider;
import com.zhangpei.testmock.util.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)//使用PowerMockRunner运行时
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)//委派给SpringJUnit4ClassRunner
@SpringBootTest(classes = TestMockApplication.class)
@PrepareForTest({TestUtils.class})
public class TestMockApplicationTests1 {
    @Autowired
    private TestProvider testProvider;

    @Before
    public void setup() {
        //mock静态类
        PowerMockito.mockStatic(TestUtils.class);
    }

    /**
     * mock 静态类
     */
    @Test
    public void test() {

        when(TestUtils.test()).thenReturn("ddd123");

        System.out.println(testProvider.test("123"));
    }

}
