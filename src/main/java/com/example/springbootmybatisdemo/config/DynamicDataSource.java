package com.example.springbootmybatisdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

import java.util.*;

public class DynamicDataSource extends AbstractRoutingDataSource {

    static final Map<DatabaseType, List<String>>   METHOD_TYPE_MAPA = new HashMap<>();

    static  Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    @Nullable
    protected Object determineCurrentLookupKey() {
        DatabaseType type = DatabaseContextHolder.getDatabaseType();
        logger.info("==================dataSource=========="+type);

        return type;
    }

    void setMethodType(DatabaseType type,String content){
        System.out.println("启动项目的时候就set了吗===================================================================");

        System.out.println(content);
        List<String> list = Arrays.asList(content.split(","));
        METHOD_TYPE_MAPA.put(type,list);
    }
}
