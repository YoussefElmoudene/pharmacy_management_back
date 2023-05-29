package ma.gestion.pharmacie.authentication;

public class UserVo {
    public String email;
    public String password;


    @Override
    public String toString() {
        return "UserVo{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
