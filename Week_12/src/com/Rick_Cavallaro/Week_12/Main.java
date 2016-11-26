package com.Rick_Cavallaro.Week_12;

import java.util.ArrayList;
import java.util.List;

class QueueEmptyException extends Exception {}
class QueueFullException extends Exception {}

class Queue<E> {
    private List<E> elements;
    private int index = 0;
    private int size;

    Queue(int size) {
        elements = new ArrayList<E>();
        this.size = size;
    }

    public void enqueue(E element) throws QueueFullException {
        if (elements.size() >= size) {
            throw new QueueFullException();
        }
        elements.add(element);
    }

    public E dequeue() throws QueueEmptyException {
        if (elements.size() == 0) {
            throw new QueueEmptyException();
        }
        return elements.remove(0);
    }
}
/*
 * Created by Rick on 11/15/2016.
 */
public class Main {
    public static void main(String[] args){
        Queue<String> strings = new Queue<String>(2);
        try {
            strings.enqueue("First String");
            strings.enqueue("Second String");
            //strings.enqueue("Third String"); //Test Queue Full Exception
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
            //System.out.println(strings.dequeue()); //Test Queue Empty Exception
        }
        catch (QueueEmptyException | QueueFullException e) {
            e.printStackTrace();
        }
    }
}
