package ua.lviv.iot.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.enums.ToolType;
import ua.lviv.iot.enums.TypeOfSort;
import ua.lviv.iot.models.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToolManagerTest {

    List<AbstractTool> createTestList() {
        List<AbstractTool> toolList = new LinkedList<>();
        toolList.add(new Drill("Drill", "DeWalt", ToolType.CHAIRTOOL, 1500, 16, 2500));
        toolList.add(new Hammer("Hammer", "DniproM", ToolType.SOFATOOL, 0, 750));
        toolList.add(new Stapler("Stapler", "Makita", ToolType.SOFATOOL, 150, 75));
        toolList.add(new Saw("Druzhba 2", "Bosch", ToolType.CHAIRTOOL, 500, 80));
        return toolList;
    }

    List<AbstractTool> toolsList = null;
    ToolManager manager = new ToolManager();

    @Test
    void findToolsByType() {
        toolsList = createTestList();
        List<AbstractTool> tools = manager.findToolsByType(toolsList, ToolType.SOFATOOL);
        for (AbstractTool tool : tools) {
            Assertions.assertEquals(tool.getToolType(), ToolType.SOFATOOL);
        }
    }


    @Test
    void sortToolsByProducerAscending() {
        toolsList = createTestList();
        manager.sortToolsByProducer(toolsList, TypeOfSort.ASCENDING);

        Assertions.assertEquals(toolsList.get(0).getName(), "Drill");
        Assertions.assertEquals(toolsList.get(1).getName(), "Druzhba 2");
        Assertions.assertEquals(toolsList.get(2).getName(), "Hammer");
        Assertions.assertEquals(toolsList.get(3).getName(), "Stapler");
    }

    @Test
    void sortToolsByProducerDescending() {
        toolsList = createTestList();
        manager.sortToolsByProducer(toolsList, TypeOfSort.DESCENDING);

        Assertions.assertEquals(toolsList.get(0).getName(), "Stapler");
        Assertions.assertEquals(toolsList.get(1).getName(), "Hammer");
        Assertions.assertEquals(toolsList.get(2).getName(), "Druzhba 2");
        Assertions.assertEquals(toolsList.get(3).getName(), "Drill");
    }

    @Test
    void sortToolsByPowerConsumptionAscending() {
        toolsList = createTestList();
        manager.sortToolsByPowerConsumption(toolsList, TypeOfSort.ASCENDING);

        for (int index = 0; index < toolsList.size() - 1; index++) {
            Assertions.assertTrue(toolsList.get(index).getPowerConsumption() <= toolsList.get(index + 1).getPowerConsumption());
        }
    }

    @Test
    void sortToolsByPowerConsumptionDescending() {
        toolsList = createTestList();
        manager.sortToolsByPowerConsumption(toolsList, TypeOfSort.DESCENDING);

        for (int index = 0; index < toolsList.size() - 1; index++) {
            Assertions.assertTrue(toolsList.get(index).getPowerConsumption() >= toolsList.get(index + 1).getPowerConsumption());
        }
    }
}