package NumOfIslands;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {

  public static int[][] floydWarshall(int vertexNum, List<Integer[]> edgeInfos) {
    int[][] matrix = initializeMatrix(vertexNum, edgeInfos);
    for (int k = 1; k <= vertexNum; k++) {
      System.out.println("k = " + k + "\n");
      for (int i = 1; i <= vertexNum; i++) {
        for (int j = 1; j <= vertexNum; j++) {
          if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) {
            continue;
          }
          if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
            matrix[i][j] = matrix[i][k] + matrix[k][j];
            int ij = matrix[i][j], ik = matrix[i][k], kj = matrix[k][j];
            System.out.println("i=" + i +", j=" + j + " ,k=" + k );

//            System.out.println("update: matrix[i][j] = matrix[i][k] + matrix[k][j]");
//            String update = ij + " = " + ik " + " kj;
             System.out.println(ij + " = " + ik + " + " + kj);
          }
        }
      }
    }

    return matrix;
  }

  private static int[][] initializeMatrix(int vertexNum, List<Integer[]> edgeInfos) {
    // initialize the matrix
    int[][] matrix = new int[vertexNum + 1][vertexNum + 1];

    // the weight of one vertex to itself is 0
    // the weight from one vertex to another will be Integer.MAX_VALUE before calculation
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (i == j) {
          matrix[i][j] = 0;
        } else {
          matrix[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    // make the first row and first col as the vertex number
    for (int i = 1; i <= vertexNum; i++) {
      matrix[0][i] = i;
      matrix[i][0] = i;
    }

    // add known edge information into matrix
    for (Integer[] edgeInfo : edgeInfos) {
      int row = edgeInfo[0];
      int col = edgeInfo[1];
      int weight = edgeInfo[2];

      matrix[row][col] = weight;
    }
    return matrix;
  }

  private static void displayMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == Integer.MAX_VALUE) {
          System.out.print("?" + "    \t");
        } else {
          System.out.print(matrix[i][j] + "    \t");
        }
      }
      System.out.println("\t");
    }
  }

  public static void main(String[] args) {
    List<Integer[]> edgeInfos = new ArrayList<>();
    int vertexNum = 4;
//    edgeInfos.add(new Integer[]{1, 3, -2});
//    edgeInfos.add(new Integer[]{2, 1, 4});
//    edgeInfos.add(new Integer[]{2, 3, 3});
//    edgeInfos.add(new Integer[]{3, 4, 2});
//    edgeInfos.add(new Integer[]{4, 2, -1});

    edgeInfos.add(new Integer[]{1, 2, 3});
    edgeInfos.add(new Integer[]{2, 4, -2});
    edgeInfos.add(new Integer[]{4, 3, -1});
    edgeInfos.add(new Integer[]{3, 1, 2});
    edgeInfos.add(new Integer[]{1, 4, 4});

    int[][] matrix01 = initializeMatrix(vertexNum, edgeInfos);
    System.out.println("Original edge matrix: \n");
    displayMatrix(matrix01);
    System.out.println("\n");

    System.out.println("Updat steps");
    int[][] matrix = floydWarshall(vertexNum, edgeInfos);


    System.out.println("Shortest path of all edges: \n");
    displayMatrix(matrix);
  }
}
