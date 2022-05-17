package ua.lviv.iot.models;

import ua.lviv.iot.enums.ToolType;

public class Drill extends AbstractTool{

    private int cartridgeDiameterInMm;
    private int maxRPM;

    public Drill(String name, String producer, ToolType toolType, int powerConsumption, int cartridgeDiameterInSm, int maxRPM) {
        super(name, producer, toolType, powerConsumption);
        this.cartridgeDiameterInMm = cartridgeDiameterInSm;
        this.maxRPM = maxRPM;
    }

    public int getCartridgeDiameterInSm() {
        return cartridgeDiameterInMm;
    }

    public void setCartridgeDiameterInSm(int cartridgeDiameterInSm) {
        this.cartridgeDiameterInMm = cartridgeDiameterInSm;
    }

    public int getMaxRPM() {
        return maxRPM;
    }

    public void setMaxRPM(int maxRPM) {
        this.maxRPM = maxRPM;
    }
}
