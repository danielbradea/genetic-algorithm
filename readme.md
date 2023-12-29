### Genetic Algorithm in Java
This Java project implements a simple genetic algorithm to evolve towards a target string.

## Requirements
- Java 17 or later
- Maven 3.9.1

## Project Structure
- Constants.java: Contains constants used in the genetic algorithm.
- GeneticAlgorithm.java: Main class for running the genetic algorithm.
- Individual.java: Represents an individual in the genetic algorithm with a gene and fitness.
- Population.java: Represents a population of individuals in the genetic algorithm.

## Constants
The 'Constants' class contains the constants used in the genetic algorithm, including the target string, population size, mutation rate, and the set of characters.

## GeneticAlgorithm
The 'GeneticAlgorithm' class serves as the main class for running the genetic algorithm. It initializes a population, evolves it until a solution is found, and prints the best individual's gene at each generation.

## Individual
The 'Individual' class represents an individual in the genetic algorithm. It has a gene, fitness, and methods for crossover and mutation.

## Population
The 'Population' class manages a population of individuals. It initializes the population, checks for a solution, gets the best individual, and evolves the population through crossover and mutation.

## Building and Running with Maven

```cmd
mvn clean install
java -jar target/traveling-salesman-1.0-SNAPSHOT.jar
```

Feel free to customize the city coordinates, add more cities, or adjust simulation parameters in the **App** class to explore different scenarios.



