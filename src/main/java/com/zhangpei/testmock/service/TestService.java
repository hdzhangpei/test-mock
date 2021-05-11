package com.zhangpei.testmock.service;

import com.zhangpei.testmock.rpc.TestRpcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangpei
 * @description: TODO
 * @company 中国区销售一部
 * @created 2021/5/11
 */
@Service
public class TestService {
    @Resource
    private TestRpcService testRpcService;

    public String test(String str) {
        System.out.println("TestService" + str);
        return testRpcService.test(str);
    }

}
