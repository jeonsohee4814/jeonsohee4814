package shjeon.task.banking.sample;

import java.io.InputStream;
import java.io.InputStreamReader;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import shjeon.task.banking.accountHistory.domain.enumtype.Division;
import shjeon.task.banking.accountHistory.sdo.AccountHistoryCdo;
import shjeon.task.banking.accountHistory.service.flow.AccountHistoryFlowService;

@Component
@Order(3)
@RequiredArgsConstructor
public class AccountHistorySampleLoader implements CommandLineRunner {

    @Autowired
    ResourceLoader resourceLoader;

    private final AccountHistoryFlowService accountHistoryFlowService;

    private final int COLUMN_COUNT = 4;

    @Override
    public void run(String[] args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:csv/accountHistory.csv");
        if (resource.exists()) {
            InputStream inputStream = resource.getInputStream();
            String row[] = FileCopyUtils.copyToString(new InputStreamReader(inputStream)).split("\n");

            for(int i=1; i<row.length; i++) {
                String accountHistoryInfo[] = row[i].split(",");
                try {
                    if (accountHistoryInfo.length >= COLUMN_COUNT) {
                        accountHistoryFlowService.register(
                            new AccountHistoryCdo(
                                accountHistoryInfo[0].trim(),
                                Division.getDivision(accountHistoryInfo[1].trim()),
                                Long.parseLong(accountHistoryInfo[2].trim()),
                                accountHistoryInfo[3].trim()
                            )
                        );
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }
}
