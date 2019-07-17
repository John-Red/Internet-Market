package utils.exeptions;

import lombok.extern.log4j.Log4j;

@Log4j
public class InvalidLoginOrPassword extends Exception {

  public InvalidLoginOrPassword() {
    super();
    log.error("Invalid login or password");
  }
}
