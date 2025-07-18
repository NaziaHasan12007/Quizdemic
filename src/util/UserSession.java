package util;

import model.Student;

public class UserSession {
    private static Student currentUser;

    public static void setCurrentUser(Student user) {
        currentUser = user;
    }

    public static Student getCurrentUser() {
        return currentUser;
    }

    public static void clear() {
        currentUser = null;
    }
}

