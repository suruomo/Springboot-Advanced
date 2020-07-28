package com.suruomo.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

/**
 * @author suruomo
 * @date 2020/7/28 9:22
 * @description:
 */
@Slf4j
@Component
public class TestComponent {
    /**
     * 日志对象
     */
//    private static final Logger lOG = LoggerFactory.getLogger(TestComponent.class);

    public static int STEP_COUNT = 10;

    public void processStep() {
        Instant start = Instant.now();
        log.info("*** TestComponent started ***");
        for (int i = 0; i < STEP_COUNT; i++) {

            log.info("  Process step {} started.", i);
            try {
                Thread.sleep(10);
                log.debug("  Process step {} detail debug message.", i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("  Process step {} completed.", i);
        }
        Instant end = Instant.now();
        log.warn("*** TestComponent completed with {} ***" + Duration.between(start, end));

    }
}
