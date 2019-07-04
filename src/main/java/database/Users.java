package database;

import lombok.Data;
import lombok.NonNull;

@Data
public class Users {

    @NonNull
    private int user_id;
    @NonNull
    private String login;
    @NonNull
    private String password;
    private String role;
    private boolean active;

}
