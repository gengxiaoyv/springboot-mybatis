package com.example.springbootmybatisdemo;

public class Test {

    public static void main(String[] a)throws InterruptedException{

//        Thread th = Thread.currentThread();
//
//        ceshi();
//        System.out.println("当前执行线程的名字："+th.getName());


        final Test test = new Test();

        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread = new Thread(){
            public void run(){
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };

        thread.start();
        thread.join();
        System.out.println(test.getLong());
        System.out.println(test.getString());

    }

    public static String ceshi(){
        Thread th2 = Thread.currentThread();
        System.out.println("测试ceshi线程的名字："+th2.getName());
        return "测试线程";
    }


    ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
    ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();


    public void set(){
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());
    }

    public Long getLong(){
        return longThreadLocal.get();
    }

    public String getString(){
        return stringThreadLocal.get();
    }






}
