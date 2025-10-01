package com.satellite.commands;

import com.satellite.core.Command;
import com.satellite.core.Satellite;

public class RotateCommand implements Command {
    private final String direction;

    public RotateCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Satellite satellite) {
        satellite.rotate(direction);
    }
}
