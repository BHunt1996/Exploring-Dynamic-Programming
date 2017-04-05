public class Interleave {
    //given three strings: s1, s2, s3, determine if s3 can be formed
    //by interleaving s1 & s2
    public boolean isInterleaved(String s1, String s2, String s3) {
        if (s3 == null || (s1 == null && s2 == null) || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] DP = new boolean[s1.length() + 1][s2.length() + 1];
        DP[0][0] = true; //empty s1 and s2 would be a working case

        //with just s1:
        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && DP[i - 1][0]) {
                DP[i][0] = true;
            }
        }

        //with just s2:
        for (int j = 1; j <= s2.length(); j++) {
            if (s3.charAt(j - 1) == s2.charAt(j - 1) && DP[0][j - 1]) {
                DP[0][j] = true;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if ((s3.charAt(i + j - 1) == s1.charAt(i - 1) && DP[i - 1][j]) 
                    || (s3.charAt(i + j - 1) == s2.charAt(j - 1) && DP[i][j - 1])) {
                    DP[i][j] = true;
                }
            }
        }

        return DP[s1.length()][s2.length()];
    }
    
    public static void main(String args[]){
        String s1 = "XXY";
        String s2 = "XXZ";
        String s3 = "Hello";
        Interleave il = new Interleave();
        System.out.println(il.isInterleaved(s1, s2, s3));
    }
    
}
