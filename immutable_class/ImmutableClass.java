package java_learnings.immutable_class;

import java.util.ArrayList;
import java.util.List;

final class MyImmutableClass{
    private final String name;
    private final List<Object> petNameList;

    MyImmutableClass(String name, List<Object> petNameList){
        this.name = name;
        this.petNameList = petNameList;
    }

    public String getName(){
        return name;
    }

    public List<Object> getPetNameList(){
        // this is needed because making list means you cannot now point it to the new list
        // but you can still add and remove values from it
        // so send a copy of it
        return new ArrayList<>(petNameList);
    }
}

public class ImmutableClass {
    public static void main(String[] args) {
        List<Object> petNames = new ArrayList<>();
        petNames.add("abc");
        petNames.add("def");

        MyImmutableClass myImmutableClassObj = new MyImmutableClass("some_name", petNames);
        System.out.println(myImmutableClassObj.getName());

        myImmutableClassObj.getPetNameList().add("ghi");
        System.out.println(myImmutableClassObj.getPetNameList());
    }
}
