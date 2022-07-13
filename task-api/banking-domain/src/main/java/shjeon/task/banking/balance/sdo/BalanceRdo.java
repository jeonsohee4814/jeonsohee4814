package shjeon.task.banking.balance.sdo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BalanceRdo {
    private String accountId;

    private long balance;

    public BalanceRdo(Balance balance) {
        this.accountId = balance.getAccountId();
        this.balance = balance.getTotalDeposit() - balance.getTotalWithdrawal();
    }
}
