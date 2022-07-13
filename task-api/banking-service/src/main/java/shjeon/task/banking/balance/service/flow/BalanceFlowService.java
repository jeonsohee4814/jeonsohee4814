package shjeon.task.banking.balance.service.flow;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shjeon.task.banking.balance.sdo.AccountBalanceRdoListRdo;
import shjeon.task.banking.balance.sdo.BalanceRdo;
import shjeon.task.banking.balance.service.crud.BalanceService;

@Service
@RequiredArgsConstructor
public class BalanceFlowService {
    private final BalanceService balanceService;

    public AccountBalanceRdoListRdo findBalanceByAccountId(List<String> accountIds, int offset, int limit) {
        return new AccountBalanceRdoListRdo(balanceService.findBalanceByAccountId(accountIds, offset, limit), offset + limit);
    }

    public BalanceRdo findTotalBalancePerYear(String year) {
        return balanceService.findTotalBalancePerYear(year);
    }
}
