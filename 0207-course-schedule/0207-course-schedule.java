import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Initialize the adjacency list graph and the indegree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        
        // Step 2: Build the graph
        // prerequisites[i] = [course, prerequisite] -> pre -> course
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        
        // Step 3: Push all courses with 0 prerequisites into the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // Step 4: Process the nodes level by level
        int completedCoursesCount = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completedCoursesCount++;
            
            // Reduce the indegree for all dependent child courses
            for (int neighbor : adj.get(currentCourse)) {
                indegree[neighbor]--;
                // If all prerequisites are cleared, add it to the queue
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // Step 5: If we completed all courses, no cycle exists
        return completedCoursesCount == numCourses;
    }
}