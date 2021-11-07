package bfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
  // topological sort using BFS
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList<Integer>[] graph = new ArrayList[numCourses];
    int[] indegeree = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph[i] = new ArrayList();
    }
    // build graph
    for (int[] e : prerequisites) {
      graph[e[1]].add(e[0]);
      indegeree[e[0]]++;
    }

    //BFS
    Queue<Integer> q = new LinkedList<>();
    for (int in : indegeree) {
      if (in == 0) q.offer(in);
    }
    int count = 0;
    while (!q.isEmpty()) {
      //int size = q.size();
      int cur = q.poll();
      count++;
      for (int neighbor : graph[cur]) {
        if (--indegeree[neighbor] == 0) q.offer(neighbor);
      }
    }
    return count == numCourses;
  }

  @Test
  public void testCourse() {
    int num = 2;
    int[][] e = new int[][] {{1,0}};
    Assert.assertTrue(canFinish(num, e));
  }

  @Test
  public void testCourse2() {
    int num = 2;
    int[][] e = new int[][] {{0, 1}};
    Assert.assertTrue(canFinish(num, e));
  }

  public boolean canFinish2(int numCourses, int[][] prerequisites) {
    ArrayList<Integer>[] graph = new ArrayList[numCourses];
    int[] indegree = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph[i] = new ArrayList();
    }
    // build graph
    for (int[] e : prerequisites) {
      graph[e[1]].add(e[0]);
      indegree[e[0]]++;
    }

    //BFS
    ArrayList<Integer> bfs = new ArrayList();
    for (int i = 0; i < numCourses; ++i) if (indegree[i] == 0) bfs.add(i);
    for (int i = 0; i < bfs.size(); ++i)
      for (int j: graph[bfs.get(i)])
        if (--indegree[j] == 0) bfs.add(j);
    return bfs.size() == numCourses;
  }


}
