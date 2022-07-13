package shjeon.task.banking.balance.sdo;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BalanceRdoListRdo {
    private List<BalanceRdo> list;

    private int next;
}
