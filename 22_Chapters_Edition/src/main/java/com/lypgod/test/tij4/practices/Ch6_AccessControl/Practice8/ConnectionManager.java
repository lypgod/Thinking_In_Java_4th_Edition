package com.lypgod.test.tij4.practices.Ch6_AccessControl.Practice8;

class Connection {

}

public class ConnectionManager {
    static Connection[] connections;

    static {
        connections = new Connection[] {new Connection(), new Connection(), new Connection()};
    }

    static Connection getConnection() {
        Connection connection = null;
//        for (Connection c:connections) {
//            if (c != null) {
//                connection = c;
//                c = null;
//                break;
//            }
//        }
        for (int i = connections.length - 1; i >= 0; i--) {
            if (connections[i] != null) {
                connection = connections[i];
                connections[i] = null;
                break;
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());
    }
}
