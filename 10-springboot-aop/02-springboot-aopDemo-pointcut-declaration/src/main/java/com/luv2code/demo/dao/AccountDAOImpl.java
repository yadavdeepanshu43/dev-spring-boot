package com.luv2code.demo.dao;

import com.luv2code.demo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;

    public String getServiceCode() {

        System.out.println("getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    private String serviceCode;


    @Override
    public List<Account> findAccount() {

        List<Account> myAccounts = new ArrayList<>();

        //create sample accounts
        Account temp1= new Account("Madhu","Platinum");
        Account temp2= new Account("John","Silver");
        Account temp3= new Account("Luca","Gold");

        //add them to array list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + " DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {

        System.out.println(" doWork()");
        return false;
    }
}
