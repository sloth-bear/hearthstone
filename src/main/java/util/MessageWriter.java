package util;

public class MessageWriter {

  public static void info(final String message) {
    System.out.println(message + "\n");
  }

  public static void info(final String message, final Object object) {
    System.out.println(message);
    System.out.println(object.toString() + "\n");
  }

  public static void error(final String message) {
    System.err.println(message + "\n");
  }

}
