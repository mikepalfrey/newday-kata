# Introduction
This is based upon https://github.com/davidwhitney/CodeDojos/tree/master/Diamond%20Kata

It is a Java implementation, written using Java 17.

# Building this
To compile this please use Maven.

    mvn clean install
This will build and execute tests.

# Tests
This has 100% coverage of all classes over than Main (which is only used for executing the generator).

In order to execute the tests please using Maven:

    mvn test



# Running this
To run this please execute (with the generated JAR on the Classpath):

    java com.mikep.newday.kata.Main <UPPER_CASE_ALPHABETICAL_CHARACTER>

For example:

    java com.mikep.newday.kata.Main B

Will output the following diamond containing all letters of the alphabet up to and including this character:
```
    _A_
    B_B
    _A_
```
