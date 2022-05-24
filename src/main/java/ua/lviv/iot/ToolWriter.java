package ua.lviv.iot;

import ua.lviv.iot.models.*;

import java.io.*;
import java.util.List;

public class ToolWriter {

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("DM_DEFAULT_ENCODING")
    public void writeToFile(List<AbstractTool> tools, String name) {
        if (tools != null) {
            File file = new File(name + ".csv");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

                for (AbstractTool tool : tools) {
                    writer.write(tool.getHeaders() + "\n");
                    writer.write(tool.toCSV() + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
