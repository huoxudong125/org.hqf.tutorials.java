package org.hqf.tutorials.java.logger;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtMethod;
import javassist.bytecode.LocalVariableAttribute;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hqf.tutorials.java.logger.annotation.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by junbaor on 2017/5/12.
 */
@Aspect
@Order(100)
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String STRING_START = "\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n";
    private static final String STRING_END = "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n";

    @Pointcut("execution(* org.hqf.tutorials.java..*(..)) || execution(* org.hqf.tutorials.java..controller..*(..))")
    public void serviceLog() {
    }

    @Around("serviceLog()")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            Class<?> targetClass = method.getDeclaringClass();

            StringBuffer classAndMethod = new StringBuffer();

            Log classAnnotation = targetClass.getAnnotation(Log.class);
            Log methodAnnotation = method.getAnnotation(Log.class);

            if (classAnnotation != null) {
                if (classAnnotation.ignore()) {
                    return joinPoint.proceed();
                }
                classAndMethod.append(classAnnotation.value()).append("-");
            }

            if (methodAnnotation != null) {
                if (methodAnnotation.ignore()) {
                    return joinPoint.proceed();
                }
                classAndMethod.append(methodAnnotation.value());
            }

            String target = targetClass.getName() + "#" + method.getName();
            String params = JSONObject.toJSONStringWithDateFormat(joinPoint.getArgs(), dateFormat, SerializerFeature.WriteMapNullValue);

            log.info(STRING_START + "{} 开始调用--> {} 参数:{}", classAndMethod.toString(), target, params);

            long start = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long timeConsuming = System.currentTimeMillis() - start;

            log.info("\n{} 调用结束<-- {} 返回值:{} 耗时:{}ms" + STRING_END, classAndMethod.toString(), target, JSONObject.toJSONStringWithDateFormat(result, dateFormat, SerializerFeature.WriteMapNullValue), timeConsuming);
            return result;
        } catch (Throwable throwable) {
            log.error(throwable.getMessage(), throwable);
        }
        return null;
    }


    /**
     * 获取方法入参变量名
     *
     * @param clazz
     *            触发的类
     * @param methodName
     *            触发的方法名
     * @param include
     *            需要打印的变量名
     * @return
     * @throws Exception
     */
    private Map<String, Object> getMethodParamNames(Class clazz,
                                                    String methodName, String include) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(new ClassClassPath(clazz));
        CtMethod cm = pool.get(clazz.getName()).getDeclaredMethod(methodName);
        LocalVariableAttribute attr = (LocalVariableAttribute) cm
                .getMethodInfo().getCodeAttribute()
                .getAttribute(LocalVariableAttribute.tag);

        if (attr == null) {
            throw new Exception("attr is null");
        } else {
            Map<String, Object> paramNames = new HashMap<String, Object>();
            int paramNamesLen = cm.getParameterTypes().length;
            int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
            if (StringUtils.isEmpty(include)) {
                for (int i = 0; i < paramNamesLen; i++) {
                    paramNames.put(attr.variableName(i + pos), i);
                }
            } else { // 若include不为空
                for (int i = 0; i < paramNamesLen; i++) {
                    String paramName = attr.variableName(i + pos);
                    if (include.indexOf(paramName) > -1) {
                        paramNames.put(paramName, i);
                    }
                }
            }
            return paramNames;
        }
    }


}
