package org.hqf.tutorials.java.dp.strategy.constants;

import org.hqf.tutorials.java.dp.strategy.func.Strategy;
import org.hqf.tutorials.java.dp.strategy.func.impl.StrategyA;
import org.hqf.tutorials.java.dp.strategy.func.impl.StrategyB;

public enum StrategyType {
    STRATEGY_A("strategyA", StrategyA.class),
    STRATEGY_B("strategyB", StrategyB.class);

    private final String beanName;
    private final Class<? extends Strategy> strategyClass;

    StrategyType(String beanName, Class<? extends Strategy> strategyClass) {
        this.beanName = beanName;
        this.strategyClass = strategyClass;
    }

    public String getBeanName() {
        return beanName;
    }

    public Class<? extends Strategy> getStrategyClass() {
        return strategyClass;
    }
}