
# Project Title

A brief description of what this project does 
# Design Patterns in Java

A modular Java project demonstrating six core design patterns—Strategy, Observer, Factory, Singleton, Decorator, and Adapter—contextualized for aerospace-grade 3D printing. Built for educational clarity, maintainability, and real-world relevance.

---

## 👨‍💻 Project Structure

src/
├── behavioral/
│   ├── StrategyDemo.java
│   └── ObserverDemo.java
├── creational/
│   ├── FactoryDemo.java
│   └── SingletonDemo.java
├── structural/
│   ├── DecoratorDemo.java
│   └── AdapterDemo.java




---


---

## 🎯 Design Patterns Overview

| Pattern Type   | Pattern        | Space Domain Use Case                                      |
|----------------|----------------|-------------------------------------------------------------|
| Behavioral     | Strategy       | Slicing strategy for space-grade materials                 |
| Behavioral     | Observer       | Monitoring thermal, vibration, and layer integrity         |
| Creational     | Factory        | Generating printable components (antenna, wheel, panel)    |
| Creational     | Singleton      | Global printer configuration manager                       |
| Structural     | Decorator      | Enhancing print jobs with heat resistance, UV coating      |
| Structural     | Adapter        | Integrating legacy CAD formats into STL pipeline           |

---

## 🧪 How to Run

### Compile All
```bash
javac src/**/*.java

Run Individually
java behavioral.StrategyDemo
java behavioral.ObserverDemo
java creational.FactoryDemo
java creational.SingletonDemo
java structural.DecoratorDemo
java structural.AdapterDemo

---

