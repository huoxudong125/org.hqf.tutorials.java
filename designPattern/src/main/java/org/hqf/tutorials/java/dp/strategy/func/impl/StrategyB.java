package org.hqf.tutorials.java.dp.strategy.func.impl;

import org.hqf.tutorials.java.dp.strategy.annotations.StrategyAnnotation;
import org.hqf.tutorials.java.dp.strategy.constants.StrategyType;
import org.hqf.tutorials.java.dp.strategy.func.Strategy;
import org.springframework.stereotype.Component;

@Component
@StrategyAnnotation(type = StrategyType.STRATEGY_B)
public class StrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing Strategy B");
    }
}
