package shjeon.task.banking.accountHistory.service.crud;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shjeon.task.banking.accountHistory.domain.AccountHistory;
import shjeon.task.banking.accountHistory.sdo.AccountHistoryQuery;
import shjeon.task.banking.accountHistory.sdo.AccountHistoryRdo;
import shjeon.task.banking.accountHistory.store.AccountHistoryStore;

@Service
@RequiredArgsConstructor
public class AccountHistoryService {

    private final AccountHistoryStore accountHistoryStore;

    public List<AccountHistoryRdo> findAll(AccountHistoryQuery query, int offset, int limit) {
        return accountHistoryStore.findAll()
            .stream().filter(query::filter)
            .skip(offset)
            .limit(limit)
            .map(AccountHistoryRdo::new)
            .collect(Collectors.toList());
    }

    @Transactional
    public AccountHistory register(AccountHistory accountHistory) {
        accountHistoryStore.save(accountHistory);
        return accountHistory;
    }

}
