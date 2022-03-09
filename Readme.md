# Simple Search Engine

The project implements a search engine for the submitted documents.

The current implementation consists on console file execution .jar with parameters

## Technologies

- Java 11
- Maven
- JUnit

## Run

To run application:

- build Maven project
- package project on jar file (`SimpleSearchEngine-1.0-SNAPSHOT.jar`)
- run application using `java -jar SimpleSearchEngine-1.0-SNAPSHOT.jar [args]`
- in `[args]` you must put documents (Strings) which will be parsed. Last argument must contain a word for search and
  calculations

## Examples

- Search ``brown``

``java -jar .\SimpleSearchEngine-1.0-SNAPSHOT.jar "the brown fox jumped over the brown dog", "the lazy brown dog sat in the corner", "the red fox bit the lazy dog", "brown"``

Output:

``Document 1 0.25 Document 2 0.125
``

- Search ``fox``

``java -jar .\SimpleSearchEngine-1.0-SNAPSHOT.jar "the brown fox jumped over the brown dog", "the lazy brown dog sat in the corner", "the red fox bit the lazy dog", "fox"``

Output:

``Document 3 0.14285714285714285 Document 1 0.125
``