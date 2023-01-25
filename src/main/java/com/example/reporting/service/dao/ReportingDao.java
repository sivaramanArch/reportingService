package com.example.reporting.service.dao;

import com.example.reporting.service.model.OrderDetail;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Qualifier("reportingDao")
public class ReportingDao extends JdbcDaoSupport {

    @Autowired
    public ReportingDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.setDataSource(dataSource);
        this.setJdbcTemplate(jdbcTemplate);
    }

    @PostConstruct
    public void checkConnection() {
        assert getJdbcTemplate() != null;
        var result = getJdbcTemplate().queryForObject("select 1 from dual", String.class);
        System.out.println("result = " + result);

    }

    public void createTables() {
        getJdbcTemplate().execute("create table orders ( id INT , order_item VARCHAR(200) , order_success CHAR);");

    }

    @SneakyThrows
    public void insertRecord(OrderDetail randomOrderPojo) {
        var ps = getDataSource().getConnection().prepareStatement("insert into orders values(?,?,?)");
        ps.setInt(1, randomOrderPojo.getOrderId());
        ps.setString(2, randomOrderPojo.getOrderName());
        ps.setString(3, randomOrderPojo.getOrderSuccess());

        var resultSet = ps.executeUpdate();
    }
}
