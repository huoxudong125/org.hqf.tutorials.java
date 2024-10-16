package org.hqf.tutorials.java.dp.strategy;

import org.hqf.tutorials.java.dp.strategy.constants.StrategyType;
import org.hqf.tutorials.java.dp.strategy.service.StrategyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@SpringBootApplication
public class StrategyApplication implements CommandLineRunner {

    @Resource
    private StrategyService strategyService;

    public static void main(String[] args) {
        SpringApplication.run(StrategyApplication.class, args);
    }

    @Override
    public void run(String... args) {
        strategyService.executeStrategy(StrategyType.STRATEGY_A);
        strategyService.executeStrategy(StrategyType.STRATEGY_B);
    }
}
