package utils;

import service.ItemsService;
import utils.exeptions.NameAlreadyExists;

public enum CreateRows {
  INSTANCE;

  public void start() {
    try {
      ItemsService.INSTANCE.insert("sneakers", 4, 2300, 10, "sneakers.jpg");
      ItemsService.INSTANCE.insert("sneakers adidas", 4, 5500, 3, "sneakers adidas.jpg");
      ItemsService.INSTANCE.insert("chair", 1, 15000, 1, "chair.jpg");
      ItemsService.INSTANCE.insert("table", 1, 1000, 1, "table.jpg");
      ItemsService.INSTANCE.insert("phone", 2, 1000, 17, "phone.jpg");
      ItemsService.INSTANCE.insert("notebook", 2, 17000, 5, "notebook.jpg");
      ItemsService.INSTANCE.insert("ball", 3, 10, 50, "ball.jpg");
      ItemsService.INSTANCE.insert("baseball bat", 3, 15, 30, "baseball bat.jpg");
      ItemsService.INSTANCE.insert("pen", 5, 1, 300, "pen.jpg");
      ItemsService.INSTANCE.insert("paper", 5, 7, 100, "paper.jpg");
      ItemsService.INSTANCE.insert("hemingway", 6, 570, 70, "hemingway.jpg");
      ItemsService.INSTANCE.insert("orwell", 6, 580, 70, "orwell.jpg");

    } catch (NameAlreadyExists nameAlreadyExists) {
      nameAlreadyExists.printStackTrace();
    }
  }
}
