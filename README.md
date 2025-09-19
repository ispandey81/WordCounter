# WordCounter

A simple Java CLI tool that counts words in a file based on configurable business rules.

- Build environment details:
    - Requires java version - 21

    - Uses maven as the build and packaging tool

- Assumptions & Design Decisions:
  - The program reads an input file from JVM arguments.
      - If no argument is supplied, it defaults to using `input.txt` from the resources folder.
      - If the argument is not a valid file, the user will receive an appropriate message.
  - Current business rules implemented:
      1. Counts and returns the **number of words** that start with "M" or "m".
      2. Returns all **words longer than 5 characters**.
  - Adding new business rules:
      - Implement the `RuleStrategy` interface for the new rule.
      - Add the new rule to the list of rules in the WordCounter class -https://github.com/ispandey81/WordCounter/blob/d74b928a1973bc9679f0d85affc05d0c11d031db/src/main/java/org/indra/WordCounter.java#L56
  - The default input file is located at src/main/resources/input.txt
  - Logging is configured via Log4j2 and outputs info to the console

- Instructions to run the program (Java only, no Maven)
  - Make sure you have java 21 installed on your machine
  - Open a terminal at the root of this project
  - To execute the WordCounter-1.0-SNAPSHOT-jar-with-dependencies.jar, we have 2 options -
    - Without any JVM argument to the WordCounter program (uses the default file - input.txt):
      - `java -jar target/WordCounter-1.0-SNAPSHOT-jar-with-dependencies.jar`
    - With a valid JVM argument to the WordCounter program (expects the user to supply a valid file):
      - `java -jar target/WordCounter-1.0-SNAPSHOT-jar-with-dependencies.jar <valid-file-in-the-current-directory>`
      e.g. `java -jar target/WordCounter-1.0-SNAPSHOT-jar-with-dependencies.jar input.txt`

- Instructions to run the program (both Java and Maven installed)
  - Make sure you have java 21 and maven installed on your machine

  - Open a terminal at the root of this project and execute `mvn clean install`
    The command will compile the code, run the tests and create two jars in your target directory -
    - WordCounter-1.0-SNAPSHOT.jar 
    - WordCounter-1.0-SNAPSHOT-jar-with-dependencies.jar

  - Use the WordCounter-1.0-SNAPSHOT-jar-with-dependencies.jar to test this solution as it has
    the java code and dependencies bundled into an uber jar file

  - To execute the WordCounter-1.0-SNAPSHOT-jar-with-dependencies.jar, we have 2 options -
    - Without any JVM argument to the WordCounter program (it will use the default file - input.txt):
      - `java -jar target/WordCounter-1.0-SNAPSHOT-jar-with-dependencies.jar`
    - With a valid JVM argument to the WordCounter program (expects the user to supply a valid file):
      - `java -jar target/WordCounter-1.0-SNAPSHOT-jar-with-dependencies.jar <valid-file-in-the-current-directory>`
        e.g. `java -jar target/WordCounter-1.0-SNAPSHOT-jar-with-dependencies.jar input.txt`
