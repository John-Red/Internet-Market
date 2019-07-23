package entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Users {

  private Long userId;
  private String login;
  private String password;
  private String role;
  private boolean active = true;
  private Integer balance;

}
