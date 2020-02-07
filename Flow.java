public class Flow {
    public static boolean[][] flow(boolean[][] isOpen) {
        int N = isOpen.length;
        boolean[][] isFull = new boolean[N][N];
        for (int j = 0; j < isOpen.length; j++)
            flow(isOpen, isFull, 0, j);
        return isFull;
    }
    public static void flow(boolean[][] isOpen,
                            boolean[][] isFull, int i, int j) {
        int N = isOpen.length;
        if (i < 0 || i >= N) return;
        if (j < 0 || j >= N) return;
        if (!isOpen[i][j])   return;
        if (isFull[i][j])    return;

        isFull[i][j] = true;
        flow(isOpen, isFull, i+1, j);
        flow(isOpen, isFull, i+1, j+1);
        flow(isOpen, isFull, i+1, j-1);
    }
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        boolean[][] isOpen = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                isOpen[i][j] = StdRandom.bernoulli(p);
                StdOut.print((isOpen[i][j]? 1: 0) + " ");
            }
            StdOut.println();
        }
        for (int i = 0; i < N; i++)
            StdOut.print("--");
        StdOut.println();

        boolean[][] isFull = flow(isOpen);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                StdOut.print((isFull[i][j]? 1: 0) + " ");
            StdOut.println();
        }
    }
}
