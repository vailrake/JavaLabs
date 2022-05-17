package ua.lviv.iot.manager;

import ua.lviv.iot.enums.ToolType;
import ua.lviv.iot.enums.TypeOfSort;
import ua.lviv.iot.models.AbstractTool;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ToolManager {

    public List<AbstractTool> findToolsByType(List<AbstractTool> toolList, ToolType type) {
        List<AbstractTool> finalList = new LinkedList<>();
        for (AbstractTool tool : toolList) {
            if (tool.getToolType().equals(type)) {
                finalList.add(tool);
            }
        }
        return finalList;
    }

    public List<AbstractTool> sortToolsByProducer(List<AbstractTool> toolList, TypeOfSort type) {
        if (type.equals(TypeOfSort.ASCENDING)) {
            toolList.sort(Comparator.comparing(AbstractTool::getName));
        } else {
            toolList.sort((obj1, obj2) -> obj2.getName().compareTo(obj1.getName()));
        }
        return toolList;
    }

    public List<AbstractTool> sortToolsByPowerConsumption(List<AbstractTool> toolList, TypeOfSort type) {
        if (type.equals(TypeOfSort.ASCENDING)) {
            toolList.sort(Comparator.comparingInt(AbstractTool::getPowerConsumption));
        } else {
            toolList.sort((obj1, obj2) -> Integer.compare(obj2.getPowerConsumption(), obj1.getPowerConsumption()));
        }
        return toolList;
    }
}
