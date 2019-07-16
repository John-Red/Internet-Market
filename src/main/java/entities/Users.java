package entities;

import javax.jws.soap.SOAPBinding.Use;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.apache.catalina.User;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
public class Users {

  private Long userId;
  private String login;
  private String password;
  private String role;
  private boolean active = true;



}
