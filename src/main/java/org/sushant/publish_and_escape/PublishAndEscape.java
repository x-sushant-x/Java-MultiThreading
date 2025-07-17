package org.sushant.publish_and_escape;

import java.util.ArrayList;
import java.util.List;

public class PublishAndEscape {

    private static class UnsafeStates {
        private List<String> states = new ArrayList<>(List.of("AB", "CD"));

        public List<String> getStates () { return states; }

        public void printStates() {
            states.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        UnsafeStates unsafeStates = new UnsafeStates();

        List<String> states = unsafeStates.getStates();
        states.add("EF");

        unsafeStates.printStates();
    }
}
