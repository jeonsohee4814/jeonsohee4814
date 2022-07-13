package shjeon.task.banking.balance.service.flow;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shjeon.task.banking.balance.sdo.BalanceRdoListRdo;
import shjeon.task.banking.balance.service.crud.BalanceService;

@Service
@RequiredArgsConstructor
public class BalanceFlowService {
    private final BalanceService balanceService;

    public BalanceRdoListRdo findBalanceByAccountId(List<String> accountIds, int offset, int limit) {
        return new BalanceRdoListRdo(balanceService.findBalanceByAccountId(accountIds, offset, limit), offset + limit);
    }
}
