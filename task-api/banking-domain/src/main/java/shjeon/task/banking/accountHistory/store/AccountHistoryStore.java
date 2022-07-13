package shjeon.task.banking.accountHistory.store;

import java.util.List;

import shjeon.task.banking.accountHistory.domain.AccountHistory;
import shjeon.task.banking.balance.sdo.AccountBalance;
import shjeon.task.banking.balance.sdo.Balance;

public interface AccountHistoryStore {
    List<AccountHistory> findAll();

    void save(AccountHistory accountHistory);

    List<AccountBalance> findBalanceByAccountId(List<String> accountIds);

    Balance findTotalBalancePerYear(String year);
}
