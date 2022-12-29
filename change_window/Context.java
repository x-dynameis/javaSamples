package change_window;

import java.sql.Connection;

public class Context {
    private final static Context instance = new Context();
    public static Context getInstance() {
        return instance;
    }

    private Connection con;
    public void setConnection(Connection con)
    {
        this.con=con;
    }
    public Connection getConnection() {
        return con;
    }

//    private TabRoughController tabRough;
//    public void setTabRough(TabRoughController tabRough) {
//        this.tabRough=tabRough;
//    }
//
//    public TabRoughController getTabRough() {
//        return tabRough;
//    }
}