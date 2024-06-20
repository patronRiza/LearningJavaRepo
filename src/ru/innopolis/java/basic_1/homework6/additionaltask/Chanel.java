package ru.innopolis.java.basic_1.homework6.additionaltask;

import java.util.Objects;

public class Chanel {
    private final int chanelNumber;
    private final String chanelName;
    private final Program program;

    public Chanel(int chanelNumber, String chanelName, Program program) {
        this.chanelNumber = chanelNumber;
        this.chanelName = chanelName;
        this.program = program;
    }

    public String getChanelName() {
        return chanelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chanel chanel)) return false;
        return chanelNumber == chanel.chanelNumber && Objects.equals(chanelName, chanel.chanelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chanelNumber, chanelName);
    }

    @Override
    public String toString() {
        return chanelNumber + ". " + chanelName + ", сейчас идет = " + program + "\n";
    }
}
