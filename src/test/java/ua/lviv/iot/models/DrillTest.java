package ua.lviv.iot.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.enums.ToolType;

import static org.junit.jupiter.api.Assertions.*;

class DrillTest {

    Drill drill = new Drill("Drill", "DeWalt", ToolType.CHAIRTOOL, 1500, 16, 2500);

    @Test
    void setCartridgeDiameterInSm() {

        drill.setCartridgeDiameterInSm(50);
        Assertions.assertEquals(drill.getCartridgeDiameterInSm(), 50);
    }

    @Test
    void setMaxRPM() {
        drill.setMaxRPM(1500);
        Assertions.assertEquals(drill.getMaxRPM(), 1500);
    }
}