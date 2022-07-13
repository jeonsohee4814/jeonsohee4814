package shjeon.task.banking.account.service.flow;

import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shjeon.task.banking.account.domain.Account;
import shjeon.task.banking.account.sdo.AccountCdo;
import shjeon.task.banking.account.sdo.AccountIdRdo;
import shjeon.task.banking.account.sdo.AccountQuery;
import shjeon.task.banking.account.sdo.AccountRdoListRdo;
import shjeon.task.banking.account.service.crud.AccountService;
import shjeon.task.banking.user.service.crud.UserService;

@Service
@RequiredArgsConstructor
public class AccountFlowService {
    private final AccountService accountService;

    private final UserService userService;

    public AccountRdoListRdo findAll(AccountQuery query, int offset, int limit) {
        return new AccountRdoListRdo(accountService.findAll(query, offset, limit), offset + limit);
    }

    public AccountIdRdo register(AccountCdo accountCdo) {
        if (!userService.exists(accountCdo.getUserId())) {
            throw new NoSuchElementException("User id not found:" + accountCdo.getUserId());
        }
        Account account = accountService.register(accountCdo.toDomain());
        return new AccountIdRdo(account.getAccountId());
    }
}
