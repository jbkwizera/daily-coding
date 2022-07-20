public class MatrixMaxPath {
	public static void main(String[] args) {

		// Read matrix from a file
		int[][] a = {
				{0, 3, 1, 1},
				{2, 0, 0, 4},
				{1, 5, 3, 1}
		};
		/**
		 * The recurrence relation giving the solution is
		 * m[i][j] = a[i][j] + max(m[i-1][j], a[i][j-1]). Since we visit each of 
		 * the elements using 2 for-loops, the runtime is O(MN). We use extra space
		 * for m to hold (M+1)*(N+1) integers, so the space complexity is O(MN). 
		 * A brute force solution would be to check every possible path from top left
		 * to bottom right. The runtime is exponential, from the solution to the 
		 * recurrence f(M, N) = f(M-1, N) + f(M, N-1) (you either go down or right)
		 * O(f(M, N)) ~ O(2^min(M, N))... min(M, N) because we stop as soon as there is
		 * only one row or one column.
		 **/
		int M = a.length;
		int N = a[0].length;

		int [][] m = new int[M+1][N+1];
		for (int i = 1; i <= M; i++)
			for (int j = 1; j <= N; j++)
				m[i][j] = a[i-1][j-1] + Math.max(m[i-1][j], m[i][j-1]);

		System.out.println("The maximum path sum is: " + m[M][N]);
	}
}



