public class Strings {

    public static boolean isPalindrome(String s) {
         int st = 0 , end = s.length()-1;

        while(st < end ) {

            while( st < end && !Character.isLetterOrDigit(s.charAt(st))) {
                st++;
            }

            while( st < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            while(Character.toLowerCase(s.charAt(st)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            st++;
            end--;
        }
    return true;
}

    public static float  shortestPath(String path) {
        int n = path.length();
        int x = 0 , y =0;

        for(int i=0; i<n; i++) {
            switch (path.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
            }
        }
        return (float) Math.sqrt(x*x + y*y);
    }

    public static String largestSting(String[] fruits) {
        String largest = fruits[0];

        for(int i=1; i<fruits.length; i++) {
            if(largest.compareTo(fruits[i])<0) {
                largest = fruits[i];
            }
        }
        return largest;
    }

    public static String toUpperCase(String str) {
    
        StringBuilder sb = new StringBuilder();

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == ' ' && i< str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compression(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            sb.append(str.charAt(i));
            int count =1;
            while(i<str.length()-1 &&str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            if(count>1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }
    
    public static String reverseString(String str) {
            int n = str.length();
            StringBuilder ans= new StringBuilder();

            StringBuilder s = new StringBuilder(str).reverse();

            for(int i=0; i<n; i++) {
                StringBuilder word = new StringBuilder();
                while(i<n && s.charAt(i) != ' ') {
                    word.append(s.charAt(i));
                    i++;
                }

               word.reverse(); 
               if(word.length() > 0) {
                    ans.append(" "+ word);
               }
            }

            return ans.substring(1);
    } 

    
    public static void main(String[] args) {
        String str = "the pen";
        
        System.out.println(reverseString(str));
    
    }
}