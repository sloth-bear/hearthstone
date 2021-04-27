package printer;

public class Printer {

  private Printer() {
    throw new UnsupportedOperationException();
  }

  public static void printSeparateLine(final String message) {
    System.out.printf(":: " + message + " ::%n%n");
  }

  public static void printInformationLine(final String message, final Object suffix) {
    System.out.printf(message + " %s%n%n", suffix.toString());
  }

}
