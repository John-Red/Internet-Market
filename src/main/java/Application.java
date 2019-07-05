import server.ServerApplication;

public class Application {
  public static void main(String[] args) {
    try {
      ServerApplication.INSTANCE.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
