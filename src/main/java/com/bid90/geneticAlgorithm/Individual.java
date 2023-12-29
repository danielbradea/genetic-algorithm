package com.bid90.geneticAlgorithm;

import java.util.Random;
;

/**
 * Represents an individual in the genetic algorithm with a gene and fitness.
 */
public class Individual {

    // Gene represents the genetic code of an individual.
    private String gene;

    // Fitness represents how well the gene matches the target string.
    private int fitness;

    /**
     * Constructs an individual with the specified gene and calculates its fitness.
     *
     * @param gene The genetic code of the individual.
     */
    public Individual(String gene) {
        this.gene = gene;
        calculateFitness();
    }

    /**
     * Constructs an individual with a randomly generated gene and calculates its fitness.
     */
    public Individual() {
        this.gene = generateRandomGene();
        calculateFitness();
    }

    /**
     * Gets the gene of the individual.
     *
     * @return The genetic code of the individual.
     */
    public String getGene() {
        return gene;
    }

    /**
     * Gets the fitness of the individual.
     *
     * @return The fitness value indicating how well the gene matches the target string.
     */
    public int getFitness() {
        return fitness;
    }

    /**
     * Generates a random gene using characters from the predefined set of characters.
     *
     * @return A randomly generated gene.
     */
    private String generateRandomGene() {
        Random random = new Random();
        char[] geneArray = new char[Constants.TARGET.length()];
        for (int i = 0; i < Constants.TARGET.length(); i++) {
            var rand = random.nextInt(Constants.CHARACTERS.length());
            geneArray[i] = Constants.CHARACTERS.charAt(rand);
        }
        return new String(geneArray);
    }

    /**
     * Calculates the fitness of the individual by comparing its gene to the target string.
     */
    private void calculateFitness() {
        fitness = 0;
        for (int i = 0; i < gene.length(); i++) {
            if (gene.charAt(i) == Constants.TARGET.charAt(i)) {
                fitness++;
            }
        }
    }

    /**
     * Creates a new individual through crossover with another individual.
     *
     * @param partner The individual to perform crossover with.
     * @return A new individual resulting from crossover.
     */
    public Individual crossover(Individual partner) {
        int splitPoint = new Random().nextInt(gene.length());
        String childGene = gene.substring(0, splitPoint) + partner.getGene().substring(splitPoint);
        return new Individual(childGene);
    }

    /**
     * Mutates the individual's gene by randomly changing characters based on the mutation rate.
     */
    public void mutate() {
        char[] geneArray = gene.toCharArray();
        for (int i = 0; i < geneArray.length; i++) {
            if (Math.random() < Constants.MUTATION_RATE) {
                geneArray[i] = Constants.CHARACTERS.charAt(new Random().nextInt(Constants.CHARACTERS.length()));
            }
        }
        gene = new String(geneArray);
    }

    /**
     * Returns a string representation of the individual in the format: "('gene'->fitness)".
     *
     * @return A string representation of the individual.
     */
    @Override
    public String toString() {
        return "('" + gene + "'->" + fitness + ")";
    }
}
