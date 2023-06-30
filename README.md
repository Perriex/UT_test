# Part one
### Find a perfect test

IEMDB project for Internet Engineering.

# Part two
### Choose the type of test generation

- [ ] SPI
- [ ] ART
- [X] SBT
- [ ] MBT
- [ ] Symbolic

Using Search-based test generation, we will generate suitable number of tests for the chosen application.

# Part three
### Choose the tool of automatic test generation

- [ ] Randoop
- [ ] JUnit QuickCheck
- [ ] Pex
- [X] Evosuite
- [ ] CodePro AnalytiX
- [ ] AgitarOne

Evosuite primarily focuses on generating automated tests using search-based testing. It utilizes evolutionary algorithms and intelligent search techniques to create targeted and comprehensive tests that aim to achieve high code coverage.

By employing evolutionary algorithms, evosuite generates new tests iteratively and performs testing on them. In each iteration, tests that achieve higher code coverage are selected, and new tests are generated by introducing random mutations and variations in the input space.

Additionally, evosuite also incorporates other techniques simultaneously. These techniques include input space partitioning, adaptive random testing, model-based testing, and symbolic execution. By combining these methods, evosuite aims to create extensive and reliable automated tests for Java programs.


After running "Evosuite",first there is a process for searching the program(class), then it minimizes test suite. Then It anaylyzes the coverage criteria. we will get these test criteria
```
  - Line Coverage
  - Branch Coverage*
  - Exception
  - Mutation testing (weak)*
  - Method-Output Coverage
  - Top-Level Method Coverage
  - No-Exception Top-Level Method Coverage
  - Context Branch Coverage
```

# Part Four
### Simple program for possiblility
```
package tutorial;

import java.util.EmptyStackException;

public class ComplexProgram {

    // Java program to search a given key in a given BST

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

class BinarySearchTree {
	Node root;

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	// A utility function to insert
	// a new node with given key in BST
	Node insert(Node node, int key) {
		// If the tree is empty, return a new node
		if (node == null) {
			node = new Node(key);
			return node;
		}

		// Otherwise, recur down the tree
		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);

		// Return the (unchanged) node pointer
		return node;
	}

	// Utility function to search a key in a BST
	Node search(Node root, int key) {
		// Base Cases: root is null or key is present at root
		if (root == null || root.key == key)
			return root;

		// Key is greater than root's key
		if (root.key < key)
			return search(root.right, key);

		// Key is smaller than root's key
		return search(root.left, key);
	}

   }

}

```

Run "sh instructions.sh" in the terminal. Results are in the "phase one/evosuite-report/statistics.cvs".

# Part Five
### The report

- [X] Present sample code
- [X] Auto-Test generation
- [X] Report of code coverage
- [X] Mutation Report

```

* Search finished after 65s and 6 generations, 4660 statements, best individual has fitness: 10.0
* Minimizing test suite
* Going to analyze the coverage criteria
* Coverage analysis for criterion LINE
* Coverage of criterion LINE: 100%
* Total number of goals: 21
* Number of covered goals: 21
* Coverage analysis for criterion BRANCH
* Coverage of criterion BRANCH: 100%
* Total number of goals: 15
* Number of covered goals: 15
* Coverage analysis for criterion EXCEPTION
* Coverage of criterion EXCEPTION: 100% (no goals)
* Coverage analysis for criterion WEAKMUTATION
* Coverage of criterion WEAKMUTATION: 97%
* Total number of goals: 72
* Number of covered goals: 70
* Coverage analysis for criterion OUTPUT
* Coverage of criterion OUTPUT: 100% (no goals)
* Coverage analysis for criterion METHOD
* Coverage of criterion METHOD: 100%
* Total number of goals: 5
* Number of covered goals: 5
* Coverage analysis for criterion METHODNOEXCEPTION
* Coverage of criterion METHODNOEXCEPTION: 100%
* Total number of goals: 5
* Number of covered goals: 5
* Coverage analysis for criterion CBRANCH
* Coverage of criterion CBRANCH: 93%
* Total number of goals: 15
* Number of covered goals: 14
* Generated 6 tests with total length 24
* Resulting test suite's coverage: 80% (average coverage for all fitness functions)
* Generating assertions
* Resulting test suite's mutation score: 40%
* Compiling and checking tests

```

Output of Testing
```
JUnit version 4.12
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
......
Time: 0.243

OK (6 tests)


```

More test generated and the result
```
JUnit version 4.12
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
........
Time: 0.247

OK (8 tests)

```

# Part Six
### Test generation

#### Run Instructions on Classes 
- Command
- Entity
- Exception

# Part Seven
### Reports

All reports exits on `./phase two/Backend/evosuite-report`.
Result: Evosuite is fine, but dont have integration test. But its coverage and miniuim number of tests is suitable.

