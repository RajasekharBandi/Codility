import java.util.*;

/*
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class Brackets {
	
	 public int solution(String S) {
	        if (S.isEmpty()) return 1;
	        
	        Stack<Character> stack = new Stack<>();
	        
	        for (int i = 0; i < S.length(); i++) {
	            char bracket = S.charAt(i);
	            
	            if (bracket == '(' || bracket == '{' || bracket == '[') {
	                stack.push(bracket);
	            } else {
	                if (stack.isEmpty()) return 0;
	                
	                switch (bracket) {
	                    case ')':
	                        if (stack.peek() != '(') {
	                            return 0;
	                        } else {
	                            stack.pop();
	                            break;
	                        }
	                    case '}':
	                        if (stack.peek() != '{') {
	                            return 0;
	                        } else {
	                            stack.pop();
	                            break;
	                        }
	                    case ']':
	                        if (stack.peek() != '[') {
	                            return 0;
	                        } else {
	                            stack.pop();
	                            break;
	                        }
	                }
	            }
	        }
	        
	        return (stack.isEmpty() ? 1 : 0);
	    }
	 
	 public static int solution2(String expression) {
	        if (expression.isEmpty()) return 1;
	        Map<Character, Character> map = new HashMap<>();
	        map.put(')', '(');
	        map.put(']', '[');
	        map.put('}', '{');
	        Stack<Character> stack = new Stack();
	        for (char c : expression.toCharArray()) {
	            if (map.containsKey(c) && !stack.isEmpty()) {
	                char stackChar = stack.pop();
	                if (stackChar != map.get(c)) {
	                    return 0;
	                }
	            } else {
	                stack.push(c);
	            }
	        }
	        if (!stack.isEmpty()) {
	            return 0;
	        }
	        return 1;
	    }
	 public static int solution3(String s) {//Codility-solutions

			Stack<Character> st = new Stack<Character>();
			for (Character ch : s.toCharArray()) {

				if (ch == '{' || ch == '(' || ch == '[') {
					st.push(ch);
				} else {

					if (st.isEmpty()) {
						return 0;
					}

					char top = st.pop();
					if (!isMatchingPair(top, ch)) {
						return 0;
					}
				}
			}

			int result = st.isEmpty() ? 1 : 0;
			return result;
		}

		public static boolean isMatchingPair(char left, char right) {
			if (left == '{' && right == '}') {
				return true;
			} else if (left == '[' && right == ']') {
				return true;
			} else if (left == '(' && right == ')') {
				return true;
			} else {
				return false;
			}
		}

		public int solution4(String S) {//Codility-lessons
	        Stack<Character> stack = new Stack<Character>();
	        if (null == S) {
	            return 0;
	        } else if (S.isEmpty()) {
	            return 1;
	        }
	        for (Character C : S.toCharArray()) {

	            switch (C) {
	                case ')':
	                    pops(stack, '(');
	                    break;
	                case '}':
	                    pops(stack, '{');
	                    break;
	                case ']':
	                    pops(stack, '[');
	                    break;

	                default:
	                    stack.push(C);
	                    break;
	            }

	        }
	        return stack.isEmpty() ? 1 : 0;
	    }

	    private void pops(Stack<Character> s, Character C) {

	        while (!s.isEmpty() && s.peek() != C) {
	            s.pop();
	        }
	        if (!s.isEmpty()) {
	            s.pop();
	        } else {
	            s.push(C);
	        }
	    }
}
