package ua.lviv.iot.models;

import ua.lviv.iot.enums.ToolType;

public class AbstractTool {
    private String name;
    private String producer;
    private ToolType toolType;
    private int powerConsumption;

    public AbstractTool(String name, String producer, ToolType toolType, int powerConsumption) {
        this.name = name;
        this.producer = producer;
        this.toolType = toolType;
        this.powerConsumption = powerConsumption;
    }

    public String getHeaders() {
        return "name,producer,toolType,powerConsumption";
    }

    public String toCSV() {
        return name + "," + producer + "," + toolType + "," + powerConsumption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

}
