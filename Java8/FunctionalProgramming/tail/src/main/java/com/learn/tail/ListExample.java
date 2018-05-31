package com.learn.tail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mshalabi on 16.05.17.
 */
public class ListExample {
    public static List<Long> create(long max){
        List<Long> list = new ArrayList<Long>();
        return addToList(list, max);
    }
    private static List<Long> addToList(List<Long> list, Long item)  {
        list.add(item);  //TODO: list.add is not a functional statement.
        item--;
        System.out.println(item);
        return item == 0 ?  list :  addToList(list, item);
    }
}
