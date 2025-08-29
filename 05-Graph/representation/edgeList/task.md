
Implement an **edge list** graph data structure based on List<GraphEdge<T, W>> where T is data type representing a node, and W is data type of edges' weight.

- The constructor `Graph()` should create a map
- `connect(srcNode, dstNode, weight)` should create a directed edge by putting `srcNode`, `dstNode` and `weight` on a new `GraphEdge<T, W>` and add it to the list
- `addNode(node)` and `neighborsOf(node)` are not supported due to properties of the data structure
