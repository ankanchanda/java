package java_learnings.singleton;

class DBConnection{
    // private static DBConnection connObj;
    private static volatile DBConnection connObj;

    private DBConnection(){}

    synchronized public static DBConnection getInstance(){
        // synchronized helps to put a lock and unlock
        // if two threads are calling it parallely
        // only one at a time will be allowed to get inside
        if(connObj == null){
            connObj = new DBConnection();
        }
        return connObj;
    }
}

public class SynchronizationBlock {
    
}
