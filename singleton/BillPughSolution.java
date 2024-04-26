package java_learnings.singleton;

class DBConnection {

    private DBConnection(){}

    // it is making use of eager initialization
    // it is solving the disadvantage that even if the class is not used object is being created
    private static class DBConnectionHelper{

        // so it has put the object creation inside private static nested class
        // because nested class are not loaded in the memory, only when you use, it gets loaded
        private static final DBConnection INSTANCE_OBJECT = new DBConnection();
    }

    public static DBConnection getInstance(){
        return DBConnectionHelper.INSTANCE_OBJECT;
    }
}

public class BillPughSolution {
    public static void main(String[] args) {
        DBConnection connObj = DBConnection.getInstance();
    }
}
