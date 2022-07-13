package shjeon.task.banking.accountHistory.sdo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.accountHistory.domain.AccountHistory;
import shjeon.task.banking.accountHistory.domain.enumtype.Division;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountHistoryCdo {
    @NotBlank
    @Size(min = 1, max = 36)
    private String accountId;

    private Division division;

    @Min(0)
    private long amount;

    private String createdAt;

    public AccountHistory toDomain() {
        return new AccountHistory(accountId, division, amount, createdAt);
    }
}
