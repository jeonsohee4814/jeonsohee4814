package shjeon.task.banking.balance.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shjeon.task.banking.account.sdo.AccountCdo;
import shjeon.task.banking.account.sdo.AccountIdRdo;
import shjeon.task.banking.account.sdo.AccountQuery;
import shjeon.task.banking.account.sdo.AccountRdo;
import shjeon.task.banking.account.service.flow.AccountFlowService;
import shjeon.task.banking.balance.sdo.AccountBalanceRdoListRdo;
import shjeon.task.banking.balance.sdo.BalanceRdo;
import shjeon.task.banking.balance.service.flow.BalanceFlowService;

@RestController
@RequiredArgsConstructor
@RequestMapping("balances")
public class BalanceController {
    private final AccountFlowService accountFlowService;

    private final BalanceFlowService balanceFlowService;

    @PostMapping
    public AccountIdRdo register(@Valid @RequestBody AccountCdo accountCdo) {
        return accountFlowService.register(accountCdo);
    }

    @GetMapping
    public AccountBalanceRdoListRdo findAccountBalanceByUserId(
        @RequestParam(defaultValue = "0", required = false) int offset,
        @RequestParam(defaultValue = "30", required = false) int limit,
        @RequestParam String userId
    ) {
        List<String> accountIds = accountFlowService.findAll(
            new AccountQuery(Arrays.asList(userId)),
            offset,
            limit)
            .getList()
            .stream()
            .map(AccountRdo::getAccountId)
            .collect(Collectors.toList());
        return balanceFlowService.findBalanceByAccountId(accountIds, offset, limit);
    }

    @GetMapping("/totalBalancePerYear")
    public BalanceRdo findTotalBalancePerYear(
        @RequestParam String year
    ) {
        return balanceFlowService.findTotalBalancePerYear(year);
    }

}
