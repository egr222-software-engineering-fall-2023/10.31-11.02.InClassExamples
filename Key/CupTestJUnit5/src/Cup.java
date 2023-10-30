public class Cup {
    private String liquidType;
    private double percentFull;

    public Cup(String liquidType, double percentFull) {
        this.liquidType = liquidType;
        this.percentFull = percentFull;
    }

    public String getLiquidType() {
        return liquidType;
    }

    public double getPercentFull() {
        return percentFull;
    }

    public void setLiquidType(String liquidType) {
        if (liquidType == null) {
            return;
        }
        this.liquidType = liquidType;
    }

    public boolean isEmpty() {
        return this.percentFull == 0;
    }

    public void setPercentFull(double percentFull) {
        if (percentFull < 0 || percentFull > 100) {
            throw new IllegalArgumentException("percentFull must be >=0 and <= 100");
        }
        this.percentFull = percentFull;
    }
}