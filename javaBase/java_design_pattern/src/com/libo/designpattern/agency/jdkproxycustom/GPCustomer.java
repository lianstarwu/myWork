package com.libo.designpattern.agency.proxycustom;

public class GPCustomer implements GPPerson {
    @Override
    public void findLove() {
        System.out.println("findLove");
    }

    @Override
    public void study() {
        System.out.println("study");
    }

    @Override
    public String study1(String str) {
        System.out.println("study1" + str);
        return str;
    }

    //@Override
    //public int study2(int i) {
    //    System.out.println("study2" + i);
    //    return i;
    //}


}
