package java_learnings.singleton;

class DBConnection {
    // Don't want anyone ton access this object by any other class
    private static DBConnection  conObject = new DBConnection();

    // private constructor so that no other place it can be used
    // to create a new object except within the class
    private DBConnection(){}

    // to get the object
    public static DBConnection getInstance(){
        return conObject;
    }

}

public class EagerSolution{
    // Means to define the object in advance
    public static void main(String[] args) {
        DBConnection conObject = DBConnection.getInstance();

        
    }
}