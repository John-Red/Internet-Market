package utils;

import service.ItemsService;
import utils.exeptions.NameAlreadyExists;

public enum CreateRows {
  INSTANCE;

  public void start() {
    try {
      //      ItemsService.INSTANCE.insert("table", 1, 1000, 1, "table.jpg");
      //      ItemsService.INSTANCE.insert("sneakers adidas", 4, 5500, 3, "sneakers adidas.jpg");

      // ItemsService.INSTANCE.insert("sneakers", 4, 2300, 10, "sneakers.jpg");
      // ItemsService.INSTANCE.insert("chair", 1, 15000, 1, "chair.jpg");
      //  ItemsService.INSTANCE.insert("Flash drive", 2, 15000, 1, "flash.jpg");
      //  ItemsService.INSTANCE.insert("Portable speaker", 2, 15000, 1, "portablespeaker.jpg");
      //  ItemsService.INSTANCE.insert("Power bank", 1, 15000, 1, "powerbank.jpg");
      //  ItemsService.INSTANCE.insert("phone", 2, 1000, 17, "phone.jpg");
      // ItemsService.INSTANCE.insert("notebook", 2, 17000, 5, "notebook.jpg");
      //      ItemsService.INSTANCE.insert("ball", 3, 10, 50, "ball.jpg");
      //      ItemsService.INSTANCE.insert("baseball bat", 3, 15, 30, "baseball bat.jpg");
      //      ItemsService.INSTANCE.insert("pen", 5, 1, 300, "pen.jpg");
      //      ItemsService.INSTANCE.insert("paper", 5, 7, 100, "paper.jpg");
      //      ItemsService.INSTANCE.insert("hemingway", 6, 570, 70, "hemingway.jpg");
      //      ItemsService.INSTANCE.insert("orwell", 6, 580, 70, "orwell.jpg");
      //      ItemsService.INSTANCE.insert("Laptop bag", 4, 700, 50, "laptopBag.jpg");
      //      ItemsService.INSTANCE.insert("Termo cap", 4, 100, 50, "termocap.jpg");
      //      ItemsService.INSTANCE.insert("Swiss knife", 4, 400, 50, "swissKnife.jpg");
      //      ItemsService.INSTANCE.insert("Swiss card", 4, 900, 50, "swisscard.jpg");
      //      ItemsService.INSTANCE.insert("Air couch", 4, 2500, 50, "aircouch.jpg");
      //      ItemsService.INSTANCE.insert("Notebook", 5, 30, 50, "note.jpg");
      ItemsService.INSTANCE.insert("Antistress ball", 4, 10, 500, "antistressball.jpg");
      //      ItemsService.INSTANCE.insert("Notebook unites", 5, 100, 30, "note2.jpg");
      //      ItemsService.INSTANCE.insert("Thinking in Java", 6, 5000, 60, "thinkinginjava.jpg");
      //      ItemsService.INSTANCE.insert("Understanding software", 6, 4000, 40,
      // "understandingsoftware.jpg");
      //      ItemsService.INSTANCE.insert("Java", 6, 3000, 40, "Java.jpg");
      //      ItemsService.INSTANCE.insert("Code simplicity", 6, 3000, 40, "codesimplicity.jpg");
      //      ItemsService.INSTANCE.insert("Hobbit", 6, 3000, 40, "hobbit.jpg");
      //      ItemsService.INSTANCE.insert("Office chair", 1, 300, 40, "chairoffice.jpg");
      //      ItemsService.INSTANCE.insert("Office table", 1, 300, 40, "officetable.jpg");

    } catch (NameAlreadyExists nameAlreadyExists) {
      nameAlreadyExists.printStackTrace();
    }
  }
}
