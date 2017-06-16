package com.softserve.edu.servicecenter.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public static String readMessage() {
        String result = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            result = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
