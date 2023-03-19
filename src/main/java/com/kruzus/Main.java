package com.kruzus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        boolean areWeDone = true;
        ArrayList<Object> data = new ArrayList<>();

        print(">> TODO LIST 0.0.1");
        Thread.sleep(2000);

        while (areWeDone) {

            LocalDateTime now = LocalDateTime.now();
            // logic
            String stuff = input(">> What we doing? ");
            print(">> " + stuff);

            // commands so far
            if (stuff.contains("!q")) {
                areWeDone = false;
                print(">> Bye.");
            }

            // shows data
            if (stuff.contains("!data")) {
                if (data.isEmpty()) {
                    print(">> Data is not set.");
                } else {
                    data.forEach(Main::print);
                }
            }


               // clears data
               if (stuff.contains("!clear")) {
                data.clear();
            }

            // insert data
            if (stuff.contains("!insert")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy : hh:mm:ss a");
                String formattedDateTime = now.format(formatter);
                String inserts = input(">> What we working on? ");
                var json = Map.of(inserts, formattedDateTime);

                data.add(json);
            }

        }
    }

    static void print(Object data) {
        System.out.println(data);
    }

    static String input(Object data) {
        System.out.print(data);
        return scanner.nextLine();
    }

}