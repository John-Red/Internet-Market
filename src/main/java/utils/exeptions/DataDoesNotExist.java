package utils.exeptions;

import lombok.extern.log4j.Log4j;

@Log4j
public class DataDoesNotExist extends Exception {

  public DataDoesNotExist() {
    super();
    log.error("Data does not exist");
  }
}
