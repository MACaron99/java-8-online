package org.example.service.impl;

import org.example.dao.AccountDao;
import org.example.dao.impl.AccountDaoImpl;
import org.example.entity.Account;
import org.example.service.AccountService;

import java.util.Collection;

public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void create(Account account) {
        accountDao.create(account);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public Account findById(Long id) {
        return accountDao.findById(id);
    }

    @Override
    public Collection<Account> findAll() {
        return accountDao.findAll();
    }
}
