package com.multithreads.Foo;

public class Caller {

    public static void main(String[] args) {


        Foo f = new Foo();

        new Thread(()->{try{f.first(new Runnable() {
            @Override
            public void run() {
                System.out.println("first");
            }
        });}catch (Exception e){e.printStackTrace();}},"first").start();

        new Thread(()->{try{f.second(new Runnable() {
            @Override
            public void run() {
                System.out.println("second");
            }
        });}catch (Exception e){e.printStackTrace();}},"second").start();

        new Thread(()->{try{f.third(new Runnable() {
            @Override
            public void run() {
                System.out.println("third");
            }
        });}catch (Exception e){e.printStackTrace();}},"third").start();

    }

}
