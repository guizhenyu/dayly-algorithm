package com.gzy.algo.month202403;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public int[] canFinishII(int numCourses, int[][] prerequisites){
        int[] ans = new int[numCourses];
        // 记录每个点又几个入度的点
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        // 每个点入度的值
        int[] in = new int[numCourses];
        
        for (int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
            in[info[0]]++;
        }
        // 选取入度为0的点
        // 用数组模拟队列
        int[] queue = new int[numCourses];
        int l = 0, r = 0;// 代表队列的左右边界，是左闭右开
        for (int i = 0; i < numCourses; i++){
            if (in[i] == 0){
                queue[r++] = i;
            } 
        }
        int index = 0;
        while (l != r){
            int i = queue[l++];
            ans[index++] = i;
            List<Integer> nexts = edges.get(i);
            for(Integer next : nexts){
                if (--in[next] == 0){
                    queue[r++] = next;
                }
            }
        }

        return index == numCourses? ans : new int[]{};
    }


    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] array = {{1, 0}};
        int[] ints = courseSchedule.canFinishII(2, array);
        for (int num : ints){
            System.out.println(num);
        }
    }


    public boolean canFinishWith(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        int[] in = new int[numCourses];
        for (int[] info : prerequisites){
            int to = info[0];
            int from = info[1];

            edges.get(from).add(to);
            in[to]++;
        }


        int[] zero = new int[numCourses];
        int l = 0, r = 0;
        for (int i = 0; i < numCourses; i++){
            if (in[i] == 0){
                zero[r++] = i;
            }
        }
        int zeroInCount = 0;

        while (l != r){
            zeroInCount++;
            List<Integer> nexts = edges.get(zero[l++]);

            for (Integer next : nexts){
                if (--in[next] == 0){
                    zero[r++] = next;
                }
            }
        }
        return zeroInCount == numCourses;
    }







    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        visited = new int[numCourses];
        for (int i = 0 ; i < numCourses; i++){
            edges.add(new ArrayList<Integer>());
        }
        for (int[] info : prerequisites){
            edges.get(info[0]).add(info[1]);
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




}
