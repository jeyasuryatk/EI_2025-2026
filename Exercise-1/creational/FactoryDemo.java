package creational;

// Product interface
interface SpaceComponent {
    void print();
}

// Concrete Products
class Antenna implements SpaceComponent {
    public void print() {
        System.out.println("🛰️ Printing satellite antenna for orbital communication...");
    }
}

class RoverWheel implements SpaceComponent {
    public void print() {
        System.out.println("🚙 Printing rover wheel for Martian terrain navigation...");
    }
}

class HabitatPanel implements SpaceComponent {
    public void print() {
        System.out.println("🏠 Printing lunar habitat panel with thermal insulation...");
    }
}

// Factory
class ComponentFactory {
    public static SpaceComponent create(String type) {
        return switch (type.toLowerCase()) {
            case "antenna" -> new Antenna();
            case "wheel" -> new RoverWheel();
            case "panel" -> new HabitatPanel();
            default -> throw new IllegalArgumentException("Unknown component type: " + type);
        };
    }
}

// Demo
public class FactoryDemo {
    public static void main(String[] args) {
        SpaceComponent c1 = ComponentFactory.create("antenna");
        SpaceComponent c2 = ComponentFactory.create("wheel");
        SpaceComponent c3 = ComponentFactory.create("panel");

        c1.print();
        c2.print();
        c3.print();
    }
}
