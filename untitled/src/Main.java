public class Main {
    public static void main(String[] args) {
        //System.out.print(Solution.mergeAlternately("abcg", "pqkj"));
        //System.out.print(Solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2, 5}, 2));
        //Solution.merge(new int[] {8, 9, 10, 0, 0, 0}, 3,new int[] {2,5,6}, 3);
        //System.out.print(Solution.reverseWords("the sky is blue"));
        //System.out.print(Solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    class Solution {
        public static String mergeAlternately(String word1, String word2) {
            StringBuilder res = new StringBuilder();
            int maxLen = word1.length();
            int minLen = word2.length();
            if (word1.length() < word2.length()) {
                maxLen = word2.length();
                minLen = word1.length();
            }
            for (int i = 0; i < maxLen; i++) {
                if (i < minLen) {
                    res = res.append(word1.charAt(i));
                    res = res.append(word2.charAt(i));
                } else if (i >= word1.length()) res = res.append(word2.charAt(i));
                else if (i >= word2.length()) res = res.append(word1.charAt(i));
            }
            return String.valueOf(res);
        }

        public static int removeElement(int[] nums, int val) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[j] = nums[i];
                    j += 1;
                }
            }
            return j;
        }

        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int copyInd = m + n - 1;
            m -= 1;
            n -= 1;
            while (n >= 0) {
                if (m >= 0) {
                    if (nums1[m] > nums2[n]) {
                        nums1[copyInd--] = nums1[m--];
                    } else if (nums1[m] < nums2[n]) {
                        nums1[copyInd--] = nums2[n--];
                    } else if (nums1[m] == nums2[n]) {
                        nums1[copyInd--] = nums1[m--];
                        nums1[copyInd--] = nums2[n--];
                    }
                } else {
                    nums1[copyInd--] = nums2[n--];
                }
            }
        }

        public static String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            int end = s.length() - 1;
            while (end >= 0) {
                if (s.charAt(end) == ' ') {
                    end -= 1;
                    continue;
                }
                int start = end - 1;
                while (start >= 0 && s.charAt(start) != ' ') {
                    start -= 1;
                }
                sb.append(" ");
                sb.append(s.substring(start + 1, end + 1));
                end = start - 1;
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }

        public static Boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;
            s = s.toLowerCase();
            while (right - left > 0) {
                if (Character.isLetterOrDigit(s.charAt(right)) == false) {
                    right -= 1;
                    continue;
                }
                while (Character.isLetterOrDigit(s.charAt(left)) == false) left += 1;
                if (s.charAt(right) != s.charAt(left)) {
                    return false;
                } else {
                    right -= 1;
                    left += 1;
                }
            }
            return true;
        }
    }
}