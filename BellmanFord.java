import java.util.ArrayList;
import java.util.Arrays;

class BellmanFord{
public static void BellmenFord(int v,int s,ArrayList<ArrayList<Integer>> edges,int[] dist){
    dist[s]=0;
    for(int i=0;i<v-1;i++){
        for(ArrayList<Integer> edge:edges){
            if(dist[edge.get(0)]!=Integer.MAX_VALUE && dist[edge.get(0)]+edge.get(2)<dist[edge.get(1)]){
                dist[edge.get(1)]=dist[edge.get(0)]+edge.get(2);
            }
        }
    }
     for(ArrayList<Integer> edge:edges){
            if(dist[edge.get(0)]!=Integer.MAX_VALUE && dist[edge.get(0)]+edge.get(2)<dist[edge.get(1)]){
               Arrays.fill(dist,-1);
            }
        }

}

    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
    };
    int[] dist=new int[V];
    Arrays.fill(dist,Integer.MAX_VALUE);
    BellmenFord(V,S,edges,dist);
    for(int i:dist){
        System.out.print(i+" ");
    }
}
}