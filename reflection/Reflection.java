package java_learnings.reflection;

import java.lang.reflect.Method;

class SomeClass {

    private int num;
    SomeClass(){
        num = 0;
    }

    public void run(){}

    public void kick(){}
}


public class Reflection {
    public static void main(String[] args) {

        Class obj = SomeClass.class;
        System.out.println(obj.getName());

        Method[] methods = obj.getMethods();
        for(Method method: methods){
            // only public methods
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getDeclaringClass());
        }

    }
}
