/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

    public static void main(String[] args) {
        // TODO: create two instances of your thread subclass and start them up
        MessagePrinter printer1 = new MessagePrinter("You say hello", 5, 2000);
        printer1.start();

        MessagePrinter printer2 = new MessagePrinter("And I say goodbye!", 5, 3000);
        printer2.start();

        MessagePrinter printer3 = new MessagePrinter("Hello, Hello", 10, 1000);
        printer3.start();
    }
}