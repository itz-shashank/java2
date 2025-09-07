import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Pair {
    int dist;
    int node;
    Pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class Dijkstra {

    public static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        dis[s] = 0;
        pq.add(new Pair(0, s));
        
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int d = curr.dist;
            int n = curr.node;
            
            for (ArrayList<Integer> edge : adj.get(n)) {
                int neighbor = edge.get(0);
                int weight = edge.get(1);
                
                if (d + weight < dis[neighbor]) {
                    dis[neighbor] = d + weight;
                    pq.add(new Pair(dis[neighbor], neighbor));
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        int V = 3, S = 2;

        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1); add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2); add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2); add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0); add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1); add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0); add(6);}};
        
        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>() {{
            add(node1);
            add(node2);
        }};
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>() {{
            add(node3);
            add(node4);
        }};
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>() {{
            add(node5);
            add(node6);
        }};
        
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>() {{
            add(inter1); // for 0th node
            add(inter2); // for 1st node
            add(inter3); // for 2nd node
        }};
       
        int[] res = dijkstra(V, adj, S);
        
        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
