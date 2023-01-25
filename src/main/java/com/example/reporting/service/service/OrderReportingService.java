package com.example.reporting.service.service;

import com.example.reporting.service.dao.ReportingDao;
import com.example.reporting.service.model.OrderDetail;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class OrderReportingService {

    private final ReportingDao reportingDao;
    private final Faker faker = new Faker();

    public void insertRecordsIntoOrderTable(int recordCount) {
        for (int i = 0; i < recordCount; i++) {
            reportingDao.insertRecord(getRandomOrderPojo());
        }
        System.out.println("records inserted ...");
    }

    private OrderDetail getRandomOrderPojo() {
        var orderItem = faker.appliance().equipment();
        var orderStatus = faker.bool().bool() ? "Y" : "N";
        return OrderDetail.builder().orderId(ThreadLocalRandom.current().nextInt(1000)).orderName(orderItem.toString()).orderSuccess(orderStatus).build();
    }
}
