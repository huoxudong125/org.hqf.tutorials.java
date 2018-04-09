package org.hqf.tutorials.java;


import org.hqf.tutorials.java.logger.annotation.Log;
import org.springframework.stereotype.Service;

@Service
@Log("测试服务")
public class TestService {

    @Log("回声方法")
    public Apply echo(Apply apply) throws InterruptedException {
        Thread.sleep(500);
        return apply;
    }
}




