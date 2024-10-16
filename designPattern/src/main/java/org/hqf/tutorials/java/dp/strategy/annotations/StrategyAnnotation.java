package org.hqf.tutorials.java.dp.strategy.annotations;

import org.hqf.tutorials.java.dp.strategy.constants.StrategyType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategyAnnotation {
    StrategyType type();
}
