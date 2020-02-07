public class EstimatePI {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int hits = 0;
        for (int t = 0; t < T; t++) {
            double x = StdRandom.uniform(0.0, 1.0);
            double y = StdRandom.uniform(0.0, 1.0);
            if (x*x + y*y <= 1.0) hits++;
        }
        StdOut.println(hits*4.0/T);
    }
}
