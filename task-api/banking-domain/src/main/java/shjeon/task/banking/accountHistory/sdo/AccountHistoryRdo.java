package shjeon.task.banking.accountHistory.sdo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.accountHistory.domain.AccountHistory;
import shjeon.task.banking.accountHistory.domain.enumtype.Division;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountHistoryRdo {
    private String accountId;

    private Division division;

    private long amount;

    private String createdAt;

    public AccountHistoryRdo(AccountHistory accountHistory) {
        this.accountId = accountHistory.getAccountId();
        this.division = accountHistory.getDivision();
        this.amount = accountHistory.getAmount();
        this.createdAt = accountHistory.getCreatedAt();
    }
}
