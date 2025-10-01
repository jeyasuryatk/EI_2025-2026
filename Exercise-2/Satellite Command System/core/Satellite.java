package com.satellite.core;

import com.satellite.utils.Logger;
import java.util.Arrays;
import java.util.List;

public class Satellite {
    private String orientation = "North";
    private boolean panelsActive = false;
    private int dataCollected = 0;

    private static final List<String> VALID_DIRECTIONS = Arrays.asList("North", "South", "East", "West");

    public void rotate(String direction) {
        if (direction == null || direction.isEmpty()) {
            Logger.getInstance().warn("Direction cannot be null or empty.");
            return;
        }
        if (!VALID_DIRECTIONS.contains(direction)) {
            Logger.getInstance().warn("Invalid direction: " + direction);
            return;
        }
        orientation = direction;
        Logger.getInstance().info("Rotated to " + direction);
    }

    public void activatePanels() {
        if (panelsActive) {
            Logger.getInstance().warn("Solar panels are already active.");
        } else {
            panelsActive = true;
            Logger.getInstance().info("Solar panels activated.");
        }
    }

    public void deactivatePanels() {
        if (!panelsActive) {
            Logger.getInstance().warn("Solar panels are already inactive.");
        } else {
            panelsActive = false;
            Logger.getInstance().info("Solar panels deactivated.");
        }
    }

    public void collectData() {
        if (!panelsActive) {
            Logger.getInstance().warn("Cannot collect data. Panels are inactive.");
            return;
        }

        int attempts = 0;
        boolean success = false;

        while (attempts < 3 && !success) {
            try {
                simulateTransientError();
                dataCollected += 10;
                Logger.getInstance().info("Data collected successfully. Total: " + dataCollected);
                success = true;
            } catch (RuntimeException e) {
                Logger.getInstance().warn("Transient error occurred. Retrying... (" + (attempts + 1) + "/3)");
                attempts++;
            }
        }

        if (!success) {
            Logger.getInstance().error("Data collection failed after 3 attempts.");
        }
    }

    private void simulateTransientError() {
        if (Math.random() < 0.3) {
            throw new RuntimeException("Simulated transient error");
        }
    }

    public void printStatus() {
        System.out.println("Orientation: " + orientation);
        System.out.println("Solar Panels: " + (panelsActive ? "Active" : "Inactive"));
        System.out.println("Data Collected: " + dataCollected);
    }
}
