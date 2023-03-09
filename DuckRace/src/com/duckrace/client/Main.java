package com.duckrace.client;

import com.duckrace.app.DuckRaceApp;

/*
 * Application main-class.
 * Instantiates controller and say "go."
*/

class Main {

    public static void main(String[] args) {
        DuckRaceApp app = new DuckRaceApp();

        app.execute();
    }


}