package edu.mum.cs544.bank.dao;

import java.util.*;

import edu.mum.cs544.bank.EntityManagerHelper;
import edu.mum.cs544.bank.domain.Account;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class JPAAccountDAO implements IAccountDAO {

    public void saveAccount(Account account) {
         System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
        EntityManager em = EntityManagerHelper.getCurrent();
        em.persist(account);
    }

    public void updateAccount(Account account) {
         System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
        Account accountexist = loadAccount(account.getAccountnumber());
        if (accountexist != null) {
            EntityManager em = EntityManagerHelper.getCurrent();
            em.merge(account);
        }

    }

    public Account loadAccount(long accountnumber) {
         System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
        EntityManager em = EntityManagerHelper.getCurrent();
        return em.find(Account.class,accountnumber);
    }

    public Collection<Account> getAccounts() {
        EntityManager em = EntityManagerHelper.getCurrent();
        return em.createQuery("Select distinct a from Account a JOIN FETCH a.customer c JOIN FETCH a.entryList entry").getResultList();
    }

}
