package ua.lviv.iot.models;

import ua.lviv.iot.enums.ToolType;

public class Saw extends AbstractTool {
    private float lengthInSm;

    public Saw(String name, String producer, ToolType toolType, int powerConsumption, float lengthInSm) {
        super(name, producer, toolType, powerConsumption);
        this.lengthInSm = lengthInSm;
    }

    public float getLengthInSm() {
        return lengthInSm;
    }

    public void setLengthInSm(float lengthInSm) {
        this.lengthInSm = lengthInSm;
    }
}
