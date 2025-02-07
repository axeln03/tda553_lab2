package main;

import java.util.Stack;

public class Storage<T extends Vehicle> {
    private final int capacity;
    private Stack<T> stack;


    public Storage(int capacity ){

        this.capacity = capacity;
        this.stack = new Stack<>();
    }

    public int getCurrentSize(){
        return stack.size();
    }
    public int getMaxSize(){
        return capacity;
    }
    public void load(T type){
        stack.push(type);
    }
    public T deLoad(){
        return stack.pop();
<<<<<<< HEAD:main/Storage.java

=======
>>>>>>> 57311c9c71ab0f26e5708d23ab8832a31eeb7e6a:main/Trailer.java
    }
}
