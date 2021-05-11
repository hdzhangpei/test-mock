package com.zhangpei.testmock.rpc;

import com.zhangpei.testmock.util.TestUtils;
import org.springframework.stereotype.Service;

/**
 * @author zhangpei
 * @description: TODO
 * @company 中国区销售一部
 * @created 2021/5/11
 */
@Service
public class TestRpcService {
    public String test(String str){
        System.out.println("TestRpcService" + str);
        return TestUtils.test();
    }
}
