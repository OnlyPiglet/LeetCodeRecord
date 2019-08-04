package com.multithreads.FooBar;

public class Caller {


    public static void main(String[] args) {

        FooBar b = new FooBar(6);

        FooRunnable fb = new FooRunnable();

        BarRunnable br = new BarRunnable();

        new Thread(() -> { try { b.foo(fb); } catch (InterruptedException e) { e.printStackTrace(); } },"foo").start();
        new Thread(() -> { try { b.bar(br); } catch (InterruptedException e) { e.printStackTrace(); } },"bar").start();
    }








}
