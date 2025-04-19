## Given matrix
``` 
isConnected = [
    [1, 0, 0, 0],  
    [0, 1, 1, 0],  
    [0, 1, 1, 0],  
    [0, 0, 0, 1]  
]
```
---

### **Step 1: Understanding the Input**

The  `isConnected`  matrix represents a graph where:

-   `isConnected[i][j] = 1`  means city  `i`  is directly connected to city  `j`.

-   `isConnected[i][j] = 0`  means city  `i`  and city  `j`  are  **not**  directly connected.


Interpreting this matrix:

-   City  `1`  is connected to  `2`.

-   City  `2`  is connected to  `1`.

-   City  `3`  is only connected to itself.

-   City  `0`  is isolated (not connected to any city, including itself).


----------

### **Step 2: Initializing Variables**

-   `n = 4`  (Number of cities)

-   `visited = [false, false, false, false]`

-   `count = 0`  (To track the number of provinces)


----------

### **Step 3: Iteration Over  `i`**

#### **Iteration 1: i = 0**

-   `visited[0]`  is  `false`, so we start DFS for city  `0`  and increment  `count = 1`.


**DFS for city  `0`**:

1.  Mark  `visited[0] = true`  →  `[true, false, false, false]`

2.  Iterate over  `j`:

    -   `j = 0`:  `isConnected[0][0] = 0`, so ignore.

    -   `j = 1`:  `isConnected[0][1] = 0`, so ignore.

    -   `j = 2`:  `isConnected[0][2] = 0`, so ignore.

    -   `j = 3`:  `isConnected[0][3] = 0`, so ignore.


**DFS completes for city  `0`**.  
✅ Province found →  `count = 1`.

----------

#### **Iteration 2: i = 1**

-   `visited[1]`  is  `false`, so we start DFS for city  `1`  and increment  `count = 2`.


**DFS for city  `1`**:

1.  Mark  `visited[1] = true`  →  `[true, true, false, false]`

2.  Iterate over  `j`:

    -   `j = 0`:  `isConnected[1][0] = 0`, so ignore.

    -   `j = 1`:  `isConnected[1][1] = 1`, but  `visited[1]`  is already  `true`, so ignore.

    -   `j = 2`:  `isConnected[1][2] = 1`  and  `visited[2] = false`  → Call DFS for city  `2`.


**DFS for city  `2`**:

1.  Mark  `visited[2] = true`  →  `[true, true, true, false]`

2.  Iterate over  `j`:

    -   `j = 0`:  `isConnected[2][0] = 0`, so ignore.

    -   `j = 1`:  `isConnected[2][1] = 1`, but  `visited[1]`  is already  `true`, so ignore.

    -   `j = 2`:  `isConnected[2][2] = 1`, but  `visited[2]`  is already  `true`, so ignore.

    -   `j = 3`:  `isConnected[2][3] = 0`, so ignore.


**DFS completes for city  `2`**, returning to city  `1`.  
✅ Province found →  `count = 2`.

----------

#### **Iteration 3: i = 2**

-   `visited[2]`  is already  `true`  (covered in previous DFS), so we skip this iteration.


----------

#### **Iteration 4: i = 3**

-   `visited[3]`  is  `false`, so we start DFS for city  `3`  and increment  `count = 3`.


**DFS for city  `3`**:

1.  Mark  `visited[3] = true`  →  `[true, true, true, true]`

2.  Iterate over  `j`:

    -   `j = 0`:  `isConnected[3][0] = 0`, so ignore.

    -   `j = 1`:  `isConnected[3][1] = 0`, so ignore.

    -   `j = 2`:  `isConnected[3][2] = 0`, so ignore.

    -   `j = 3`:  `isConnected[3][3] = 1`, but  `visited[3]`  is already  `true`, so ignore.


**DFS completes for city  `3`**.  
✅ Province found →  `count = 3`.

----------

### **Final Output**

Since we counted  `count = 3`  distinct provinces, the function returns  **3**.

----------



## Explanation:
- **City 0** is isolated and forms its own province.
- **City 1 and City 2** are connected and form another province.
- **City 3** is only connected to itself and forms its own province.

## Iteration Summary:

| `i`  | `visited` before DFS      | DFS called? | `visited` after DFS      | `count` |
|------|---------------------------|------------|--------------------------|--------|
| 0    | `[false, false, false, false]` | Yes        | `[true, false, false, false]` | 1      |
| 1    | `[true, false, false, false]` | Yes        | `[true, true, true, false]` | 2      |
| 2    | `[true, true, true, false]` | No         | `[true, true, true, false]` | 2      |
| 3    | `[true, true, true, false]` | Yes        | `[true, true, true, true]`  | 3      |

## Final Output:
**Total Provinces = 3**
