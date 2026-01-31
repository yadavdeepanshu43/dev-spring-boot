package com.luv2code.demo.dao;

import com.luv2code.demo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount,boolean vipflag);

    boolean doWork();

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    public String getName();

    public void setName(String name);
}
