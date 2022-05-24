package ua.lviv.iot.models;

import ua.lviv.iot.enums.ToolType;

public class Stapler extends AbstractTool {
    private int numberOfBrackets;

    public Stapler(String name, String producer, ToolType toolType, int powerConsumption, int numberOfBrackets) {
        super(name, producer, toolType, powerConsumption);
        this.numberOfBrackets = numberOfBrackets;
    }

    public String getHeaders() {
        return super.getHeaders() + ",numberOfBrackets";
    }

    public String toCSV() {
        return super.toCSV() + "," + numberOfBrackets;

    }

    public int getNumberOfBrackets() {
        return numberOfBrackets;
    }

    public void setNumberOfBrackets(int numberOfBrackets) {
        this.numberOfBrackets = numberOfBrackets;
    }
}
