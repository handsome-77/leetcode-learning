package medium.to1000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution207 {

	public List<List<Integer>> edges;
	public int[] visited;
	public boolean valid;
	public int[] inDegrade;
	
	/**
	 * v2.0
	 * 广度优先搜索，拓扑排序，查看是否存在环
	 * 出度，入度，队列
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<List<Integer>>();
		for(int i=0; i<numCourses; i++) {
			edges.add(new ArrayList<Integer>());
		}
		inDegrade = new int[numCourses];
		for(int[] temp:prerequisites) {
			edges.get(temp[1]).add(temp[0]);
			inDegrade[temp[0]]++;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<numCourses; i++) {
			if(inDegrade[i]==0) {
				queue.offer(i);
			}
		}
		int visited=0;
		while(!queue.isEmpty()) {
			++visited;
			int poll = queue.poll();
			for(int v:edges.get(poll)) {
				inDegrade[v]--;
				if(inDegrade[v]==0) {
					queue.offer(v);
				}
			}
		}
		return visited==numCourses;
	}
	
	/**
	 * v1.0
	 * 深度优先搜索，拓扑排序，查看是否有环
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish1(int numCourses, int[][] prerequisites) {
		valid=true;
		edges = new ArrayList<List<Integer>>();
		for(int i=0; i<numCourses; i++) {
			edges.add(new ArrayList<Integer>());
		}
		visited = new int[numCourses];
		for(int[] temp:prerequisites) {
			edges.get(temp[1]).add(temp[0]);
		}
		for(int i=0; i<numCourses && valid; i++) {
			if(visited[i]==0) {
				dfs(i);
			}
		}
		return valid;
	}
	public void dfs(int i) {
		visited[i]=1;
		for(int v:edges.get(i)) {
			if(visited[v]==0) {
				dfs(v);
				if(!valid) {
					return;
				}
			}else if(visited[v]==1) {
				valid=false;
				return;
			}
		}
		visited[i]=2;
	}
}
