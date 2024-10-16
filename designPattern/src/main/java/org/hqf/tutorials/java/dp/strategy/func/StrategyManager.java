package org.hqf.tutorials.java.dp.strategy.func;

import org.hqf.tutorials.java.dp.strategy.annotations.StrategyAnnotation;
import org.hqf.tutorials.java.dp.strategy.constants.StrategyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class StrategyManager {

    private final Map<StrategyType, Strategy> strategyMap = new HashMap<>();
    private final ApplicationContext applicationContext;

    @Autowired
    public StrategyManager(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(StrategyAnnotation.class);
        for (Object bean : beans.values()) {
            StrategyAnnotation annotation = bean.getClass().getAnnotation(StrategyAnnotation.class);
            strategyMap.put(annotation.type(), (Strategy) bean);
        }
    }

    public Strategy getStrategy(StrategyType type) {
        return strategyMap.get(type);
    }
}