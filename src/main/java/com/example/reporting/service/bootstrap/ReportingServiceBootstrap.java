package com.example.reporting.service.bootstrap;

import com.example.reporting.service.dao.ReportingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("reportingDao")
public class ReportingServiceBootstrap {

    private final ReportingDao dao;

    @Autowired
    public ReportingServiceBootstrap(ReportingDao dao) {
        this.dao = dao;
        createTables();
    }

    private void createTables() {
        dao.createTables();
        System.out.println("Required tables are created");
    }


}
