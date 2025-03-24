package com.demo.spring.afternoon.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.demo.spring.afternoon.jdbc1.Config.JdbcAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.simple.JdbcClient;

public class JdbcMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcAppConfig.class);

        // Template pattern
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        jdbcTemplate.query(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pst = con.prepareStatement("select * from book");
                return pst;
            }
        }, new RowCallbackHandler() {

            @Override
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println(rs.getString("isbn") + " " + rs.getString("name"));
            }
        });

        // JDBC Client pattern
        JdbcClient jdbcClient = ctx.getBean("jdbcClient", JdbcClient.class);
        List<Map<String, Object>> data = jdbcClient.sql("select * from book").query().listOfRows();
        for (Map map : data) {
            System.out.println(map);
        }
    }
}
