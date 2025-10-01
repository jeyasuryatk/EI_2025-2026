package com.satellite.commands;

import com.satellite.core.Command;
import com.satellite.core.Satellite;

public class ActivatePanelsCommand implements Command {
    @Override
    public void execute(Satellite satellite) {
        satellite.activatePanels();
    }
}
