package shjeon.task.banking.account.sdo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.account.domain.Account;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountRdo {
    private String accountId;

    private String userId;

    public AccountRdo(Account account) {
        this.accountId = account.getAccountId();
        this.userId = account.getUserId();
    }
}
