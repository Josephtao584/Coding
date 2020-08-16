package template;

public class KMP {
    public int[] getNext(String s){
        int n = s.length();
        int[] next = new int[n + 1];
        int j = 0, k = -1;
        while (j < s.length()){
            if(k == -1 || s.charAt(j) == s.charAt(k)){
                j++;
                k++;
                next[j] = k;
            }else {
                k = next[k];
            }
        }
        return next;
    }
        public int compare(String s, String t){
            int[] next = getNext(t);
            int index = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == t.charAt(index)){
                    index++;
                }
                else {
                    index = next[index] == -1 ? 0 : next[index];
                }
                if(index == t.length()){
                    count++;
                    index = next[index];
                }
            }
            return count;
    }

    public static void main(String[] args) {
        System.out.println(new KMP().compare("aaaaaa", "aaa"));
    }
}
