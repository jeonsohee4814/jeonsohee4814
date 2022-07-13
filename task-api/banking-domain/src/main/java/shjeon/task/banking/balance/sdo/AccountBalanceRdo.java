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
public class AccountBalanceRdo {
    private String accountId;

    private long balance;

    public AccountBalanceRdo(AccountBalance accountBalance) {
        this.accountId = accountBalance.getAccountId();
        this.balance = accountBalance.getTotalDeposit() - accountBalance.getTotalWithdrawal();
    }
}
