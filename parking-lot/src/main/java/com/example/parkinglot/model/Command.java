package com.example.parkinglot.model;

import com.example.parkinglot.commons.Constants;
import com.example.parkinglot.exception.InvalidCommandException;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Command {
    private String commandName;
    private List<String> params;

    public Command(final String inputLine) {
        final List<String> tokensList = Arrays.stream(inputLine.trim().split(Constants.SPACE))
                .map(String::trim)
                .filter(token -> (token.length() > 0)).collect(Collectors.toList());

        if (tokensList.size() == 0) {
            throw new InvalidCommandException();
        }

        commandName = tokensList.get(0).toLowerCase();
        tokensList.remove(0);
        params = tokensList;
    }
}
