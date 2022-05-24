package ua.lviv.iot.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.enums.ToolType;

import static org.junit.jupiter.api.Assertions.*;

class HammerTest {

    Hammer hammer = new Hammer("Hammer", "DniproM", ToolType.SOFATOOL, 0, 750);

    @Test
    void setHeadWeightInG() {
        hammer.setHeadWeightInG(1500);
        Assertions.assertEquals(hammer.getHeadWeightInG(), 1500);
    }
}