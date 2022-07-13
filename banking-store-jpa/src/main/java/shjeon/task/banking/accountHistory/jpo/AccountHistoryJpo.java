package shjeon.task.banking.accountHistory.jpo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.accountHistory.domain.AccountHistory;
import shjeon.task.banking.accountHistory.domain.enumtype.Division;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountHistoryJpo {
    @Id
    @Column(length = 100)
    private String accountHistoryId;

    @Column(length = 100)
    private String accountId;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 10)
    private Division division;

    private long amount;

    private String createdAt;


    public AccountHistoryJpo(AccountHistory accountHistory) {
        this.accountHistoryId = accountHistory.getAccountHistoryId();
        this.accountId = accountHistory.getAccountId();
        this.division = accountHistory.getDivision();
        this.amount = accountHistory.getAmount();
        this.createdAt = accountHistory.getCreatedAt();
    }

    public AccountHistory toDomain() {
        return new AccountHistory(accountHistoryId, accountId, division, amount, createdAt);
    }
}
