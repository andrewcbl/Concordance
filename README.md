# Concordance

## Introduction
This program is used to create concordance in for a paragraph of sentences. A "concordance" is an alphabetical list of the words present in a text with a count of how often each word appears and citations of where each word appears in the text (e.g., page number). For each word, it prints the count and sorted list of citations. 

## Environment
The program is tested in both Windows and Linux. On Windows, it is tested with Intellij. And on Linux, it runs with Maven 3.3.3. 

## Usage (Linux)
Step1: compile the code: <br/>
mvn compile

Step2: Package the code:<br/>
mvn package

Step3: Run the program, put your input text in a file, e.g. test.txt, run the following command:<br/>
java -jar target/concordance-1.0-SNAPSHOT.jar < test.txt
