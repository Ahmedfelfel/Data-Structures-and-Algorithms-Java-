
Implement the Breadth-First Search (BFS) algorithm using an adjacency list data structure.
Most lines of code are already prepared or you due to heavily usages of `HashMap` and `Queue`.

To remind you of the BFS algorithm, here is the pseudocode:
```
WHILE (!q.isEmpty())
  srcNode <- q.poll()
  
  Mark the srcNode as visited
  Process the srcNode
  
  FOR EACH neighborsOf(srcNode)
    IF the neighbor is not visited THEN
      Mark the neighbor as visited
      q.add(neighbor)
    END IF
  END FOR
END WHILE
```
