package com.example.springbootmybatisdemo.config;

/*
列出数据源类型
 */
public enum DatabaseType {

    master("writer"),slave("read");

    DatabaseType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DatabaseType{" +
                "name='" + name + '\'' +
                '}';
    }
}
