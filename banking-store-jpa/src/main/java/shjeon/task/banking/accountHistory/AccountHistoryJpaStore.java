package shjeon.task.banking.accountHistory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shjeon.task.banking.accountHistory.domain.AccountHistory;
import shjeon.task.banking.accountHistory.jpo.AccountHistoryJpo;
import shjeon.task.banking.accountHistory.repository.AccountHistoryRepository;
import shjeon.task.banking.accountHistory.store.AccountHistoryStore;
import shjeon.task.banking.balance.sdo.Balance;

@Repository
@RequiredArgsConstructor
public class AccountHistoryJpaStore implements AccountHistoryStore {
    private final AccountHistoryRepository accountHistoryRepository;

    public List<AccountHistory> findAll() {
        return StreamSupport.stream(this.accountHistoryRepository.findAll().spliterator(), false)
            .map(AccountHistoryJpo::toDomain)
            .collect(Collectors.toList());
    }

    public void save(AccountHistory accountHistory) {
        accountHistoryRepository.save(new AccountHistoryJpo(accountHistory));
    }

    @Override
    public List<Balance> findBalanceByAccountId(List<String> accountIds) {
        return this.accountHistoryRepository.findBalanceByAccountId(accountIds);
    }
}
