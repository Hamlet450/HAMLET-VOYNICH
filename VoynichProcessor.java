/**
 * Project: Voynich Manuscript Text Analysis
 * Purpose: Analyze ciphertext and detect possible characters and words using a dictionary.
 * Course: IST 242
 * Author: Hamlet Baghdasaryan
 * Date Developed: 12/12/2024
 * Last Date Changed: 12/14/2024
 * Revision: 1.0
 */

import java.io.*;
import java.util.*;

public class VoynichProcessor {

    public static void main(String[] args) {
        String filePath = "textfile"; // Path to input text
        System.out.println("Processing Voynich Manuscript Text...");

        try {
            List<String> lines = readTextFile(filePath);
            System.out.println("\nRaw Text from File:");
            for (String line : lines) {
                System.out.println(line);
            }

            // Analyze the text to detect words or characters
            Set<String> uniqueCharacters = extractUniqueCharacters(lines);
            System.out.println("\nUnique Characters Detected:");
            System.out.println(uniqueCharacters);

            // Optional: Compare against domain dictionary
            analyzeWithDictionary(lines, "latin_dictionary.txt", "latin");
            analyzeWithDictionary(lines, "malay_dictionary.txt", "malay");
            analyzeWithDictionary(lines, "proto_romance_dictionary.txt", "proto-romance");

            // Optional: Perform brute force attack for words
            performBruteForceAttack(lines, "latin_dictionary.txt"); // Adjust as necessary

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Reads the input file and returns a list of strings (lines).
     */
    public static List<String> readTextFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    /**
     * Extracts unique characters from all lines.
     */
    public static Set<String> extractUniqueCharacters(List<String> lines) {
        Set<String> uniqueChars = new HashSet<>();
        for (String line : lines) {
            for (char c : line.toCharArray()) {
                if (!Character.isWhitespace(c)) {
                    uniqueChars.add(String.valueOf(c));
                }
            }
        }
        return uniqueChars;
    }

    /**
     * Analyzes the text and matches words against a domain-specific dictionary.
     */
    public static void analyzeWithDictionary(List<String> lines, String dictionaryPath, String language) {
        try {
            Set<String> dictionary = loadDictionary(dictionaryPath);
            System.out.println("\nAnalyzing words against " + language + " dictionary...");
            for (String line : lines) {
                String[] words = line.split("\\.|\\s+|\\-|\\{|\\}");
                for (String word : words) {
                    word = word.trim(); // Trim whitespace
                    if (!word.isEmpty() && dictionary.contains(word)) { // Ensure word is not empty
                        System.out.println("Matched word from " + language + ": " + word);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading dictionary: " + e.getMessage());
        }
    }

    /**
     * Loads dictionary words into a set.
     */
    public static Set<String> loadDictionary(String dictionaryPath) throws IOException {
        Set<String> dictionary = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dictionaryPath))) {
            String word;
            while ((word = br.readLine()) != null) {
                dictionary.add(word.trim());
            }
        }
        return dictionary;
    }

    /**
     * Perform brute-force attack to find matches in the Latin dictionary.
     */
    public static void performBruteForceAttack(List<String> lines, String dictionaryPath) {
        try {
            Set<String> dictionary = loadDictionary(dictionaryPath);
            System.out.println("\nPerforming brute-force attack on words...");
            for (String line : lines) {
                String[] words = line.split("\\.|\\s+|\\-|\\{|\\}");
                for (String word : words) {
                    word = word.trim(); // Trim whitespace
                    if (!word.isEmpty() && bruteForceMatch(word, dictionary)) { // Check if not empty before brute-force matching
                        System.out.println("Brute force match found: " + word);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading dictionary for brute force: " + e.getMessage());
        }
    }

    /**
     * Brute-force match for each word, with optimized permutation generation.
     */
    public static boolean bruteForceMatch(String word, Set<String> dictionary) {
        // Limit the length of permutations to avoid excessive memory usage
        int maxLength = 5; // Maximum length of words to generate permutations for

        // Generate all possible permutations up to the word's length but not exceeding maxLength
        for (int len = 1; len <= Math.min(word.length(), maxLength); len++) {
            List<String> permutations = generatePermutations(word, len);
            for (String perm : permutations) {
                if (dictionary.contains(perm)) {
                    System.out.println("Brute force match found: " + perm);
                    return true; // Match found
                }
            }
        }
        return false; // No match found
    }

    /**
     * Generate permutations for a given word up to a certain length.
     */
    public static List<String> generatePermutations(String word, int length) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsHelper("", word, length, permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(String prefix, String word, int length, List<String> permutations) {
        if (prefix.length() == length) {
            permutations.add(prefix);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            generatePermutationsHelper(prefix + word.charAt(i), word, length, permutations);
        }
    }
}
