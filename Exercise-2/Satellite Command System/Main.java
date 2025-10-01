package com.satellite;

import com.satellite.core.*;
import com.satellite.utils.CommandParser;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SatelliteController controller = new SatelliteController();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        List<Command> history = new ArrayList<>();

        System.out.println("🛰️ Satellite Command Console");
        System.out.println("Type commands like: rotate South, activatePanels, collectData");
        System.out.println("Type 'help' for available commands, 'undo' to revert last command, 'exit' to quit.\n");

        while (isRunning) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "exit":
                    isRunning = false;
                    System.out.println("Shutting down satellite console...");
                    break;

                case "help":
                    System.out.println("Available commands:");
                    System.out.println("  rotate <North|South|East|West>");
                    System.out.println("  activatePanels");
                    System.out.println("  deactivatePanels");
                    System.out.println("  collectData");
                    System.out.println("  undo");
                    System.out.println("  exit");
                    break;

                case "undo":
                    if (!history.isEmpty()) {
                        System.out.println("Undoing last command...");
                        history.remove(history.size() - 1);
                        controller.resetSatellite(); // Reset to initial state
                        for (Command cmd : history) {
                            controller.executeCommand(cmd); // Replay remaining commands
                        }
                    } else {
                        System.out.println("No commands to undo.");
                    }
                    break;

                default:
                    Command command = CommandParser.parse(input);
                    if (command != null) {
                        history.add(command);
                        controller.executeCommand(command);
                    }
                    break;
            }
        }

        System.out.println("\nFinal Satellite Status:");
        controller.executeCommand(s -> s.printStatus());
    }
}
