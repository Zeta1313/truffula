import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class TruffulaOptionsTest {

  @Test
  void testValidDirectoryIsSet(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", "-h", directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertTrue(options.isShowHidden());
    assertFalse(options.isUseColor());
  }

  @Test
  void testValidDirectoryWithOnlyPath(@TempDir File tempDir) throws FileNotFoundException {
    File directory = new File(tempDir, "folderA");
    directory.mkdir();

    String[] args = {directory.getAbsolutePath()};

    TruffulaOptions options = new TruffulaOptions(args);

    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertFalse(options.isShowHidden());
    assertTrue(options.isUseColor());
  }

  @Test
  void testComplexNestedDirectoryStructureAndFlagCombination(@TempDir File tempDir) throws FileNotFoundException, IOException {
    File root = new File(tempDir, "rootDir");
    File level1 = new File(root, "level1");
    File level2 = new File(level1, "level2");
    File hiddenDir = new File(level2, ".hiddenFolder");

    root.mkdir();
    level1.mkdir();
    level2.mkdir();
    hiddenDir.mkdir();

    File file1 = new File(root, "file.txt");
    File file2 = new File(level1, ".hiddenFile.txt");
    File file3 = new File(level2, "data.bin");

    file1.createNewFile();
    file2.createNewFile();
    file3.createNewFile();

    String[] args = {"-nc", "-h", directoryPath(root)};

    TruffulaOptions options = new TruffulaOptions(args);

    assertEquals(root.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertTrue(options.isShowHidden());
    assertFalse(options.isUseColor());

    assertTrue(level1.exists());
    assertTrue(level2.exists());
    assertTrue(hiddenDir.exists());

    assertTrue(file1.exists());
    assertTrue(file2.exists());
    assertTrue(file3.exists());
  }

  private String directoryPath(File file) {
    return file.getAbsolutePath();
  }
}
