package com.luv2code.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addAccount() {

        System.out.println(getClass() + " DOING MY DB WORK: ADDING AN MEMBERSHIP TO AN ACCOUNT");
    return true;
    }

    @Override
    public void goToSleep() {

        System.out.println(getClass() + " Going for a sleep");

    }
}
