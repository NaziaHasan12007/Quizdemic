package util;

public class UserSession {
    private static String currentUsername;

    public static void setCurrentUsername(String name) {
        currentUsername = name;
    }

    public static String getCurrentUsername() {
        return currentUsername;
    }
}
