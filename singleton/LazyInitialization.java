package java_learnings.singleton;

class DBConnection{
    private static DBConnection connObject = new DBConnection();

    private DBConnection(){}

    public static DBConnection getInstance(){
        if(connObject == null){
            connObject = new DBConnection();
        }
        return connObject;
    }
}

public class LazyInitialization {
    public static void main(String[] args) {
        DBConnection connObj = DBConnection.getInstance();
    }
}
