package com.example.reporting.service.scheduler;

import com.example.reporting.service.service.OrderReportingService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderScheduler {
    private final OrderReportingService orderReportingService;

    @Scheduled(cron = "0 00 8 * * *")
    public void doRun(){
        orderReportingService.insertRecordsIntoOrderTable(1000);
    }


}
