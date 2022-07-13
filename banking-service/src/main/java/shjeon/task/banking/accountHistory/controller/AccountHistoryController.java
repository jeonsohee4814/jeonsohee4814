package shjeon.task.banking.accountHistory.controller;

import java.util.ArrayList;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shjeon.task.banking.accountHistory.sdo.AccountHistoryCdo;
import shjeon.task.banking.accountHistory.sdo.AccountHistoryIdRdo;
import shjeon.task.banking.accountHistory.sdo.AccountHistoryQuery;
import shjeon.task.banking.accountHistory.sdo.AccountHistoryRdoListRdo;
import shjeon.task.banking.accountHistory.service.flow.AccountHistoryFlowService;

@RestController
@RequiredArgsConstructor
@RequestMapping("accountHistories")
public class AccountHistoryController {
    private final AccountHistoryFlowService accountHistoryFlowService;

    @PostMapping
    public AccountHistoryIdRdo register(@Valid @RequestBody AccountHistoryCdo accountHistoryCdo) {
        return accountHistoryFlowService.register(accountHistoryCdo);
    }

    @GetMapping
    public AccountHistoryRdoListRdo findAll(
        @RequestParam(defaultValue = "0", required = false) int offset,
        @RequestParam(defaultValue = "30", required = false) int limit,
        @RequestParam(defaultValue = "", required = false) ArrayList<String> accountIds
    ) {
        return accountHistoryFlowService.findAll(new AccountHistoryQuery(accountIds), offset, limit);
    }

}
