package org.sushant.thread_local;

public class UserContext {
    private static ThreadLocal<String> currentUser = ThreadLocal.withInitial(() -> "Guest");

    public static void set(String user) {
        currentUser.set(user);
    }

    public static String get() {
        return currentUser.get();
    }

    public static void clear() {
        currentUser.remove();
    }
}
