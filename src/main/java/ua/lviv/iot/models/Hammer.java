package ua.lviv.iot.models;

import ua.lviv.iot.enums.ToolType;

public class Hammer extends AbstractTool {

    private float headWeightInG;

    public Hammer(String name, String producer, ToolType toolType, int powerConsumption, float headWeightInG) {
        super(name, producer, toolType, powerConsumption);
        this.headWeightInG = headWeightInG;
    }

    public String getHeaders() {
        return super.getHeaders() + ",headWeightInG";
    }

    public String toCSV() {
        return super.toCSV() + "," + headWeightInG;

    }

    public float getHeadWeightInG() {
        return headWeightInG;
    }

    public void setHeadWeightInG(float headWeightInG) {
        this.headWeightInG = headWeightInG;
    }
}
