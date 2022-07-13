package shjeon.task.banking.account.domain;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Account {
    private String accountId;

    private String userId;

    public Account(String userId) {
        this.userId = userId;
        this.accountId = UUID.randomUUID().toString();
    }

}
