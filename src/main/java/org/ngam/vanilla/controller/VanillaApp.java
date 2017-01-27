package org.ngam.vanilla.controller;

import org.ngam.vanilla.dao.VanillaDAO;

/**
 * Created by phoenix on 15/11/16.
 */
public class VanillaApp {
    VanillaDAO dao;
    public static void main(String[] args) {
        boolean cont = true;

        while (cont) {
            String input = null;
            if (input.equalsIgnoreCase("quit"))
                cont = false;
        }
        put("Goodbye!");
    }
    private static void add() {

    }
    private static void remove() {

    }
    private static void get() {

    }
    private static void put(Object... args) {
        for (Object obj : args) System.out.print(obj);
        System.out.println();
    }
}
