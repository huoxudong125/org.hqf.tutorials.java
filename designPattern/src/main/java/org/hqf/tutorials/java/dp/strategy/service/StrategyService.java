package org.hqf.tutorials.java.dp.strategy.service;

import org.hqf.tutorials.java.dp.strategy.constants.StrategyType;
import org.hqf.tutorials.java.dp.strategy.func.Strategy;
import org.hqf.tutorials.java.dp.strategy.func.StrategyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategyService {

    private final StrategyManager strategyManager;

    @Autowired
    public StrategyService(StrategyManager strategyManager) {
        this.strategyManager = strategyManager;
    }

    public void executeStrategy(StrategyType type) {
        Strategy strategy = strategyManager.getStrategy(type);
        if (strategy != null) {
            strategy.execute();
        } else {
            System.out.println("Strategy not found!");
        }
    }
}