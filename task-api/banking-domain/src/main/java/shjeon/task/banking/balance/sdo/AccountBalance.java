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
public class AccountBalance {
    private String accountId;

    private long totalDeposit;

    private long totalWithdrawal;

}
