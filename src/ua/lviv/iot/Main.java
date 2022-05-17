package ua.lviv.iot;

import ua.lviv.iot.enums.ToolType;
import ua.lviv.iot.models.*;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String... strings) {
        List<AbstractTool> toolList = new LinkedList<>();
        toolList.add(new Drill("drill", "DeWalt", ToolType.MULTITOOL, 1500, 16, 2500));
        toolList.add(new Hammer("Hammer", "DniproM", ToolType.SOFATOOL, 0, 750));
        toolList.add(new Stapler("stapler", "Makita", ToolType.SOFATOOL, 150, 75));
        toolList.add(new Saw("Druzhba 2", "Bosch", ToolType.CHAIRTOOL, 500, 80));

    }
}
