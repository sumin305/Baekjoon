import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R, C, maxCount;
	static char[][] board;
	static boolean[] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[26];
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		visited[board[0][0] - 'A'] = true;
		DFS(0, 0, 1);
		System.out.println(maxCount);		
	}
	
	public static void DFS(int x, int y, int count) {
		maxCount = Math.max(maxCount,  count);
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if (!visited[board[nx][ny] - 'A']) {
					visited[board[nx][ny] - 'A'] = true;
					DFS(nx, ny, count + 1);
					visited[board[nx][ny] - 'A'] = false;
				}
			}
		}
	}
}