package shjeon.task.banking.accountHistory.service.flow;

import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shjeon.task.banking.account.service.crud.AccountService;
import shjeon.task.banking.accountHistory.domain.AccountHistory;
import shjeon.task.banking.accountHistory.sdo.AccountHistoryCdo;
import shjeon.task.banking.accountHistory.sdo.AccountHistoryIdRdo;
import shjeon.task.banking.accountHistory.sdo.AccountHistoryQuery;
import shjeon.task.banking.accountHistory.sdo.AccountHistoryRdoListRdo;
import shjeon.task.banking.accountHistory.service.crud.AccountHistoryService;

@Service
@RequiredArgsConstructor
public class AccountHistoryFlowService {
    private final AccountHistoryService accountHistoryService;

    private final AccountService accountService;

    public AccountHistoryRdoListRdo findAll(AccountHistoryQuery query, int offset, int limit) {
        return new AccountHistoryRdoListRdo(accountHistoryService.findAll(query, offset, limit), offset + limit);
    }

    public AccountHistoryIdRdo register(AccountHistoryCdo accountHistoryCdo) {
        AccountHistory accountHistory;

        if (!accountService.exists(accountHistoryCdo.getAccountId())) {
            throw new NoSuchElementException("Account id not found: " + accountHistoryCdo.getAccountId());
        }

        accountHistory = accountHistoryService.register(accountHistoryCdo.toDomain());

        return new AccountHistoryIdRdo(accountHistory.getAccountId());
    }
}
