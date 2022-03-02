// interview prep

// prompt : given a list of birth and death years of many people, how can you find the year of the highest population?

// coding interview ( steps & tips )
    // step 1 : repeat question back to interviewer. ask for data structures
    // step 2 : pseudocode. draw an example. tip: use a large example, avoid special cases.
    // step 3 : whats the runtime for the algorithm? tip: you can use unique variables to describe runtime.
    // step 4 : look out for unnecessary ( or duplicated ) work ( i.e. OPTIMIZE! ) tip: showing your thought process here is what the ( interviewing ) engineers what to see, how you *think*
    // step 5 : don't code until entirely SURE. esp. of data structures
    // step 6 : test code : conceptual walk-through ( speak aloud ), high-risk code & test cases ( small, edge & big )

// run-time

    // big-o time

        // ex . 1 | min

            int min = 4;

            for ( int v : array ) { // O(N) - for loops
                if ( min > v ) {    // O(1)
                    min = v;
                }
            }

            // ans : O(N)

        // ex . 2 | max & min

            int min2 = 4;
            int max2 = 55;

            for ( int v : array ) {  // O(N)  - N refers to size of 'array'
                if ( min > v ) {     // O(1)
                    min = v;
                }
            }

            for ( int v : array ) {  // O(N)  - N refers to size of 'array'
                if ( max < v ) {     // O(1)
                    max = v;         // O(1)
                }
            }

            // ans : O(N + N) = O(2N) ~ O(N)     [ drop the constants, unimportant]

        // ex . 3 | nested for loops

            for ( int a : A ) {             // O(A)  - A refers to size of array A
                for ( int b : B ) {         // O(B)  - B refers to size of array B
                    if ( a * b < a + b ) {  // O(1)
                        print (a*b);        // O(1)
                    }
                }
            }

            // tip: nested implies multiplication
            // ans : O(A * B)                   [ tip : use different variable names as needed; to show difference in variables, lengths, etc.]

        // ex . 4 | nested with j starting at i

            for ( int i = 0; i <= N; i++) {        // O(N) - N refers to range
                for ( int j = i; i <= N; j++ ) {   // <O(N) - N refers to range. The ceiling would be N, even though all N would not be reached.
                    if ( i * j < K ) {             // O(1)
                        print ( i * j );           // O(1)
                    }
                }
            }

            // ans : O(N * N) = O(N^2)

        // ex . 5 | max population

            int lastDeath = Integer.Min;

            // get last death year
            for ( Person person : people ) {                                   // O(P) - P refers to total # of people
                lastDeath = max(lastDeath, person.death);                      // O(1)
            }

            // increment counter for each year person is alive
            int[] counter = new int[lastDeath];                                // O(1)
            for ( Person person : people ) {                                   // O(P) - P refers to total # of people
                for ( int year = person.birth; year < person.death; year++) {  // O(Y) - Y refers to life span ( deathyear - birthyear )
                    counter[year]++;                                           // O(1)
                }
            }

            // find population peak
            int highestPopulation = 0;                                         // O(1)
            for ( int year = 0; year < counter.length; year++ ) {              // O(L) - L refers to last death year
                highestPopulation = max(highestPopulation, counter[year]);     // O(1)
            }

            // ans : O(P + P*Y + L) = O( P(1+Y) + L ) ~ O(P + Y)               [ remember, drop the constants ]

    // big-o space

        // tip : big-O in regards to space is the amount of memory needed to be allocatted on the stack heap (?)

// data structures

    // array && lists

        // complexity

            // static array  | access : O(1) , search : O(n)
            // dynamic array | access : O(1) , search : O(n) , insertion : O(n) , appending : O(1) , deletion : O(n)

        // static array
            // array of fixed initial size

            // TODO : IMPLEMENTATION - JAVA

        // dynamic array    
            // how to implement?

            // pseudocode
            // init static array.
            // handle add & remove capabiliis as normal
            // once length of original static array surpassed.
                // step 1 : init new array, double of size
                // step 2 : copy original array, add new elem
                // step 3 : continue

            // TODO : IMPLEMENTATION - JAVA

        // suffix array : array w/ all sorted ( indices ) suffixes of string

            // ex | longest common prefix ( LCP ) array 
            // : keeps track of how many chars two sorted suffixes have in common

    // hash tables
        // base : mapping key, value pairs . key to value mapping is called 'hashing'.
        // note : the keys have to be unique AND hashable ( immutable data type ) , values don't.
        // tip : used to track item frequencies

        // hash function : function that maps 'x' to a whole number in a fixed range.
            // ex | h(x) = (x^2 - 6x + 9) mod 10 ( range is [0,9] )

            // properties
                // i. if H(x) = H(y) [ a collision ]... x & y MAY be equal, YET if H(x) != H(y)... x & y DEFINITELY NOT equal. [ tip : helpful for comparisons ]
                // ii. must be deterministic. [ i.e. H(x) = y EVERYTIME ] 
        
        // complexity
            // [ best ] insertion : O(1) , search : O(1) , removal : O(1) * using UNIFORM hash function to index into hashtable
            // [ worst ] insertion : O(N) , search : O(N) , removal : O(N)

        // hash collision ? solutions
            
            // separate chaining : maintaining auxilary data structure ( esp. linked list ) to hold all values hashed to particular key ( i.e. collisions )
                // other data structures : arrays, binary trees, ... Java uses "HashMap"
            
            // open addressing : finding another place within hashtable via offset

    // trees, tries & graphs

        // trees : is a undirected graph either : acyclic , w/ n nodes & n-1 edges, two vertices connected by EXACTLY one path.

            // binary tree : every node has AT MOST two children
                // tip : used in binary search trees ( BSTs ). red black trees. avl trees. splay trees. implementating binary heaps. syntax trees ( used by calcs & compilers ).

            // binary search tree : binary tree AND BST invariant [ left subtree has smaller elems and right subtree has larger elems ]
                
                // complexity , note : 'worst' implies a line.
                    // insert | avg : O(logN) worst : O(N) , delete | avg : O(logN) worst : O(N) , remove | avg : O(logN) worst : O(N) , search | avg : O(logN) worst : O(N)
                
                // TODO : IMPLEMENTATION - JAVA

            // traversals
                // preorder : root subtree, left subtree, right subtree,
                // tip : prints before recursive calls

                // inorder : left subtree, root, right subtree
                // tip : prints inbetween recursive calls

                // postorder : left subtree, right subtree, root
                // tip : prints after recursive calls

            // fenwick tree : supports range queries ( difference between prefix sums ) on arrays, getting values of prefix sums

                // complexity
                    // construction : O(N) , point update : O(logN) , range sum : O(logN) , range update : O(logN) add index : N/A , remove index : N/A 


    // (singly & doubly) linked lists
        // note: the last node always points to null
        // tip : used in List, Queue, Stack implementations. adjaceny lists in graphs. handling collisions in hashtables

        // singly ll : node contains pointer to next node. uses less memory. cannot EASILY acces prev elems.
        // doubly ll : node contains pointer to prev AND next node. uses 2x memory. can traverse backwards

        // complexity

            // singly ll | search : O(n) , insert @ head : O(1) , insert @ tail : O(1) , remove @ head : O(1) , remove @ tail : O(n) , remove elsewhere : O(n)
            // doubly ll | search : O(n) , insert @ head : O(1) , insert @ tail : O(1) , remove @ head : O(1) , remove @ tail : O(n) , remove elsewhere : O(n)

        // TODO : IMPLEMENTATION - JAVA
        // primary operations ?

    // stacks & queues
        // stacks
            // lifo - last in, first out ( elems interface with top of stack )
            // tip : used in undo mechanisms in txt editors. compiler syntax for matching brackets/braces. model piles of books or plates, esp. game : 'tower of hanoi'. depth -first seach on graph.
            
            // complexity
                // push : O(1) , pop : O(1) , peek : O(1) , search : O(n) , size : O(1)

            // TODO : IMPLEMENTATION - JAVA
            // primary operations : push, pop, peek, search

        // queues
            // tip : implemented with arrays, singly linked list or doubly linked list.
            // tip : used to model ( waiting in ) line. keeping track of 'x' most recently added elements. web server request management. breadth-first search ( BFS ) graph traversal.
            // note : enqueueing = adding = offering ( adding to back ). dequeuing = polling ( removing from front )

            // complexity
                // enqueue : O(1) , dequeue : O(1) , peek : O(n), contains : O(n) , removes : O(n) , isEmpty : O(1)
    
        // priority queues
            // note : IMPORTANT - elems added in comparable fashion ( least ->. greatest || greatest -> least )
    
    // heaps
        // tip : value of parent node is greater ( max heaps ) or lesser ( min heaps ) than children
        // note : all heaps must be trees ( ! cycles )
        // tip : used in ( some ) Dijkstra's algorithm. fetching 'next best' or 'next worst' element. Hoffman coding ( lossless data compression). best first search algorithms ( find next most promising node ). minimum spanning tree algotithms . 

        // complexity
            // construction : O(n) , polling : O(logN) , peek : O(1), adding : O(logN), naive remove : O(n) , remove w/ hashtable : O(logN) , naive contains : O(N) , contains w/ hashtable : O(1)

// algorithms

    // merge sort
        // psuedo code : divides array into two halfs. recurse calls self on halves. merges halves together.

    // quick sort
        // pseudo code : picks pivot, less than pivot is 'low' & greater than pivot is 'high'.

    // breadth-first search

        // pseudocode. start at head. visit all neighbors ( create array as necessary ). per each neighbor, mark visited & visit all neighbors ( until no more neighbors to visit ).

        // tip : use queue. dequeue visited nodes.

    // depth-first search
        // pseudo code :

    // binary search
        // pseudo code : check searchItem to middle. if middle return found. if greater than middle, search in right array. if lesser than middle, search in left array.

// other : concepts

    // recursion

        // ex | fib

        int fib( int n ) {
            if ( n < 0 ) {                           // base case
                return 0;
            } else if ( n <= 1 ) {                   // base case
                return 1;
            } else {
                return fib( n - 1 ) + fib ( n - 2 ); // rule of recursion
            }
        }

        // tip : refer to call tree to visualize Big-O space complexity

    // memoization & dynamic programming

        // memoization

            // refer to recursion ex | fib 
            // tip : memoization is saving the values that are repetitively calculated into an array for later use
            
            int fib(int n, int[] memo ) {
                if ( n < 0 ) {                                     // same base case
                    return 0;
                } else if ( n <= 1 ) {                             // same base case
                    return 1;
                } else if ( memo[n] == 0 ) {                       // instead of recurse, uses stored pre-calculated values ( i.e. memoization )
                    memo[n] = fib(n-1), memo ) + fib(n-2, memo)
                }
                return memo[n];
            }

        // dynamic programming



