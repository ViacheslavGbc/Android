package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Element> ITEMS = new ArrayList<Element>();

    private static Random random = new Random(System.currentTimeMillis());

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Element> ITEM_MAP = new HashMap<String, Element>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItemElement(createElement(i));
        }
    }

    public static void addItemElement(Element item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    public static Element createElement(int position) {
        return new Element(String.valueOf(random.nextLong()), "Item " + position, makeDetails(position));
    }

    public static Element createElement(String name, String details) {
        return new Element(String.valueOf(random.nextLong()), name, details);
    }

    public static void removeElement(Element item){
        Element el = ITEM_MAP.get(item.id);
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

    /**
     * A dummy item representing a piece of content.
     */
    public static class Element {
        public final String id;
        public final String content;
        public final String details;

        public Element(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
