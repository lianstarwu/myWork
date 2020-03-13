package com.libo.designpattern.agency.dynamic;

public class Customer implements Person {
    //@Override
    //public void findLove(String arr, String arr1) {
    //    System.out.println("被代理的方法执行" + arr);
    //}
    //
    //@Override
    //public void findLove1(String arr) {
    //    System.out.println("被代理的方法执行z" + arr);
    //}
    @Override
    public void findLove() {
        System.out.println("被代理的方法执行-----" );
    }

    @Override
    public void findLove1() {
        System.out.println("被代理的方法执行z++++" );
    }
}
