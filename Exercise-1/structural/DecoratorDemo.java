package structural;

// Component interface
interface PrintJob {
    String getDescription();
    double getCost();
}

// Concrete component
class BasicPrint implements PrintJob {
    public String getDescription() {
        return "Basic 3D Print";
    }

    public double getCost() {
        return 100.0;
    }
}

// Abstract decorator
abstract class PrintDecorator implements PrintJob {
    protected PrintJob job;

    public PrintDecorator(PrintJob job) {
        this.job = job;
    }
}

// Concrete decorators
class HeatResistant extends PrintDecorator {
    public HeatResistant(PrintJob job) {
        super(job);
    }

    public String getDescription() {
        return job.getDescription() + ", Heat Resistant";
    }

    public double getCost() {
        return job.getCost() + 30.0;
    }
}

class UVCoated extends PrintDecorator {
    public UVCoated(PrintJob job) {
        super(job);
    }

    public String getDescription() {
        return job.getDescription() + ", UV Coated";
    }

    public double getCost() {
        return job.getCost() + 20.0;
    }
}

class ReinforcedStructure extends PrintDecorator {
    public ReinforcedStructure(PrintJob job) {
        super(job);
    }

    public String getDescription() {
        return job.getDescription() + ", Reinforced Structure";
    }

    public double getCost() {
        return job.getCost() + 50.0;
    }
}

// Demo
public class DecoratorDemo {
    public static void main(String[] args) {
        PrintJob job = new ReinforcedStructure(
                new UVCoated(
                        new HeatResistant(
                                new BasicPrint()
                        )
                )
        );

        System.out.println("🧾 Description: " + job.getDescription());
        System.out.println("💰 Total Cost: $" + job.getCost());
    }
}
