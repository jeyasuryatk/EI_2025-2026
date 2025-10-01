package com.satellite.core;

import com.satellite.utils.Logger;
import java.util.List;

public class SatelliteController {
    Satellite satellite = new Satellite();

    public void executeCommand(Command cmd) {
        try {
            cmd.execute(satellite);
        } catch (Exception e) {
            Logger.getInstance().error("Command execution failed: " + e.getMessage());
        }
    }

    public void resetSatellite() {
        this.satellite = new Satellite();
    }
}
