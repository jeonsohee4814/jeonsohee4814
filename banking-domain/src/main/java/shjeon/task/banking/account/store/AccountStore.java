package shjeon.task.banking.account.store;

import java.util.List;

import shjeon.task.banking.account.domain.Account;

public interface AccountStore {
    boolean exists(String accountId);

    List<Account> findAll();

    void save(Account account);
}
