# Java Collections Framework vs C++ STL - Complete Guide

## Table of Contents
1. [Quick Reference Table](#quick-reference-table)
2. [Vector/ArrayList](#vectorarraylist)
3. [LinkedList](#linkedlist)
4. [Stack](#stack)
5. [Queue & Deque](#queue--deque)
6. [Priority Queue](#priority-queue)
7. [Set](#set)
8. [Map](#map)
9. [Sorting & Searching](#sorting--searching)
10. [Algorithms & Utilities](#algorithms--utilities)

---

## Quick Reference Table

| C++ STL | Java Equivalent | Import Statement |
|---------|----------------|------------------|
| `vector<int>` | `ArrayList<Integer>` | `import java.util.ArrayList;` |
| `list<int>` | `LinkedList<Integer>` | `import java.util.LinkedList;` |
| `stack<int>` | `Stack<Integer>` or `Deque<Integer>` | `import java.util.Stack;` or `import java.util.Deque;` |
| `queue<int>` | `Queue<Integer>` (LinkedList) | `import java.util.Queue;` / `import java.util.LinkedList;` |
| `deque<int>` | `Deque<Integer>` (ArrayDeque) | `import java.util.Deque;` / `import java.util.ArrayDeque;` |
| `priority_queue<int>` | `PriorityQueue<Integer>` | `import java.util.PriorityQueue;` |
| `set<int>` | `TreeSet<Integer>` | `import java.util.TreeSet;` |
| `unordered_set<int>` | `HashSet<Integer>` | `import java.util.HashSet;` |
| `map<int, int>` | `TreeMap<Integer, Integer>` | `import java.util.TreeMap;` |
| `unordered_map<int, int>` | `HashMap<Integer, Integer>` | `import java.util.HashMap;` |
| `pair<int, int>` | `Map.Entry<Integer, Integer>` or custom class | - |
| `sort()` | `Collections.sort()` or `Arrays.sort()` | `import java.util.Collections;` / `import java.util.Arrays;` |

---

## Vector/ArrayList

### C++ Vector
```cpp
#include <vector>
vector<int> v;
v.push_back(10);        // Add element - O(1) amortized
v.pop_back();           // Remove last - O(1)
v[0];                   // Access - O(1)
v.size();               // Size - O(1)
v.empty();              // Check empty - O(1)
v.clear();              // Clear all - O(n)
v.insert(v.begin() + 2, 5); // Insert at position - O(n)
v.erase(v.begin() + 2); // Erase at position - O(n)
```

### Java ArrayList
```java
import java.util.ArrayList;

ArrayList<Integer> list = new ArrayList<>();
list.add(10);                    // Add element - O(1) amortized
list.remove(list.size() - 1);    // Remove last - O(1)
list.get(0);                     // Access - O(1)
list.size();                     // Size - O(1)
list.isEmpty();                  // Check empty - O(1)
list.clear();                    // Clear all - O(n)
list.add(2, 5);                  // Insert at index - O(n)
list.remove(2);                  // Remove at index - O(n)
list.set(0, 20);                 // Update element - O(1)
list.contains(10);               // Check if exists - O(n)
list.indexOf(10);                // Find index - O(n)
```

**Key Differences:**
- Java uses `get(index)` instead of `[]` operator
- Java uses `add()` instead of `push_back()`
- Java doesn't have `pop_back()` directly; use `remove(list.size() - 1)`

---

## LinkedList

### C++ List
```cpp
#include <list>
list<int> l;
l.push_back(10);        // Add at end - O(1)
l.push_front(5);        // Add at front - O(1)
l.pop_back();           // Remove last - O(1)
l.pop_front();          // Remove first - O(1)
l.front();              // Get first - O(1)
l.back();               // Get last - O(1)
l.size();               // Size - O(1)
l.empty();              // Check empty - O(1)
```

### Java LinkedList (Doubly Linked List)
```java
import java.util.LinkedList;

LinkedList<Integer> list = new LinkedList<>();

// Adding elements
list.add(10);              // Add at end - O(1)
list.addLast(10);          // Add at end - O(1)
list.addFirst(5);          // Add at front - O(1)
list.add(2, 15);           // Add at index - O(n)

// Removing elements
list.removeLast();         // Remove last - O(1)
list.removeFirst();        // Remove first - O(1)
list.remove(2);            // Remove at index - O(n)
list.remove(Integer.valueOf(10)); // Remove first occurrence of value - O(n)

// Accessing elements
list.getFirst();           // Get first - O(1)
list.getLast();            // Get last - O(1)
list.get(2);               // Get at index - O(n) [SLOW!]
list.peek();               // Get first (returns null if empty) - O(1)
list.peekFirst();          // Get first - O(1)
list.peekLast();           // Get last - O(1)

// Utility methods
list.size();               // Size - O(1)
list.isEmpty();            // Check empty - O(1)
list.clear();              // Clear all - O(n)
list.contains(10);         // Check if exists - O(n)
list.indexOf(10);          // Find first index - O(n)

// Using as Stack
list.push(20);             // Add at front - O(1)
list.pop();                // Remove from front - O(1)

// Using as Queue
list.offer(30);            // Add at end - O(1)
list.poll();               // Remove from front - O(1)
```

### Iterating over LinkedList

**C++ Style:**
```cpp
// Forward iteration
for (auto it = l.begin(); it != l.end(); ++it) {
    cout << *it << " ";
}

// Range-based for loop
for (int x : l) {
    cout << x << " ";
}
```

**Java Style:**
```java
// Enhanced for loop (Best for LinkedList)
for (int x : list) {
    System.out.print(x + " ");
}

// Iterator (Efficient)
import java.util.Iterator;
Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    System.out.print(it.next() + " ");
}

// Index-based (AVOID - O(n²) overall!)
for (int i = 0; i < list.size(); i++) {
    System.out.print(list.get(i) + " "); // Each get() is O(n)
}

// ListIterator (Bidirectional)
import java.util.ListIterator;
ListIterator<Integer> lit = list.listIterator();
while (lit.hasNext()) {
    System.out.print(lit.next() + " ");
}
```

**⚠️ CRITICAL WARNING for LinkedList:**
- **NEVER** use `get(index)` in a loop! It's O(n) per call, making loops O(n²)
- Always use enhanced for loop or Iterator for traversal
- Random access is NOT efficient in LinkedList (unlike ArrayList)

---

## Stack

### C++ Stack
```cpp
#include <stack>
stack<int> s;
s.push(10);     // Push - O(1)
s.pop();        // Pop - O(1)
s.top();        // Top element - O(1)
s.empty();      // Check empty - O(1)
s.size();       // Size - O(1)
```

### Java Stack (Two Approaches)

**Approach 1: Using Stack class (Legacy)**
```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
stack.push(10);        // Push - O(1)
stack.pop();           // Pop - O(1)
stack.peek();          // Top element - O(1)
stack.isEmpty();       // Check empty - O(1)
stack.size();          // Size - O(1)
stack.search(10);      // Returns 1-based position from top - O(n)
```

**Approach 2: Using Deque (Recommended)**
```java
import java.util.Deque;
import java.util.ArrayDeque;

Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);        // Push - O(1)
stack.pop();           // Pop - O(1)
stack.peek();          // Top element - O(1)
stack.isEmpty();       // Check empty - O(1)
stack.size();          // Size - O(1)
```

**Note:** Deque with ArrayDeque is preferred as Stack class is legacy and synchronized (slower).

---

## Queue & Deque

### C++ Queue
```cpp
#include <queue>
queue<int> q;
q.push(10);     // Enqueue - O(1)
q.pop();        // Dequeue - O(1)
q.front();      // Front element - O(1)
q.back();       // Back element - O(1)
q.empty();      // Check empty - O(1)
q.size();       // Size - O(1)
```

### Java Queue
```java
import java.util.Queue;
import java.util.LinkedList;

Queue<Integer> queue = new LinkedList<>();
queue.offer(10);       // Enqueue - O(1)
queue.poll();          // Dequeue - O(1)
queue.peek();          // Front element - O(1)
queue.isEmpty();       // Check empty - O(1)
queue.size();          // Size - O(1)
```

### C++ Deque (Double-ended queue)
```cpp
#include <deque>
deque<int> dq;
dq.push_back(10);   // Add at end - O(1)
dq.push_front(5);   // Add at front - O(1)
dq.pop_back();      // Remove from end - O(1)
dq.pop_front();     // Remove from front - O(1)
dq[0];              // Access - O(1)
```

### Java Deque
```java
import java.util.Deque;
import java.util.ArrayDeque;

Deque<Integer> deque = new ArrayDeque<>();
deque.offerLast(10);   // Add at end - O(1)
deque.offerFirst(5);   // Add at front - O(1)
deque.pollLast();      // Remove from end - O(1)
deque.pollFirst();     // Remove from front - O(1)
deque.peekFirst();     // Get first - O(1)
deque.peekLast();      // Get last - O(1)
```

---

## Priority Queue

### C++ Priority Queue (Max Heap by default)
```cpp
#include <queue>
priority_queue<int> pq;                              // Max heap
priority_queue<int, vector<int>, greater<int>> pq;   // Min heap

pq.push(10);    // Insert - O(log n)
pq.pop();       // Remove top - O(log n)
pq.top();       // Get top - O(1)
pq.empty();     // Check empty - O(1)
pq.size();      // Size - O(1)
```

### Java PriorityQueue (Min Heap by default)
```java
import java.util.PriorityQueue;
import java.util.Collections;

// Min Heap (default)
PriorityQueue<Integer> pq = new PriorityQueue<>();

// Max Heap
PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

pq.offer(10);      // Insert - O(log n)
pq.poll();         // Remove top - O(log n)
pq.peek();         // Get top - O(1)
pq.isEmpty();      // Check empty - O(1)
pq.size();         // Size - O(1)
pq.remove(10);     // Remove specific element - O(n)
```

**Custom Comparator:**
```java
// Min heap based on absolute value
PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(a) - Math.abs(b));

// Max heap with custom object
class Pair {
    int x, y;
    Pair(int x, int y) { this.x = x; this.y = y; }
}
PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.x - a.x); // Max heap by x
```

---

## Set

### C++ Set (Ordered - Red-Black Tree)
```cpp
#include <set>
set<int> s;
s.insert(10);           // Insert - O(log n)
s.erase(10);            // Remove - O(log n)
s.find(10);             // Find - O(log n)
s.count(10);            // Check exists - O(log n)
s.size();               // Size - O(1)
s.empty();              // Check empty - O(1)
s.lower_bound(10);      // First >= key - O(log n)
s.upper_bound(10);      // First > key - O(log n)
```

### C++ Unordered Set (Hash Set)
```cpp
#include <unordered_set>
unordered_set<int> s;
s.insert(10);           // Insert - O(1) average
s.erase(10);            // Remove - O(1) average
s.find(10);             // Find - O(1) average
s.count(10);            // Check exists - O(1) average
```

### Java TreeSet (Ordered - Red-Black Tree)
```java
import java.util.TreeSet;

TreeSet<Integer> set = new TreeSet<>();
set.add(10);               // Insert - O(log n)
set.remove(10);            // Remove - O(log n)
set.contains(10);          // Check exists - O(log n)
set.size();                // Size - O(1)
set.isEmpty();             // Check empty - O(1)
set.first();               // Minimum - O(log n)
set.last();                // Maximum - O(log n)
set.lower(10);             // Largest < key - O(log n)
set.floor(10);             // Largest <= key - O(log n)
set.ceiling(10);           // Smallest >= key - O(log n)
set.higher(10);            // Smallest > key - O(log n)
set.pollFirst();           // Remove and return min - O(log n)
set.pollLast();            // Remove and return max - O(log n)
```

### Java HashSet (Unordered - Hash Table)
```java
import java.util.HashSet;

HashSet<Integer> set = new HashSet<>();
set.add(10);               // Insert - O(1) average
set.remove(10);            // Remove - O(1) average
set.contains(10);          // Check exists - O(1) average
set.size();                // Size - O(1)
set.isEmpty();             // Check empty - O(1)
```

**Iterating over Set:**
```java
for (int x : set) {
    System.out.print(x + " ");
}
```

---

## Map

### C++ Map (Ordered - Red-Black Tree)
```cpp
#include <map>
map<int, int> m;
m[key] = value;         // Insert/Update - O(log n)
m.erase(key);           // Remove - O(log n)
m.find(key);            // Find - O(log n)
m.count(key);           // Check exists - O(log n)
m.size();               // Size - O(1)

// Iterate
for (auto& p : m) {
    cout << p.first << " " << p.second;
}
```

### C++ Unordered Map (Hash Map)
```cpp
#include <unordered_map>
unordered_map<int, int> m;
m[key] = value;         // Insert/Update - O(1) average
m.erase(key);           // Remove - O(1) average
m.find(key);            // Find - O(1) average
m.count(key);           // Check exists - O(1) average
```

### Java TreeMap (Ordered - Red-Black Tree)
```java
import java.util.TreeMap;
import java.util.Map;

TreeMap<Integer, Integer> map = new TreeMap<>();
map.put(key, value);           // Insert/Update - O(log n)
map.get(key);                  // Get value - O(log n)
map.getOrDefault(key, 0);      // Get or default - O(log n)
map.remove(key);               // Remove - O(log n)
map.containsKey(key);          // Check key exists - O(log n)
map.containsValue(value);      // Check value exists - O(n)
map.size();                    // Size - O(1)
map.isEmpty();                 // Check empty - O(1)
map.firstKey();                // Minimum key - O(log n)
map.lastKey();                 // Maximum key - O(log n)
map.lowerKey(key);             // Largest < key - O(log n)
map.floorKey(key);             // Largest <= key - O(log n)
map.ceilingKey(key);           // Smallest >= key - O(log n)
map.higherKey(key);            // Smallest > key - O(log n)

// Iterate
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " " + entry.getValue());
}

// Or
for (int key : map.keySet()) {
    System.out.println(key + " " + map.get(key));
}
```

### Java HashMap (Unordered - Hash Table)
```java
import java.util.HashMap;
import java.util.Map;

HashMap<Integer, Integer> map = new HashMap<>();
map.put(key, value);           // Insert/Update - O(1) average
map.get(key);                  // Get value - O(1) average
map.getOrDefault(key, 0);      // Get or default - O(1) average
map.remove(key);               // Remove - O(1) average
map.containsKey(key);          // Check key exists - O(1) average
map.containsValue(value);      // Check value exists - O(n)
map.size();                    // Size - O(1)
map.isEmpty();                 // Check empty - O(1)

// Iterate
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " " + entry.getValue());
}
```

**Updating map values:**
```java
// Increment frequency
map.put(key, map.getOrDefault(key, 0) + 1);

// Using compute
map.compute(key, (k, v) -> (v == null) ? 1 : v + 1);

// Using merge
map.merge(key, 1, Integer::sum);
```

---

## Sorting & Searching

### C++ Sorting
```cpp
#include <algorithm>
vector<int> v = {3, 1, 4, 1, 5};

sort(v.begin(), v.end());                          // Ascending - O(n log n)
sort(v.begin(), v.end(), greater<int>());          // Descending - O(n log n)

// Custom comparator
sort(v.begin(), v.end(), [](int a, int b) {
    return a > b; // Descending
});
```

### Java Sorting

**Arrays:**
```java
import java.util.Arrays;

int[] arr = {3, 1, 4, 1, 5};
Arrays.sort(arr);                                  // Ascending - O(n log n)

// For descending, need Integer array
Integer[] arr2 = {3, 1, 4, 1, 5};
Arrays.sort(arr2, Collections.reverseOrder());     // Descending - O(n log n)

// Custom comparator
Arrays.sort(arr2, (a, b) -> b - a);               // Descending
```

**Collections:**
```java
import java.util.Collections;
import java.util.ArrayList;

ArrayList<Integer> list = new ArrayList<>();
Collections.sort(list);                            // Ascending - O(n log n)
Collections.sort(list, Collections.reverseOrder()); // Descending - O(n log n)

// Custom comparator
Collections.sort(list, (a, b) -> b - a);          // Descending

// Or use list's sort method
list.sort((a, b) -> a - b);                        // Ascending
```

### C++ Binary Search
```cpp
#include <algorithm>
vector<int> v = {1, 2, 3, 4, 5};

binary_search(v.begin(), v.end(), 3);              // Returns true/false - O(log n)
lower_bound(v.begin(), v.end(), 3);                // First >= key - O(log n)
upper_bound(v.begin(), v.end(), 3);                // First > key - O(log n)
```

### Java Binary Search
```java
import java.util.Arrays;
import java.util.Collections;

int[] arr = {1, 2, 3, 4, 5};
int index = Arrays.binarySearch(arr, 3);           // Returns index or -(insertion point)-1 - O(log n)

ArrayList<Integer> list = new ArrayList<>();
int idx = Collections.binarySearch(list, 3);       // Returns index or -(insertion point)-1 - O(log n)
```

---

## Algorithms & Utilities

### C++ Algorithms
```cpp
#include <algorithm>
#include <numeric>

// Min/Max
*min_element(v.begin(), v.end());                  // O(n)
*max_element(v.begin(), v.end());                  // O(n)

// Reverse
reverse(v.begin(), v.end());                       // O(n)

// Sum
accumulate(v.begin(), v.end(), 0);                 // O(n)

// Count
count(v.begin(), v.end(), 5);                      // O(n)

// Fill
fill(v.begin(), v.end(), 0);                       // O(n)

// Next permutation
next_permutation(v.begin(), v.end());              // O(n)
```

### Java Utilities
```java
import java.util.Collections;
import java.util.Arrays;

ArrayList<Integer> list = new ArrayList<>();

// Min/Max
Collections.min(list);                             // O(n)
Collections.max(list);                             // O(n)

// For arrays
Arrays.stream(arr).min().getAsInt();               // O(n)
Arrays.stream(arr).max().getAsInt();               // O(n)

// Reverse
Collections.reverse(list);                         // O(n)

// For arrays
for (int i = 0; i < arr.length / 2; i++) {
    int temp = arr[i];
    arr[i] = arr[arr.length - 1 - i];
    arr[arr.length - 1 - i] = temp;
}

// Sum
int sum = list.stream().mapToInt(Integer::intValue).sum();  // O(n)

// For arrays
int sum = Arrays.stream(arr).sum();                // O(n)

// Count
Collections.frequency(list, 5);                    // O(n)

// Fill
Collections.fill(list, 0);                         // O(n)
Arrays.fill(arr, 0);                               // O(n)

// Swap
Collections.swap(list, i, j);                      // O(1)
```

---

## Common Patterns & Tips

### 1. Using Pair/Tuple

**C++:**
```cpp
#include <utility>
pair<int, int> p = {1, 2};
cout << p.first << " " << p.second;
```

**Java:** (No built-in Pair, create custom class)
```java
class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

Pair p = new Pair(1, 2);
System.out.println(p.first + " " + p.second);

// Or use Map.Entry for simple cases
Map.Entry<Integer, Integer> entry = Map.entry(1, 2);
System.out.println(entry.getKey() + " " + entry.getValue());
```

### 2. StringBuilder (like string in C++)

**C++:**
```cpp
string s = "";
s += "hello";
s += " world";
```

**Java:**
```java
StringBuilder sb = new StringBuilder();
sb.append("hello");
sb.append(" world");
String result = sb.toString();

// Common operations
sb.insert(5, " there");        // Insert at position - O(n)
sb.delete(0, 5);               // Delete range - O(n)
sb.reverse();                  // Reverse - O(n)
sb.length();                   // Length - O(1)
sb.charAt(0);                  // Get char - O(1)
```

### 3. Converting Between Types

```java
// String to int
int num = Integer.parseInt("123");

// int to String
String str = String.valueOf(123);
String str2 = Integer.toString(123);

// Array to List
Integer[] arr = {1, 2, 3};
List<Integer> list = Arrays.asList(arr);
// Or
List<Integer> list2 = new ArrayList<>(Arrays.asList(arr));

// List to Array
Integer[] arr2 = list.toArray(new Integer[0]);

// int[] to Integer[]
int[] primitiveArr = {1, 2, 3};
Integer[] boxedArr = Arrays.stream(primitiveArr).boxed().toArray(Integer[]::new);
```

### 4. Input/Output

**Fast I/O in Java:**
```java
import java.io.*;
import java.util.*;

class FastIO {
    BufferedReader br;
    StringTokenizer st;
    
    public FastIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

// Usage
FastIO io = new FastIO();
int n = io.nextInt();
```

---

## Time Complexity Summary

| Operation | ArrayList | LinkedList | HashSet | TreeSet | HashMap | TreeMap |
|-----------|-----------|------------|---------|---------|---------|---------|
| Add | O(1) | O(1) | O(1) | O(log n) | O(1) | O(log n) |
| Remove | O(n) | O(1)* | O(1) | O(log n) | O(1) | O(log n) |
| Get/Access | O(1) | O(n) | - | - | O(1) | O(log n) |
| Contains | O(n) | O(n) | O(1) | O(log n) | O(1) | O(log n) |
| Iteration | O(n) | O(n) | O(n) | O(n) | O(n) | O(n) |

*O(1) only for first/last in LinkedList, O(n) for arbitrary position

---

## Important Notes

1. **Java uses Wrapper Classes**: `Integer`, `Long`, `Double`, `Character` instead of primitives for collections
2. **Default Values**: HashMap/TreeMap return `null` for missing keys (use `getOrDefault()`)
3. **Null Handling**: Most collections allow null, but TreeSet/TreeMap don't allow null keys
4. **Thread Safety**: Collections are NOT thread-safe by default (unlike C++ STL containers with some guarantees)
5. **Iterator Invalidation**: Modifying collection while iterating throws `ConcurrentModificationException` (use Iterator's remove())

---

## Quick Template for Competitive Programming

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            
            // Your solution here
            
        }
        
        out.flush();
        out.close();
    }
}
```

---

**Happy Coding! 🚀**
