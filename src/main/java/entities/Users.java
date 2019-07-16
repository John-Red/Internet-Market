package entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data

public class Users {

  private Long userId;
  private String login;
  private String password;
  private String role;
  private boolean active = true;
}
