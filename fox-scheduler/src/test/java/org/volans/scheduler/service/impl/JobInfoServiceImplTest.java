package org.volans.scheduler.service.impl;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.volans.scheduler.entity.JobInfo;
import org.volans.scheduler.service.JobInfoService;

/**
 * @author <a href="http://github.com/athc">j</a>
 * @date 2019-11-12
 * @since JDK1.8
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobInfoServiceImplTest {


    @Autowired
    private JobInfoService jobInfoService;

    @Test
    public void create() {
        jobInfoService.create(new JobInfo());
    }
}
