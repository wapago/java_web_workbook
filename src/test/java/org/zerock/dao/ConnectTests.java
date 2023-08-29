package org.zerock.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

// jdbcTest 프로그램
public class ConnectTests {

    // @Test를 적용하는 메소드는 반드시 public으로 선언, 파라미터나 리턴타입이 없어야 함
    @Test
    public void test1() {
        int v1 = 10;
        int v2 = 10;

        Assertions.assertEquals(v1, v2);
    }

    @Test
    public void testConnection() throws Exception {
        // JDBC드라이버 클래스를 메모리상에 로딩하는 역할
        Class.forName("org.mariadb.jdbc.Driver");

        // java.sql 패키지의 Connection 인터페이스 타입의 변수.
        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "webuser"
        );

        Assertions.assertNotNull(connection);

        // 데이터베이스와 연결을 종료함
        connection.close();
    }

    @Test
    public void testHikariCP() throws Exception {

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();

        System.out.println(connection);

        connection.close();
    }
}
