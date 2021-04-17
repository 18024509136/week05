package com.geek.spring.jdbc.test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class JdbcTest {

    private static String url = "jdbc:mysql://129.204.220.248:3306/test";

    private static String username = "ceshi";

    private static String password = "jianta@2020cs";

    private static DataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(10);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setConnectionTimeout(120000L);
        config.setIdleTimeout(60000L);
        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 普通方式获取连接
            // Connection connection = DriverManager.getConnection(url, username, password);

            // hikari连接池方式获取连接
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new BusinessException(e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException(e);
        }
    }

    /**
     * 新增记录
     *
     * @param person person实体
     * @param sql    待预编译语句
     * @return
     */
    public static int insert(Person person, String sql) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.setDate(3, new Date(person.getBirth().getTime()));
            int result = ps.executeUpdate();
            connection.commit();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException(e);
        } finally {
            closeResource(ps, connection, null);
        }
    }


    /**
     * 更新记录
     *
     * @param person person实体
     * @param sql    待预编译语句
     * @return
     */
    public static int update(Person person, String sql) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.setDate(3, new Date(person.getBirth().getTime()));
            ps.setInt(4, person.getId());
            int result = ps.executeUpdate();
            connection.commit();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException(e);
        } finally {
            closeResource(ps, connection, null);
        }
    }


    /**
     * 删除记录
     *
     * @param id  记录主键
     * @param sql
     * @return
     */
    public static int deleteById(int id, String sql) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            connection.commit();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException(e);
        } finally {
            closeResource(ps, connection, null);
        }
    }

    public static Person queryById(int personId, String sql) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, personId);
            rs = ps.executeQuery();

            Person person = null;
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                Date birth = rs.getDate(4);

                person = new Person(id, name, age, new java.util.Date(birth.getTime()));
            }
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException(e);
        } finally {
            closeResource(ps, connection, rs);
        }
    }

    public static void closeResource(PreparedStatement ps, Connection connection, ResultSet rs) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Person personToSave = new Person("小明3", 23, new Date(System.currentTimeMillis()));
        // 新增
        String insertSql = "insert into tb_person (name, age, birth) values (?, ?, ?)";
        int insertResult = insert(personToSave, insertSql);
        System.out.println("新增结果：" + insertResult);

        /*// 更新
        Person personToUpdate = new Person(1, "小红", 22, new Date(System.currentTimeMillis()));
        String updateSql = "update tb_person set name = ?, age = ?, birth = ? where id = ?";
        int updateResult = update(personToUpdate, updateSql);
        System.out.printf("更新结果：" + updateResult);*/

        /*// 删除
        String deleteSql = "delete from tb_person where id = ?";
        int deleteResult = delete(1, deleteSql);
        System.out.println("删除结果：" + deleteResult);*/

        /*// 查询
        String querySql = "select * from tb_person where id = ?";
        Person person = queryById(2, querySql);
        System.out.println(person);*/
    }
}
