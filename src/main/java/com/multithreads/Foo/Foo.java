package com.multithreads.Foo;

class Foo {

    private volatile Integer flag = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while(flag != 3){
            if(flag == 0){
                try{
                    printFirst.run();
                }finally{
                    flag = 1;
                }
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(flag != 3){
            if(flag == 1){
                try{
                    printSecond.run();
                }finally{
                    flag = 2;
                }
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(flag != 3){
            if(flag == 2){
                try{
                    printThird.run();
                }finally{
                    flag = 3;
                }
            }
        }

    }
}