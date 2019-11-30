package com.example.shopping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShoppingManager {

    public static final ArrayList<Shopping> ITEMS = new ArrayList<Shopping>();
    private static Random random = new Random(System.currentTimeMillis());
    public static final Map<String, Shopping> ITEM_MAP = new HashMap<String, Shopping>();
    private static final int COUNT = 0;
    private static int index = COUNT;

    /*
   static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItemElement(createElement(i));
        }
    }*/


    public static void addItemElement(Shopping item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    public static void addItemElement(String content) {
       Shopping item = createElement(content);
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    public static Shopping createElement(int position) {
        return new Shopping(String.valueOf(position), "Item " + position);
    }


    public static Shopping createElement(String content) {
        index++;
        Shopping item = new Shopping(String.valueOf(index), content);
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
        return item;
    }


    public static Shopping createElement(String index, String content) {

        Shopping item = new Shopping(String.valueOf(index), content);
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
        //return new Shopping(String.valueOf(random.nextLong()), content);
        return item;
    }


    public static void removeElement(Shopping item){
        Shopping el = ITEM_MAP.get(item.id);
        ITEMS.remove(el);
        ITEM_MAP.remove(item.id);
    }


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static class Shopping implements Serializable {

        public  String id;
        public  String content;

        public Shopping(){}

        public Shopping(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content ;
        }
    }

}
