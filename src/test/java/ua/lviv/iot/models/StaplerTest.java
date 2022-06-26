package ua.lviv.iot.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.enums.ToolType;

import static org.junit.jupiter.api.Assertions.*;

class StaplerTest {

    Stapler stapler = new Stapler("Stapler", "Makita", ToolType.SOFATOOL, 150, 75);

    @Test
    void setNumberOfBrackets() {
        stapler.setNumberOfBrackets(100);
        Assertions.assertEquals(stapler.getNumberOfBrackets(), 100);
    }
}