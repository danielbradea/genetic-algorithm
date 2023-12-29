package com.bid90.geneticAlgorithm;

/**
 * The main class for running the genetic algorithm.
 */
public class GeneticAlgorithm {

    /**
     * The main method that initializes a population, evolves it until a solution is found,
     * and prints the best individual's gene at each generation.
     *
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create a new population
        Population population = new Population();

        // Initialize the population with random individuals
        population.initialize();

        // Track the generation number
        int generation = 1;

        // Continue evolving the population until a solution is found
        while (!population.isSolutionFound()) {
            // Evolve the population to the next generation
            population.evolve();

            // Increment the generation counter
            generation++;

            // Print information about the current generation and the best individual's gene
            System.out.println("Generation " + generation + ": " + population.getBestIndividual().getGene());
        }

        // Print the solution generation and the gene of the best individual
        System.out.println("Solution " + generation + ": " + population.getBestIndividual().getGene());
    }
}
