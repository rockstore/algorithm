package com.rock.algorithm.string;

import java.util.HashSet;

public class StrStr {
	
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || needle.trim().length() < 1) {
			return 0;
		}
		char firstAtNeedle = needle.charAt(0);
		for (int i = 0 ; i < haystack.length() ; i++) {
			char ch = haystack.charAt(i);
			if (firstAtNeedle == ch && (needle.length() <= (haystack.length() - i))) {
				String tmp = haystack.substring(i, i + needle.length());
				if (needle.equals(tmp)) {
					return i;
				}
			}
		}
		return -1;
    }
	
	// java version
	public int indexOf(char[] source, int sourceOffset, int sourceCount,
            char[] target, int targetOffset, int targetCount,
            int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
	
	public static void main(String [] args) {
		String test = "a";
		String test2 = "a";
		test.indexOf(test2);
		HashSet<String> hs;
		System.out.println(new StrStr().strStr(test, test2));
	}
}
