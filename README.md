Divide and Conquer Algorithms
In this project I implemented several algorithms using the Divide and Conquer approach.
The project is written in Java + Maven, and all algorithms are tested with JUnit.

Implemented Algorithms
Merge Sort – sorting with merge
Quick Sort – sorting with partitioning
Deterministic Select – finding the k-th smallest element (median of medians)
Closest Pair of Points – finding the closest two points in 2D space
Project Structure
dnc-algorithms/
 ├── data/                 # example input data
 ├── src/main/java/...     # source code of algorithms
 ├── src/test/java/...     # unit tests with JUnit
 ├── pom.xml               # Maven configuration
How to Run
Clone the project or open it in IntelliJ IDEA
Build with Maven:
mvn clean install
Run the project from Main.java or run all tests:
mvn test

Example
Example of using merge sort from Main.java:

int[] arr = {5, 2, 9, 1, 7};
MergeSort.sort(arr);
System.out.println(Arrays.toString(arr));
Technologies
Java 17
Maven
JUnit 5
This project demonstrates how Divide and Conquer can be applied to different problems: sorting, selection, and computational geometry.
