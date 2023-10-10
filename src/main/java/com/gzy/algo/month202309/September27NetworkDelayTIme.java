package com.gzy.algo.month202309;

import java.util.Arrays;

public class September27NetworkDelayTIme {

    /**
     * You are given a network of n nodes, labeled form 1 to n. You are also given times, a list of
     * travel times as directed edges times[i] = (ui, vi, wi), where ui is source node, vi is the target node,
     * and wi is the time it takes for a signal to travel from source node to the target node.
     *
     * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
     * If it's impossible for all the n nodes to receive the signal, return -1.
     *
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k){
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times){
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i){
            int x = -1;
            for (int y = 0; y < n; ++y){
                if (!used[y] && (x == -1 || dist[y] < dist[x])){
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y){
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF? -1 : ans;
    }

}
