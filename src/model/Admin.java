package model;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private static final List<Admin> adminList = new ArrayList<>();

    static {
        adminList.add(new Admin("Nazia", "Nazia@1653"));
        adminList.add(new Admin("Charu", "Charu@1603"));
    }

    public Admin(String username, String password) {
        super(username, password);
    }

    public static boolean isValidAdmin(String username, String password) {
        for (Admin admin : adminList) {
            if (admin.getUsername().equals(username) && admin.checkPassword(password)) {
                return true;
            }
        }
        return false;
    }
}
