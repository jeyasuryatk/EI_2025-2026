package structural;

// Target interface
interface STLPrinter {
    void printSTL(String file);
}

// Adaptee interface
interface LegacyCAD {
    void printOBJ(String file);
    void printSTEP(String file);
}

// Concrete Adaptee
class LegacyCADSystem implements LegacyCAD {
    public void printOBJ(String file) {
        System.out.println("🧱 Converting and printing OBJ file: " + file);
    }

    public void printSTEP(String file) {
        System.out.println("📐 Converting and printing STEP file: " + file);
    }
}

// Adapter
class LegacyAdapter implements STLPrinter {
    private LegacyCAD legacy;

    public LegacyAdapter(LegacyCAD legacy) {
        this.legacy = legacy;
    }

    public void printSTL(String file) {
        if (file.endsWith(".obj")) {
            legacy.printOBJ(file);
        } else if (file.endsWith(".step")) {
            legacy.printSTEP(file);
        } else {
            System.out.println("❌ Unsupported format: " + file);
        }
    }
}

// Modern Printer
class ModernPrinter implements STLPrinter {
    public void printSTL(String file) {
        System.out.println("🖨️ Printing STL file: " + file);
    }
}

// Demo
public class AdapterDemo {
    public static void main(String[] args) {
        STLPrinter printer = new ModernPrinter();
        printer.printSTL("satellite_mount.stl");

        STLPrinter legacyAdapter = new LegacyAdapter(new LegacyCADSystem());
        legacyAdapter.printSTL("antenna.obj");
        legacyAdapter.printSTL("housing.step");
        legacyAdapter.printSTL("unknown.txt");
    }
}
