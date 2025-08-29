
Implement an **adjacency list** graph data structure based on `Map<T, Map<T, W>>` 
where `T` is data type representing a node, and `W` is data type of edges' weight.

- The constructor `Graph()` should create a map
- `addNode(node)` should create an adjacency list (we chose a `Map`) for the `node`
- `connect(srcNode, dstNode, weight)` should create a directed edge by putting `dstNode` and `weight` on the `srcNode`
- `neighborsOf(node)` should return the adjacency list (`Map`) of the `node`
