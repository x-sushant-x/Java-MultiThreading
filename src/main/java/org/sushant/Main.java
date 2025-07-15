package org.sushant;

import org.sushant.race_condition.Initializer;
import org.sushant.race_condition.LazyInitialize;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Initializer initializer = new Initializer(new LazyInitialize());
        initializer.testInitialize();
    }
}