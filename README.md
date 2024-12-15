# Voynich Manuscript Text Analysis

This project analyzes ciphertext from the Voynich Manuscript (or similar encrypted texts) by detecting possible characters and words using dictionary-based methods. It compares words from the manuscript against Latin, Malay, and Proto-Romance dictionaries. Additionally, it supports brute-force attacks to uncover valid words through permutation generation.

## Overview

1. Extracts unique characters from the ciphertext.
2. Matches words against three dictionaries: Latin, Malay, and Proto-Romance.
3. Performs brute-force attacks to identify potential valid words.
4. Provides detailed output for matched words from each dictionary.

##Installation
1. Set up your development environment:
 -This project was developed using IntelliJ IDEA, a powerful IDE for Java development.
2. Language Selection:
 -The project analyzes text in three languages: Latin, Malay, and Proto-Romance. These languages were selected based on the manuscript's content and the need for language comparison.
3. Dictionary Setup:
 -To facilitate word matching, dictionaries for Latin, Malay, and Proto-Romance were sourced and added to the project.
 -Words for each language were generated with the assistance of ChatGPT, ensuring a comprehensive dictionary for analysis.
4. Run the Project:
 -Download or clone this repository.
 -Open the project in IntelliJ IDEA.
 -Run the program to analyze the input text against the dictionaries.


## Usage

To use this project, make sure you meet the following prerequisites:

1. Java and IDE Requirements:
   - Ensure you have a newer version of Java (preferably Java 11 or higher).
   - Use an IDE like IntelliJ IDEA (preferable for Java development) or any other suitable Java development environment.

2. Dictionary Files:
   - The project requires plaintext dictionary files for Latin, Malay, and Proto-Romance. Each dictionary should contain one word per line.
   - You can download these dictionaries or create your own based on the language you're analyzing.

3. Running the Project:
   - Clone or download the repository to your local machine.
   - Open the project in your IDE (e.g., IntelliJ IDEA).
   - Ensure the dictionary files are correctly placed in the project directory.
   - Run the `VoynichProcessor` class to analyze the text file against the language dictionaries.
   - The output will list any matched words from the dictionaries.

4. Adjusting for Your Own Text:
   - You can replace the input file path (e.g., `testtext`) with your own text file containing the content you wish to analyze.

## Contribution 
This project was developed with the support of Professor Joe Oakes. Special thanks to him for providing important information and help during the whole process.

## Credits/Sources 
1. Yale University- Providing the manuscrpit.
2. Professor Joe Oakes- Provided help to me the whole time.
3. Wiktionary/Chatgpt- Provided the dictionaries 









