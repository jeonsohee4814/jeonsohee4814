package shjeon.task.banking.accountHistory.sdo;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AccountHistoryRdoListRdo {
    private List<AccountHistoryRdo> list;

    private int next;
}
