package com.bid90.geneticAlgorithm;

import java.util.Arrays;
import java.util.Random;


/**
 * Represents a population of individuals in the genetic algorithm.
 */
public class Population {

    // Array to store individuals in the population.
    private Individual[] individuals;

    /**
     * Constructs a population with an array of individuals.
     */
    public Population() {
        this.individuals = new Individual[Constants.POPULATION_SIZE];
    }

    /**
     * Initializes the population by creating individuals with random genes.
     */
    public void initialize() {
        for (int i = 0; i < individuals.length; i++) {
            individuals[i] = new Individual();
        }
    }

    /**
     * Gets the array of individuals in the population.
     *
     * @return The array of individuals.
     */
    public Individual[] getIndividuals() {
        return individuals;
    }

    /**
     * Checks if a solution has been found in the population.
     *
     * @return True if a solution is found (fitness equal to the target length) in any individual.
     */
    public boolean isSolutionFound() {
        for (Individual individual : individuals) {
            if (individual.getFitness() == Constants.TARGET.length()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the best individual in the population based on fitness.
     *
     * @return The individual with the highest fitness in the population.
     */
    public Individual getBestIndividual() {
        Arrays.sort(individuals, (a, b) -> Integer.compare(b.getFitness(), a.getFitness()));
        return individuals[0];
    }

    /**
     * Evolves the population to the next generation using crossover and mutation.
     */
    public void evolve() {
        Individual[] newGeneration = new Individual[Constants.POPULATION_SIZE];
        for (int i = 0; i < Constants.POPULATION_SIZE; i++) {
            Individual parent1 = selectParent();
            Individual parent2 = selectParent();
            Individual child = parent1.crossover(parent2);
            child.mutate();
            newGeneration[i] = child;
        }
        individuals = newGeneration;
    }

    /**
     * Selects a parent for crossover using a tournament selection approach.
     *
     * @return The selected parent based on tournament selection.
     */
    private Individual selectParent() {
        int tournamentSize = 5;
        Individual[] tournament = new Individual[tournamentSize];
        for (int i = 0; i < tournamentSize; i++) {
            tournament[i] = individuals[new Random().nextInt(Constants.POPULATION_SIZE)];
        }
        Arrays.sort(tournament, (a, b) -> Integer.compare(b.getFitness(), a.getFitness()));
        return tournament[0];
    }
}
