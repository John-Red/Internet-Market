package entities;

import lombok.Data;


@Data
public class Users {

  private Long userId;
  private String login;
  private String password;
  private String role;
  private boolean active = true;
}
