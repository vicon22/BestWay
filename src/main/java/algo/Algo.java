package algo;

import algo.Node;

import java.util.*;

public class Algo {

    private final static int V = 16; // Колличество вершин
    private final static int SOURCE = 0; // Начальная вершина
    private int[] dist;
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    List<List<Node>> map;

    public Algo(List<List<Node>> map)
    {
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
        this.map = map;
    }

    // Алгоритм Дейкстры
    private void dijkstra()
    {
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Node(SOURCE, 0));

        dist[SOURCE] = 0;
        while (settled.size() != V) {
            if(pq.isEmpty())
                return ;

            int u = pq.remove().node;


            settled.add(u);

            calculateWayToNeighbours(u);
        }
    }

    // функция считает пути до всех соседних верших у текушей вершины
    private void calculateWayToNeighbours(int u)
    {
        int edgeDistance = -1;
        int newDistance = -1;

        for (int i = 0; i < map.get(u).size(); i++) {
            Node v = map.get(u).get(i);

            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }

    public int getBestWay(){
        dijkstra();
        return dist[15];
    }

}