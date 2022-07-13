package shjeon.task.banking.balance.service.crud;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shjeon.task.banking.accountHistory.store.AccountHistoryStore;
import shjeon.task.banking.balance.sdo.BalanceRdo;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final AccountHistoryStore accountHistoryStore;

    public List<BalanceRdo> findBalanceByAccountId(List<String> accountIds, int offset, int limit) {
        return accountHistoryStore.findBalanceByAccountId(accountIds)
            .stream()
            .skip(offset)
            .limit(limit)
            .map(BalanceRdo::new)
            .collect(Collectors.toList());
    }

}
