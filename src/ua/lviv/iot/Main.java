package ua.lviv.iot;

import ua.lviv.iot.enums.ToolType;
import ua.lviv.iot.enums.TypeOfSort;
import ua.lviv.iot.manager.ToolManager;
import ua.lviv.iot.models.*;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String... strings) {
        List<AbstractTool> toolList = new LinkedList<>();
        toolList.add(new Drill("Drill", "DeWalt", ToolType.CHAIRTOOL, 1500, 16, 2500));
        toolList.add(new Hammer("Hammer", "DniproM", ToolType.SOFATOOL, 0, 750));
        toolList.add(new Stapler("Stapler", "Makita", ToolType.SOFATOOL, 150, 75));
        toolList.add(new Saw("Druzhba 2", "Bosch", ToolType.CHAIRTOOL, 500, 80));

        ToolManager manager = new ToolManager();
        System.out.println("Find func");
        for (AbstractTool tool : manager.findToolsByType(toolList, ToolType.SOFATOOL)) {
            System.out.println(tool.getName() + " " + tool.getToolType());
        }
        System.out.println("ASC Sort by power consumption func");
        for (AbstractTool tool : manager.sortToolsByPowerConsumption(toolList, TypeOfSort.ASCENDING)) {
            System.out.println(tool.getName() + " " + tool.getPowerConsumption());
        }
        System.out.println("DESC Sort by power consumption func");
        for (AbstractTool tool : manager.sortToolsByPowerConsumption(toolList, TypeOfSort.DESCENDING)) {
            System.out.println(tool.getName() + " " + tool.getPowerConsumption());
        }
        System.out.println("ASC Sort by name");
        for (AbstractTool tool : manager.sortToolsByProducer(toolList, TypeOfSort.ASCENDING)) {
            System.out.println(tool.getName());
        }
        System.out.println("DESC Sort by name");
        for (AbstractTool tool : manager.sortToolsByProducer(toolList, TypeOfSort.DESCENDING)) {
            System.out.println(tool.getName());
        }
    }
}
