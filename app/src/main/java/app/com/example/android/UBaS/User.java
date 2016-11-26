package app.com.example.android.UBaS;

/**
 * Created by MandipSilwal on 11/25/16.
 */

public class User {

    public String fullname;
    public String email;
    public String password;
    public String utaId;

    public User(String name, String email, String password, String utaId) {
        this.fullname = name;
        this.email = email;
        this.password = password;
        this.utaId = utaId;
    }
}
