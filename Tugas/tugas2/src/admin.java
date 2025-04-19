import java.util.Scanner;

public class admin {
    private String username = "admin";
    private String password = "admin272";

    public boolean verify(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
