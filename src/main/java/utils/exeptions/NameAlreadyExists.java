package utils.exeptions;

import lombok.extern.log4j.Log4j;

@Log4j
public class NameAlreadyExists extends Exception {

  public NameAlreadyExists() {
    super();
    log.error("Name already exists");
  }
}
