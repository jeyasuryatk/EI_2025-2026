
# Project Title

A brief description of what this project does and who it's for
# 🛰️ Satellite Command System

A modular, extensible Java console application that simulates satellite operations using clean architecture and design patterns. Built for educational and aerospace contexts, this system demonstrates SOLID principles, robust logging, transient error handling, and interactive command execution.

---

## 📌 Overview

This project allows users to control a satellite via a command-line interface. Users can rotate the satellite, activate/deactivate solar panels, and collect data. Each command is encapsulated using the Command Pattern, ensuring flexibility and maintainability.

---

## ✨ Features

- ✅ Rotate satellite to cardinal directions (North, South, East, West)
- ✅ Activate/deactivate solar panels with state validation
- ✅ Collect data with transient error retry logic
- ✅ Singleton-based structured logging with timestamps and severity levels
- ✅ Interactive CLI with help and undo functionality
- ✅ Input validation and graceful error handling
- ✅ Easily extensible for new commands and behaviors

---

## 🧩 Key Components

| Component              | Description                                      |
|------------------------|--------------------------------------------------|
| `Satellite`            | Maintains orientation, panel state, and data     |
| `Command` Interface    | Base for all executable commands                 |
| `RotateCommand`        | Rotates the satellite                            |
| `ActivatePanelsCommand`| Activates solar panels                           |
| `DeactivatePanelsCommand`| Deactivates solar panels                     |
| `CollectDataCommand`   | Collects data with retry logic                   |
| `SatelliteController`  | Executes commands and manages satellite state    |
| `Logger`               | Singleton logger for structured output           |
| `CommandParser`        | Parses user input into command objects           |
| `Main`                 | Entry point with interactive CLI                 |

---

## 🧠 Design Patterns Used

- **Command Pattern**: Encapsulates operations as objects
- **Singleton Pattern**: Centralized logging via `Logger`
- **Factory Logic**: Input parsing and command instantiation
- **Decorator/Strategy Ready**: Extendable for telemetry, retries, or alternate behaviors

---

## 🧱 OOP Principles

- **Encapsulation**: Satellite state is private and accessed via methods
- **Abstraction**: Commands abstract away execution logic
- **Polymorphism**: All commands implement the same interface
- **SOLID Principles**: Each class has a single responsibility and is open for extension

---

## 💻 Example Usage 

```bash
> rotate South
> activatePanels
> collectData
> deactivatePanels
> collectData
> undo
> help
> exit

**Sample Output**
🛰️ Satellite Command Console
Type commands like: rotate South, activatePanels, collectData
Type 'help' for available commands, 'undo' to revert last command, 'exit' to quit.

> rotate North
[2025-10-02 01:03:44] [INFO] Rotated to North
> activatePanels
[2025-10-02 01:03:54] [INFO] Solar panels activated.
> collectData
[2025-10-02 01:04:07] [INFO] Data collected successfully. Total: 10
> rotate East
[2025-10-02 01:04:21] [INFO] Rotated to East
> activatePanels
[2025-10-02 01:04:38] [WARN] Solar panels are already active.
> collectData
[2025-10-02 01:04:52] [INFO] Data collected successfully. Total: 20
> collectData
[2025-10-02 01:04:59] [WARN] Transient error occurred. Retrying... (1/3)
[2025-10-02 01:04:59] [INFO] Data collected successfully. Total: 30
> collectData
[2025-10-02 01:05:11] [INFO] Data collected successfully. Total: 40
> rotate West
[2025-10-02 01:05:30] [INFO] Rotated to West
> undo

Undoing last command...
[2025-10-02 01:05:56] [INFO] Rotated to North
[2025-10-02 01:05:56] [INFO] Solar panels activated.
[2025-10-02 01:05:56] [INFO] Data collected successfully. Total: 10
[2025-10-02 01:05:56] [INFO] Rotated to East
[2025-10-02 01:05:56] [WARN] Solar panels are already active.
[2025-10-02 01:05:56] [INFO] Data collected successfully. Total: 20
[2025-10-02 01:05:56] [WARN] Transient error occurred. Retrying... (1/3)
[2025-10-02 01:05:56] [INFO] Data collected successfully. Total: 30
[2025-10-02 01:05:56] [INFO] Data collected successfully. Total: 40
> help
Available commands:
  rotate <North|South|East|West>
  activatePanels
  deactivatePanels
  collectData
  undo
  exit
> collectData
[2025-10-02 01:06:23] [INFO] Data collected successfully. Total: 50
> exit
Shutting down satellite console...

Final Satellite Status:
Orientation: East
Solar Panels: Active
Data Collected: 50



**Code Structure**

SatelliteCommandSystem/
└── src/
    └── com/satellite/
        ├── Main.java
        ├── core/
        │   ├── Satellite.java
        │   ├── Command.java
        │   └── SatelliteController.java
        ├── commands/
        │   ├── RotateCommand.java
        │   ├── ActivatePanelsCommand.java
        │   ├── DeactivatePanelsCommand.java
        │   └── CollectDataCommand.java
        └── utils/
            ├── Logger.java
            └── CommandParser.java




