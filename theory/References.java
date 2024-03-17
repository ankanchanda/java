package java_learnings.theory;

import java.lang.ref.WeakReference;

class Person {
    int p = 10;
}

class References{
    public static void main(String[] args) {
        // strong reference
        Person obj =  new Person();
         // weak reference
        WeakReference<Person> weakObj = new WeakReference<Person>(new Person());
        while(weakObj != null){
            System.out.println(obj.p);
            System.out.println(weakObj.get().p);
            System.gc();
        }


    }
}