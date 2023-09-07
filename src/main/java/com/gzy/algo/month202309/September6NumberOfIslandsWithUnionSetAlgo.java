package com.gzy.algo.month202309;

public class September6NumberOfIslandsWithUnionSetAlgo {


    public class UnionSet{
        int count;

        int[] nodeParent;
        int[] nodeSetSize;


        public UnionSet(char[][] grid){
            int n = grid.length;
            int m = grid[0].length;
            nodeParent = new int[m * n];
            nodeSetSize = new int[m * n];
            for (int i = 0; i < n; i ++) {
                for(int j = 0; j < m; j++){
                    int val = i * m + j;
                    if (grid[i][j] == '1'){
                        nodeParent[val] = val;
                        nodeSetSize[val] = 1;
                        count++;
                    }

                }
            }
        }

        public int find(int i){
            // space compression
            if (nodeParent[i] != i){
                nodeParent[i] = find(nodeParent[i]);
            }
            return nodeParent[i];
        }

        public void union(int x, int y){
            int xParent = find(x);
            int yParent = find(y);
            if (xParent != yParent){
                if (nodeSetSize[xParent] >= nodeSetSize[yParent]){
                    nodeParent[yParent] = xParent;
                    nodeSetSize[xParent]++;
                }else {
                    nodeParent[xParent] = yParent;
                    nodeSetSize[yParent]++;
                }
                count--;
            }
        }
    }

    public int numsIslands(char[][] grid){
        UnionSet unionSet = new UnionSet(grid);
        int n = grid.length;
        int m = grid[0].length;
        for (int row = 0; row < n; row++){
            for (int col = 0 ; col < m; col++){
                if (grid[row][col] == '1'){
                    int index = row * m + col;
                    if (row > 0 && grid[row - 1][col] == '1'){
                        unionSet.union((row - 1) * m + col, index);
                    }
                    if (col > 0 && grid[row][col - 1] == '1'){
                        unionSet.union(row * m + col - 1, index);
                    }
                    if (col < m - 1 && grid[row][col + 1] == '1'){
                        unionSet.union(row * m + col + 1, index);
                    }
                    if (row < n - 1 && grid[row + 1][col] == '1'){
                        unionSet.union((row + 1)* m + col, index);
                    }
                }
            }
        }

        return unionSet.count;
    }
}
