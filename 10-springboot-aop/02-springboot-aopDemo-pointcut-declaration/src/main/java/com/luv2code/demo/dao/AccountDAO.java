package com.luv2code.demo.dao;

import com.luv2code.demo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccount();

    List<Account> findAccount(boolean tripWire);

    void addAccount(Account theAccount,boolean vipflag);

    boolean doWork();

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    public String getName();

    public void setName(String name);


}
