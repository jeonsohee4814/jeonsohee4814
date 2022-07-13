package shjeon.task.banking.account.sdo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.account.domain.Account;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountCdo {
    @NotBlank
    @Size(min = 3, max = 20)
    private String userId;

    @NotBlank
    @Size(min = 3, max = 36)
    private String accountId;


    public Account toDomain() {
        return new Account(accountId, userId);
    }
}
