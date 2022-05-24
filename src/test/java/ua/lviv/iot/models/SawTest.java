package ua.lviv.iot.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.enums.ToolType;

import static org.junit.jupiter.api.Assertions.*;

class SawTest {

    Saw saw = new Saw("Druzhba 2", "Bosch", ToolType.CHAIRTOOL, 500, 80);

    @Test
    void setLengthInSm() {
        saw.setLengthInSm(120);
        Assertions.assertEquals(saw.getLengthInSm(), 120);
    }
}