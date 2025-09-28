# Divide and Conquer Algorithms

This project demonstrates several classical algorithms implemented using the **Divide and Conquer** approach.  
The code is written in **Java 17** with **Maven**, and tested using **JUnit 5**.

---

## Implemented Algorithms

### 1. Merge Sort
- **Idea:** Split the array into halves, recursively sort them, then merge.  
- **File:** `MergeSort.java`  
- **Usage:**
  ```java
  int[] arr = {5, 2, 9, 1, 7};
  MergeSort.sort(arr);
  System.out.println(Arrays.toString(arr));
````

### 2. Quick Sort

* **Idea:** Partition the array around a pivot, then recursively sort left and right parts.
* **File:** `QuickSort.java`
* **Usage:**

  ```java
  int[] arr = {5, 2, 9, 1, 7};
  QuickSort.sort(arr, 0, arr.length - 1);
  ```

### 3. Deterministic Select (Median of Medians)

* **Idea:** Find the *k-th smallest element* in linear time using median-of-medians pivot selection.
* **File:** `DeterministicSelect.java`
* **Usage:**

  ```java
  int[] arr = {5, 2, 9, 1, 7};
  int kth = DeterministicSelect.select(arr, 0, arr.length - 1, 3);
  System.out.println("3rd smallest = " + kth);
  ```

### 4. Closest Pair of Points

* **Idea:** Given a set of points in 2D, find the two closest points using divide and conquer in O(n log n).
* **File:** `ClosestPair.java`
* **Usage:**

  ```java
  Point[] points = {
      new Point(0, 0),
      new Point(3, 4),
      new Point(1, 1),
      new Point(7, 2)
  };
  double dist = ClosestPair.closestPair(points);
  System.out.println("Closest distance = " + dist);
  ```

---

## Utility Classes

* **`Utils.java`** – helper methods for arrays and math.
* **`Metrics.java`** – simple measurement of execution time.

---

## Main Entry Point

The `Main.java` file contains examples of running all algorithms.
You can quickly test them by running the project.

---

## Project Structure

```
dnc-algorithms/
 ├── data/                 # example input data
 ├── src/main/java/org/example/alg
 │    ├── MergeSort.java
 │    ├── QuickSort.java
 │    ├── DeterministicSelect.java
 │    ├── ClosestPair.java
 │    ├── util/Utils.java
 │    ├── util/Metrics.java
 │    └── Main.java
 ├── src/test/java/...     # JUnit tests
 ├── pom.xml               # Maven configuration
```

---

## How to Run

1. Open the project in **IntelliJ IDEA** (or any IDE with Maven support).
2. Build with Maven:

   ```bash
   mvn clean install
   ```
3. Run the project:

   ```bash
   mvn exec:java -Dexec.mainClass="org.example.alg.Main"
   ```
4. Or run unit tests:

   ```bash
   mvn test
   ```

---

## Technologies Used

* **Java 17**
* **Maven**
* **JUnit 5**

---

## Summary

This project shows how the **Divide and Conquer paradigm** can be applied to different problems:

* Sorting (Merge Sort, Quick Sort)
* Selection (Deterministic Select)
* Computational Geometry (Closest Pair of Points)

It demonstrates the power and elegance of recursive problem solving in algorithm design.

```

