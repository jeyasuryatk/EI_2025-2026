package creational;

import java.util.HashMap;
import java.util.Map;

// Singleton class
class PrinterConfig {
    private static PrinterConfig instance;
    private Map<String, String> settings = new HashMap<>();

    // Private constructor to prevent instantiation
    private PrinterConfig() {
        System.out.println("🛠️ Initializing global printer configuration...");
    }

    // Global access point
    public static synchronized PrinterConfig getInstance() {
        if (instance == null) {
            instance = new PrinterConfig();
        }
        return instance;
    }

    public void set(String key, String value) {
        settings.put(key, value);
        System.out.println("🔧 Config set: " + key + " = " + value);
    }

    public String get(String key) {
        return settings.getOrDefault(key, "Not configured");
    }
}

// Demo
public class SingletonDemo {
    public static void main(String[] args) {
        PrinterConfig config = PrinterConfig.getInstance();
        config.set("layerHeight", "0.1mm");
        config.set("material", "Titanium Alloy");
        config.set("printSpeed", "60mm/s");

        System.out.println("📋 Current Settings:");
        System.out.println("Layer Height: " + config.get("layerHeight"));
        System.out.println("Material: " + config.get("material"));
        System.out.println("Print Speed: " + config.get("printSpeed"));
    }
}
