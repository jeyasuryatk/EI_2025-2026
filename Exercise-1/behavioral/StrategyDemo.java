package behavioral;

interface SlicingStrategy {
    void sliceModel(String model);
}

class MetalSlicing implements SlicingStrategy {
    public void sliceModel(String model) {
        System.out.println("Slicing " + model + " with metal-specific parameters for space-grade durability.");
    }
}

class PolymerSlicing implements SlicingStrategy {
    public void sliceModel(String model) {
        System.out.println("Slicing " + model + " with polymer-specific settings for lightweight satellite parts.");
    }
}

class CeramicSlicing implements SlicingStrategy {
    public void sliceModel(String model) {
        System.out.println("Slicing " + model + " with ceramic-specific settings for thermal shielding.");
    }
}

class Slicer {
    private SlicingStrategy strategy;
    public void setStrategy(SlicingStrategy strategy) {
        this.strategy = strategy;
    }
    public void executeSlice(String model) {
        strategy.sliceModel(model);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        Slicer slicer = new Slicer();

        slicer.setStrategy(new MetalSlicing());
        slicer.executeSlice("Satellite Antenna");

        slicer.setStrategy(new PolymerSlicing());
        slicer.executeSlice("Rover Wheel");

        slicer.setStrategy(new CeramicSlicing());
        slicer.executeSlice("Heat Shield Panel");
    }
}
