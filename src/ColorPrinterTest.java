import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorPrinterTest {

  @Test
  void testPrintlnWithRedColorAndReset() {
    // Arrange: Capture the printed output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.RED);

    // Act: Print the message
    String message = "I speak for the trees";
    printer.println(message);


    String expectedOutput = ConsoleColor.RED + "I speak for the trees" + System.lineSeparator() + ConsoleColor.RESET;

    // Assert: Verify the printed output
    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testPrintWithGreenColorNoReset() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.GREEN);

    String message = "Green text";
    printer.print(message, false);

    String expectedOutput = ConsoleColor.GREEN + "Green text";

    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testPrintlnWithBlueColorAndReset() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.BLUE);

    String message = "Blue line";
    printer.println(message);

    String expectedOutput = ConsoleColor.BLUE + "Blue line" + System.lineSeparator() + ConsoleColor.RESET;

    assertEquals(expectedOutput, outputStream.toString());
  }
  @Test
  void testMultiplePrintlnWithoutReset() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.CYAN);

    printer.println("First line", false);
    printer.println("Second line", false);

    String expectedOutput =
        ConsoleColor.CYAN + "First line" + System.lineSeparator() +
        ConsoleColor.CYAN + "Second line" + System.lineSeparator();

    assertEquals(expectedOutput, outputStream.toString());
  }
}
