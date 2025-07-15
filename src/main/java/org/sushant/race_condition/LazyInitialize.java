package org.sushant.race_condition;

public class LazyInitialize {

    private ExpensiveObject instance;
    private int totalObjectsCreated = 0;

    public synchronized ExpensiveObject initializeObject() {
        if (instance == null) {
            totalObjectsCreated++;
            instance = new ExpensiveObject();
        }
        return instance;
    }

    public void getTotalObjectsCreated() {
        System.out.println(totalObjectsCreated);
    }

    public static class ExpensiveObject {}
}

