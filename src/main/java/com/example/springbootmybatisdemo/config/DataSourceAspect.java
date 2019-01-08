package com.example.springbootmybatisdemo.config;


import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 动态处理数据源，根据命名区分
 */

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {

    private static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("execution(* com.example.springbootmybatisdemo.mappers.*.*(..))")//切点
    public void aspect(){


    }

    @Before("aspect()")
    public void before(JoinPoint point){//在指定切点的方法之前执行
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        String args = StringUtils.join(point.getArgs(),",");
        logger.info("className:{},method:{},args:{}",className,methodName,args);

        try{
            for (DatabaseType type:DatabaseType.values()){
                List<String> values = DynamicDataSource.METHOD_TYPE_MAPA.get(type);
                for (String key:values){
                    if (methodName.startsWith(key)){
                        logger.info(">>{}方法使用的数据源为:{}<<",methodName,key);
                        DatabaseContextHolder.setDatabaseType(type);
                        DatabaseType types = DatabaseContextHolder.getDatabaseType();
                        logger.info(">>{}方法使用的数据源为:{}<<",methodName,types);

                    }
                }
            }
        }catch(Exception e){
            logger.error(e.getMessage(),e);
        }


    }




}
