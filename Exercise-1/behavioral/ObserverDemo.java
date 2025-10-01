package behavioral;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String status);
}

// Concrete Observers
class ThermalMonitor implements Observer {
    public void update(String status) {
        System.out.println("🔴 Thermal Monitor: " + status);
    }
}

class VibrationMonitor implements Observer {
    public void update(String status) {
        System.out.println("🔵 Vibration Monitor: " + status);
    }
}

class LayerIntegrityMonitor implements Observer {
    public void update(String status) {
        System.out.println("🟢 Layer Integrity Monitor: " + status);
    }
}

// Subject
class SpacePrinter {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyAll(String status) {
        for (Observer o : observers) {
            o.update(status);
        }
    }

    public void printLayer(int layerNumber) {
        System.out.println("🖨️ Printing layer " + layerNumber + "...");
        notifyAll("Layer " + layerNumber + " printed successfully.");
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        SpacePrinter printer = new SpacePrinter();

        Observer thermal = new ThermalMonitor();
        Observer vibration = new VibrationMonitor();
        Observer integrity = new LayerIntegrityMonitor();

        printer.attach(thermal);
        printer.attach(vibration);
        printer.attach(integrity);

        printer.printLayer(1);
        printer.printLayer(2);
    }
}
