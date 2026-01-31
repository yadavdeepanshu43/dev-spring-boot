package com.luv2code.demo.dao;

import com.luv2code.demo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{



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
