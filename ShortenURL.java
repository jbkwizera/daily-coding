public class ShortenURL {
    private HashMap<String, String>  urls;
    private HashMap<String, String> parts;
    private final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private final String ALNUM = "0123456789" + ALPHA + ALPHA.toUpperCase();

    public ShortenURL() {
        urls  = new HashMap<String, String>();
        parts = new HashMap<String, String>();
    }
    public String shorten(String url) {
        int N = url.length();
        if (urls.containsKey(url))
            return urls.getValue(url);
        if (N <= 6) return url;

    }
    public static void main(String[] args) {

    }
}
