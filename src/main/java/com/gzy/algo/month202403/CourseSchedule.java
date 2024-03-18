package com.gzy.algo.month202403;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    /**
     * There a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an
     * array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course  bi first
     * if you want to take ai course
     *
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */

    List<List<Integer>> edges;
    int[] visited;
    boolean valid;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        visited = new int[numCourses];
        for (int i = 0 ; i < numCourses; i++){
            edges.add(new ArrayList<Integer>());
        }
        for (int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
        }

        for (int i = 0; i < numCourses && valid; i++){
            if (visited[i] == 0){
                dfs(i);
            }
        }

        return valid;

    }

    private void dfs(int i) {

         visited[i] = 1;
         for (int to : edges.get(i)){
             if (visited[to] == 1){
                 valid = false;
                 return;
             }else if(visited[to] == 0) {
                 dfs(to);
                 if(!valid){
                     return;
                 }
             }
         }
         visited[i] = 2;
    }


    public static void main(String[] args) {
        int[] ints = new int[2];
        for (int num : ints){
            System.out.println(num);
        }
    }
}
