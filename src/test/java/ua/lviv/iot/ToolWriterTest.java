package ua.lviv.iot;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.enums.ToolType;
import ua.lviv.iot.models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;


@SuppressFBWarnings({"DM_DEFAULT_ENCODING", "DM_DEFAULT_ENCODING"})
class ToolWriterTest {
    List<AbstractTool> createTestLists(int list) {
        List<AbstractTool> toolList = null;
        if (list == 0) {
            toolList = new LinkedList<>();
            toolList.add(new Drill("Drill", "DeWalt", ToolType.CHAIRTOOL, 1500, 16, 2500));
            toolList.add(new Hammer("Hammer", "DniproM", ToolType.SOFATOOL, 0, 750));
            toolList.add(new Stapler("Stapler", "Makita", ToolType.SOFATOOL, 150, 75));
            toolList.add(new Saw("Druzhba 2", "Bosch", ToolType.CHAIRTOOL, 500, 80));
        } else if (list == 1) {

            toolList = new LinkedList<>();
            toolList.add(new Drill("Drill", "DeWalt", ToolType.CHAIRTOOL, 1500, 16, 2500));
            toolList.add(new Drill("Drill2", "DeWalt", ToolType.CHAIRTOOL, 1500, 16, 2500));
            toolList.add(new Drill("Drill3", "DeWalt", ToolType.CHAIRTOOL, 1500, 16, 2500));
            toolList.add(new Drill("Drill4", "DeWalt", ToolType.CHAIRTOOL, 1500, 16, 2500));

        }
        return toolList;
    }

    public static String separator = File.separator;

    @Test
    void writeDifferentClassesToFile() {
        Path expectedPath = Paths.get("src" + separator + "test" + separator + "resources" + separator + "firstExpectedFile.csv");
        ToolWriter writer = new ToolWriter();

        writer.writeToFile(createTestLists(0), "fileWithDifferentClasses");
        File expectedFile = new File(String.valueOf(expectedPath));

        Assertions.assertTrue(expectedFile.exists());
        try (BufferedReader testFileReader = new BufferedReader(new FileReader(expectedFile));
             BufferedReader currentFileReader = new BufferedReader(new FileReader("fileWithDifferentClasses.csv"))) {

            String nextLine;
            while ((nextLine = testFileReader.readLine()) != null) {
                Assertions.assertEquals(currentFileReader.readLine(), nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void writeSameClassesToFile() {
        Path expectedPath = Paths.get("src" + separator + "test" + separator + "resources" + separator + "secondExpectedFile.csv");
        ToolWriter writer = new ToolWriter();

        writer.writeToFile(createTestLists(1), "fileWithSameClasses");
        File expectedFile = new File(String.valueOf(expectedPath));

        Assertions.assertTrue(expectedFile.exists());
        try (BufferedReader testFileReader = new BufferedReader(new FileReader(expectedFile));
             BufferedReader currentFileReader = new BufferedReader(new FileReader("fileWithSameClasses.csv"))) {

            String nextLine;
            while ((nextLine = testFileReader.readLine()) != null) {
                Assertions.assertEquals(nextLine, currentFileReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void writeEmptyListToFile() {
        ToolWriter writer = new ToolWriter();
        writer.writeToFile(createTestLists(2), "emptyFile");
        File expectedFile = new File("emptyFile.csv");
        Assertions.assertFalse(expectedFile.exists());
    }
}