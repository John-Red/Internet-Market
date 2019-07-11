package entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Users {

  private Long userId;
  private String login;
  private String password;
  private String role;
  private boolean active = true;
}
