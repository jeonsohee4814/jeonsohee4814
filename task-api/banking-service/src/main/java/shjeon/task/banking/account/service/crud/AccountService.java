package shjeon.task.banking.account.service.crud;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shjeon.task.banking.account.domain.Account;
import shjeon.task.banking.account.sdo.AccountQuery;
import shjeon.task.banking.account.sdo.AccountRdo;
import shjeon.task.banking.account.store.AccountStore;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountStore accountStore;

    public boolean exists(String accountId) {
        return accountStore.exists(accountId);
    }

    public List<AccountRdo> findAll(AccountQuery query, int offset, int limit) {
        return accountStore.findAll()
            .stream().filter(query::filter)
            .skip(offset)
            .limit(limit)
            .map(AccountRdo::new)
            .collect(Collectors.toList());
    }

    @Transactional
    public Account register(Account account) {
        accountStore.save(account);
        return account;
    }

}
