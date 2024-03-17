package java_learnings.singleton;

class DBConnection {
    // private static DBConnection connObj;
    private static volatile DBConnection connObj;

    private DBConnection(){}

    public static DBConnection getInstance(){
        if(connObj == null){
            // check if object is null, by default
            synchronized (DBConnection.class){
                // put a lock
                if(connObj == null){
                    // check again
                    connObj = new DBConnection();
                }
            }
        }
        return connObj;
    }
}

public class DoubleLocking {
    public static void main(String[] args) {
        
    }
}
