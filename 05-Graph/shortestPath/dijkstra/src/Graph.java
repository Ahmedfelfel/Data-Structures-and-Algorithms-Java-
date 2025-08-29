import java.util.*;

public abstract class Graph<T, W extends Comparable<W>> {
    Map<T, Map<T, W>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    private void addNode(T node) {
        /* TODO: implement an adjacency list (map) creation */
        adjList.put(node,new HashMap<>());
    }

    public void connect(T srcNode, T dstNode, W weight) {
        if (!adjList.containsKey(srcNode))
            this.addNode(srcNode);

        if (!adjList.containsKey(dstNode))
            this.addNode(dstNode);

        /* TODO: create a directed edge */
        adjList.get(srcNode).put(dstNode,weight);
    }

    public Map<T, W> neighborsOf(T node) {
        /* TODO: returns the adjacency list (map) of the node */
        return adjList.get(node);
    }

    protected abstract W add(W a, W b);

    public Map<T, GraphDistance<T, W>> dijkstra(T startingNode, W startingDistance) {
        Map<T, GraphDistance<T, W>> dist = new HashMap<>();
        Map<T, Boolean> visited = new HashMap<>();
        Queue<DistanceInfo<T, W>> q = new PriorityQueue<>();

        // put the starting node to the queue
        dist.put(startingNode, new GraphDistance<>(startingNode, startingDistance));
        q.add(new DistanceInfo<>(startingNode, startingDistance));

        while (!q.isEmpty()) {
            /* TODO: implement the Dijkstra's shortest path algorithm */
            // 1. Get the node with the smallest known distance
            DistanceInfo<T, W> current = q.poll();
            T currentNode = current.node;

            // 2. Skip if already visited
            if (visited.getOrDefault(currentNode, false)) continue;
            visited.put(currentNode, true);

            // 3. Explore neighbors
            for (Map.Entry<T, W> entry : neighborsOf(currentNode).entrySet()) {
                T neighbor = entry.getKey();
                W edgeWeight = entry.getValue();

                // 4. Skip if neighbor already visited
                if (visited.getOrDefault(neighbor, false)) continue;

                // 5. Calculate new distance
                W currentDistance = dist.get(currentNode).distance;
                W newDistance = add(currentDistance, edgeWeight);

                GraphDistance<T, W> knownDistance = dist.get(neighbor);

                // 6. If new distance is better, update and enqueue
                if (knownDistance == null || newDistance.compareTo(knownDistance.distance) < 0) {
                    dist.put(neighbor, new GraphDistance<>(currentNode, newDistance));
                    q.add(new DistanceInfo<>(neighbor, newDistance));
                }
            }
        }

        return dist;
    }
}