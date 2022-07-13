package shjeon.task.banking.account.jpo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.account.domain.Account;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountJpo {
    @Id
    @Column(length = 100)
    private String accountId;

    @Column(length = 80)
    private String userId;

    public AccountJpo(Account account) {
        this.accountId = account.getAccountId();
        this.userId = account.getUserId();
    }

    public Account toDomain() {
        return new Account(accountId, userId);
    }
}
