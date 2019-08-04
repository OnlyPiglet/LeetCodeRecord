package com.multithreads.FooBar;


class FooBar {

    private int n;

    private volatile Boolean flag = true;


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {


            synchronized (this){

                if(flag){

                    //拿到锁 单次bar执行完毕 开启新一轮foo 并设置 foo已执行 单次为执行完毕
                    printFoo.run();
                    flag = false;
                    this.notifyAll();
                }else{
                    //拿到锁但是单次bar 还没有执行，本次需要等待 同时激活bar线程 foo执行完毕 在执行
                    this.wait();
                    i = i - 1;
                }



            }


        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (this){

                //拿到锁 单次foo 执行完毕 执行bar 并设置 foo_end 为 false once_end 为 true
                if(!flag){
                    printBar.run();
                    flag = true;
                    this.notifyAll();
                }else{
                    this.wait();
                    i = i -1;
                }


            }


        }
    }
}