package com.rock.algorithm.string;

public class CountAndSay {
	
	private String END_FLAG = "#";
	
	// v1
	public String countAndSay(int n) {
		
		// condition of the recur'end
        if (n == 1) {
            return "1";
        }
        
        // get countAndSay
        String str = countAndSay(n-1) + END_FLAG;
        
        char[] cStr = str.toCharArray();
        int count = 1;
        StringBuilder s = new StringBuilder();
        for(int i = 0 ; i < cStr.length - 1 ; i++) {
            if (cStr[i] == cStr[i+1]) {
                count++;
            } else {
                s.append("" + count + cStr[i]);
                count = 1;
            }
        }
        
        return s.toString();
    }
	
	// realization of non-recur
	public String getCAS(String num) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < num.length()) {
            char ch = num.charAt(i);
            int count = 0;
            while (i < num.length() && ch == num.charAt(i)) {
                i++;
                count++;
            }
            result.append(count);
            result.append(ch);
        }
        return result.toString();
    }

    public String countAndSayV2(int n) {
        String result = "1";
        while (--n > 0) {
            result = getCAS(result);
        }
        return result;
    }
	
	// ì³²¨ÄÇÆõÊýÁÐ
	public int fab(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fab(n - 1) + fab(n - 2);
		}
	}
	
	public static void main(String [] args) {
		System.out.println(new CountAndSay().countAndSayV2(4));
	}

}
