package shjeon.task.banking.accountHistory.domain;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.accountHistory.domain.enumtype.Division;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class AccountHistory {
    private String accountHistoryId;

    private String accountId;

    private Division division;

    private long amount;

    private String createdAt;

    public AccountHistory(String accountId, Division division, long amount, String createdAt) {
        this.accountHistoryId = UUID.randomUUID().toString();
        this.accountId = accountId;
        this.division = division;
        this.amount = amount;
        this.createdAt = createdAt;
    }

}
