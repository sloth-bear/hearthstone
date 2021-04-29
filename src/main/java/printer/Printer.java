package printer;

public class Printer {

  private Printer() {
    throw new UnsupportedOperationException();
  }

  public static void print(final String message) {
    System.out.println(":: " + message + " ::");
  }

  public static void print(final Object prefix, final String message) {
    System.out.println("[" + prefix + "] " + message);
  }

  public static void print(final Object prefix, final Object suffix) {
    System.out.printf("[%s]: %s%n", prefix.toString(), suffix.toString());
  }

  public static void print(final String message, final Object suffix) {
    System.out.printf(message + ": %s%n", suffix.toString());
  }

  public static void println(final String message, final Object suffix) {
    System.out.printf(message + " %n%s%n", suffix.toString());
  }

  public static void printDivider() {
    System.out.printf("%n***************************************************%n");
  }

}
