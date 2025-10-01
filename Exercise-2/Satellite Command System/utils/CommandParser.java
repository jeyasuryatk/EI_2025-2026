package com.satellite.utils;

import com.satellite.commands.*;
import com.satellite.core.Command;
import java.util.Arrays;
import java.util.List;

public class CommandParser {
    private static final List<String> VALID_DIRECTIONS = Arrays.asList("North", "South", "East", "West");

    public static Command parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            Logger.getInstance().warn("Empty command received.");
            return null;
        }

        String[] parts = input.trim().split("\\s+");
        String command = parts[0].toLowerCase();

        switch (command) {
            case "rotate":
                if (parts.length == 2) {
                    String direction = capitalize(parts[1]);
                    if (VALID_DIRECTIONS.contains(direction)) {
                        return new RotateCommand(direction);
                    } else {
                        Logger.getInstance().warn("Invalid direction: " + direction);
                        return null;
                    }
                } else {
                    Logger.getInstance().warn("Usage: rotate <North|South|East|West>");
                    return null;
                }

            case "activatepanels":
                return new ActivatePanelsCommand();

            case "deactivatepanels":
                return new DeactivatePanelsCommand();

            case "collectdata":
                return new CollectDataCommand();

            default:
                Logger.getInstance().warn("Unknown command: " + input);
                return null;
        }
    }

    private static String capitalize(String word) {
        if (word == null || word.isEmpty()) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}

