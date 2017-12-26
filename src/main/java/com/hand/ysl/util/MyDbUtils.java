package com.hand.ysl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

public class MyDbUtils {

    private static String className = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8";
    private static String user = "ysl";
    private static String password = "2577097";
    private static QueryRunner queryRunner = new QueryRunner();

    public static final String INSERT_LOG = "insert into log_info(topdomain,usetime,time) values(?,?,?)";

    static{
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        String topdomain = "taobao.com";
        String usetime = "100";
        String currentTime="1444218216106";
        MyDbUtils.update(MyDbUtils.INSERT_LOG, topdomain, usetime, currentTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        update(INSERT_LOG,topdomain,usetime,sdf.format(new Date(Long.parseLong(currentTime))));
    }
    /**
     * @param conn
     * @throws SQLException
     */
    public static void update(String sql,Object... params) throws SQLException {
        Connection connection = getConnection();
        //更新数据
        queryRunner.update(connection,sql, params);
        connection.close();
    }

    public static List<String> executeQuerySql(String sql) {

        List<String> result = new ArrayList<String>();
        try {
            List<Object[]> requstList = queryRunner.query(getConnection(), sql,
                    new ArrayListHandler(new BasicRowProcessor() {
                        @Override
                        public <Object> List<Object> toBeanList(ResultSet rs,
                                                                Class<Object> type) throws SQLException {
                            return super.toBeanList(rs, type);
                        }
                    }));
            for (Object[] objects : requstList) {
                result.add(objects[0].toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * @throws SQLException
     *
     */
    public static Connection getConnection() throws SQLException {
        //获取mysql连接
        return DriverManager.getConnection(url, user, password);
    }
}