package shjeon.task.banking.balance.sdo;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AccountBalanceRdoListRdo {
    private List<AccountBalanceRdo> list;

    private int next;
}
