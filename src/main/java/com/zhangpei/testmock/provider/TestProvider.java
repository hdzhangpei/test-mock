package com.zhangpei.testmock.provider;

import com.zhangpei.testmock.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @description: TODO
 * @company 中国区销售一部
 * @created 2021/5/11
 */
@Service
public class TestProvider {
    @Resource
    private TestService testService;

    public String test(String str) {
        System.out.println("TestProvider" + str);
        return testService.test(str);
    }
}
