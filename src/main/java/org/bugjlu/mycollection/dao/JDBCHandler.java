package org.bugjlu.mycollection.dao;

import java.sql.*;

public class JDBCHandler implements IDBHandler {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/rmitest?useUnicode=true&characterEncoding=UTF-8";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "123456";

    // Connection object
    private Connection connection;

    // load db driver
    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //TODO: log db driver load fail.
        }
    }

    // return a connected handler
    public static IDBHandler getInstance() {
        IDBHandler h = new JDBCHandler();
        h.connect();
        return h;
    }

    // if no ? in sql, please send null to param.
    // return null if error occurs while running (like send a sql with wrong syntax)
    @Override
    public ResultSet executeQuery(String sql, Object[] param) throws SQLException {
        PreparedStatement st = null;
        st = connection.prepareStatement(sql);
        if (param != null) {
            for (int i = 0; i < param.length; i++) {
                st.setObject(i+1, param[i]);
            }
        }
        return st.executeQuery();
    }

    // if no ? in sql, please send null to param.
    // return -1 if error occurs while running (like send a sql with wrong syntax)
    @Override
    public int executeUpdate(String sql, Object[] param) throws SQLException {
        PreparedStatement st = null;
        st = connection.prepareStatement(sql);
        if (param != null) {
            for (int i = 0; i < param.length; i++) {
                st.setObject(i+1, param[i]);
            }
        }
        return st.executeUpdate();
    }

    @Override
    public int connect() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            // can't get db conn.
            return 0;
        }
        return 1;
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }

    // close the connection before finalization of this if user forget it.
    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }
}
