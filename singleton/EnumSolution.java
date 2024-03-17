package java_learnings.singleton;

enum DBConnection {
    // in enum all constructors are private by default
    // only one object is created as per jvm
    // by default Enums are singleton, one instance per JVM 
    INSTANCE
}

public class EnumSolution {
    public static void main(String[] args) {
        
    }
}
