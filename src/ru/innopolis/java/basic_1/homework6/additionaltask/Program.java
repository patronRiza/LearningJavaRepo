package ru.innopolis.java.basic_1.homework6.additionaltask;

import java.util.Objects;

public class Program {
    private final String programName;
    private final double programRating;
    private final int numViewers;

    public Program(String programName, double programRating, int numViewers) {
        this.programName = programName;
        this.programRating = programRating;
        this.numViewers = numViewers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Program program)) return false;
        return Objects.equals(programName, program.programName) && Objects.equals(programRating, program.programRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programName, programRating);
    }

    @Override
    public String toString() {
        return programName + "\n\t\t" +
                "Рейтинг программы = " + programRating +
                "\n\t\tЧисло зрителей = " + numViewers;
    }
}
