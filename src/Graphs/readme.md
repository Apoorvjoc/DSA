
# Understanding O(V + 2E) Complexity in Graphs

## Introduction

When analyzing the time complexity of graph traversal algorithms such as **DFS (Depth-First Search)** and **BFS (Breadth-First Search)**, the complexity is often expressed as **O(V + E)**. However, in an **undirected graph** using an adjacency list, this can sometimes be written as **O(V + 2E)**. This document explains why this is the case and how it affects performance.

----------

## Why O(V + 2E)?

### **1. Graph Representation**

A graph consists of:

-   `V` → Number of **vertices (nodes)**

-   `E` → Number of **edges (connections)**


In an **adjacency list representation**, each vertex maintains a list of its directly connected neighbors.

### **2. Adjacency List Storage for Undirected Graphs**

In an **undirected graph**, each edge `(u, v)` is stored **twice**:

-   Once in `adj[u]` (neighbor list of `u`)

-   Once in `adj[v]` (neighbor list of `v`)


Thus, if there are `E` edges, each one appears **twice** in the adjacency list, leading to `2E` entries.

### **3. Traversing the Adjacency List**

When performing **DFS or BFS**, we:

-   Visit each vertex **once** → `O(V)`

-   Process each **edge** by iterating over the adjacency list → `O(2E)` (since each edge appears twice)


Therefore, the overall complexity becomes:

t

Since we ignore constant factors in Big-O notation, this simplifies to:

t

----------

## Example Walkthrough

### **Graph Representation**

Consider this adjacency matrix:

```
isConnected = [
    [0, 1, 1],
    [1, 0, 0],
    [1, 0, 0]
];
```

The corresponding **adjacency list** is:

```
0 → [1, 2]
1 → [0]
2 → [0]
```

Here, edge **(0,1)** is stored in both `adj[0]` and `adj[1]`. Similarly, edge **(0,2)** appears in both `adj[0]` and `adj[2]`.

----------

## Performance Considerations

-   **Adjacency List (O(V + E))** → Efficient for sparse graphs (`E << V^2`)

-   **Adjacency Matrix (O(V²))** → Efficient for dense graphs (`E ≈ V^2`)


For real-world applications, the adjacency list representation is preferred for large and sparse graphs.

----------

## Conclusion

-   The **O(V + 2E)** notation arises because each edge is stored twice in an undirected graph.

-   However, in Big-O notation, constant factors are ignored, so it simplifies to **O(V + E)**.

-   This makes adjacency lists efficient for graph traversal algorithms like **DFS and BFS**, especially for sparse graphs.


----------

## References

-   Graph Theory Basics

-   DFS and BFS Complexity Analysis