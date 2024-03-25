package java_learnings.functional_interface;

@FunctionalInterface
interface Bird {

    void canFly(String val);
    
    default void getHeight(){}

    static void canEat(){}

    String toString();
}


class Eagle implements Bird {
    @Override
    public void canFly(String val) {
        System.out.println("Eagle Bird Implementatiion");
    }
}

@FunctionalInterface
interface Consumer<T> {
    void accept(T t);
}

@FunctionalInterface
interface Supplier<T> {
    T get();
}

@FunctionalInterface
interface Function<T, R> {
    R apply(T t);
}

@FunctionalInterface
interface Predicate<T> {
    boolean isValid(T t);
}


public class Main {
     public static void main(String[] args) {

        Bird eagleBird = new Bird() {

            @Override
            public void canFly(String val) {
                System.out.println("Eagle Bird Object implementation");
            }
            
        };

        eagleBird.canFly("vertical");

        // lambda expression reduces the verbose
        Bird eagleBirdLambda = (String value) -> {
            System.out.println("Eagle Bird Object Lambda Expression");
        };

        eagleBirdLambda.canFly("vertical");
        

        // Types of Functional Interfacce

        // comsumer
        Consumer<Integer> consumerObj = (Integer value) -> {
            System.out.println("get method called");
            if(value > 10){
                System.out.println("value > 10");
            }
        };
        consumerObj.accept(12);

        // supplier
        Supplier<String> supplier = () -> "method returned this";
        System.out.println(supplier.get());

        // function
        Function<Integer, String> functionObj = (Integer value) -> "Modified the value " + value;
        System.out.println(functionObj.apply(10));

        // predicate
        Predicate<Integer> predicateObj = (Integer value) -> value%2==0;
        System.out.println(predicateObj.isValid(11));
     }
}