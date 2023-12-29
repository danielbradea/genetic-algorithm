package com.bid90.geneticAlgorithm;

/**
 * This class contains constants used in the application.
 */
public class Constants {

    /**
     * Represents the target string that the genetic algorithm aims to evolve towards.
     */
    public static final String TARGET = "Hello World";

    /**
     * Represents the size of the population used in the genetic algorithm.
     */
    public static final int POPULATION_SIZE = 100;

    /**
     * Represents the mutation rate used in the genetic algorithm.
     * This is the probability that a mutation will occur during the evolution process.
     */
    public static final double MUTATION_RATE = 0.01;

    /**
     * Represents the set of characters that can be used in the genetic algorithm.
     * This includes digits, lowercase and uppercase letters, and a space character.
     */
    public static final String CHARACTERS = "0123456789 abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
}
