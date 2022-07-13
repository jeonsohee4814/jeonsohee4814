package shjeon.task.banking.account;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shjeon.task.banking.account.domain.Account;
import shjeon.task.banking.account.jpo.AccountJpo;
import shjeon.task.banking.account.repository.AccountRepository;
import shjeon.task.banking.account.store.AccountStore;

@Repository
@RequiredArgsConstructor
public class AccountJpaStore implements AccountStore {
    private final AccountRepository accountRepository;

    public boolean exists(String accountId) {
        return accountRepository.existsById(accountId);
    }

    public List<Account> findAll() {
        return StreamSupport.stream(this.accountRepository.findAll().spliterator(), false)
            .map(AccountJpo::toDomain)
            .collect(Collectors.toList());
    }

    public void save(Account account) {
        accountRepository.save(new AccountJpo(account));
    }
}
