package example;

public class MessageWriter {

  public static void info(final String message) {
    System.out.println(message);
  }

  public static void info(final String message, final Object object) {
    System.out.println(message);
    System.out.println(object.toString());
  }

  public static void error(final String message) {
    System.err.println(message);
  }

}
