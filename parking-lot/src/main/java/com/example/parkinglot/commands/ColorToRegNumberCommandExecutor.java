package com.example.parkinglot.commands;

import com.example.parkinglot.commons.OutputPrinter;
import com.example.parkinglot.model.Command;
import com.example.parkinglot.model.Slot;
import com.example.parkinglot.service.ParkingLotService;

import java.util.List;
import java.util.stream.Collectors;

public class ColorToRegNumberCommandExecutor extends CommandExecutor {

    public static String COMMAND_NAME = "registration_numbers_for_cars_with_colour";

    public ColorToRegNumberCommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        final List<Slot> slotsForColor = parkingLotService.getSlotsForColor(command.getParams().get(0));
        if (slotsForColor.isEmpty()) {
            outputPrinter.notFound();
        } else {
            final String result = slotsForColor.stream()
                            .map(slot -> slot.getParkedCar().getRegistrationNumber())
                            .collect(Collectors.joining(", "));
            outputPrinter.printWithNewLine(result);
        }
    }
}
