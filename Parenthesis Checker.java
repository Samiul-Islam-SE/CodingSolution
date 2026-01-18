class Solution {
    private boolean isSame(char a, char b) {
        if((a == '(' && b== ')') || (a == '{' && b== '}') || (a == '[' && b== ']')) {
            return true;
        }
        return false;
    }
    
    private boolean isStartingBrace(char a) {
        return (a == '(' || a == '{' || a == '[');
    }
    public boolean isBalanced(String s) {
        // code here
        Stack<Character> S = new Stack<>();
        for(char c: s.toCharArray()) {
            if(isStartingBrace(c)) {
                S.push(c);
            } else if(!S.empty() && isSame(S.peek(), c)) {
                S.pop();
            } else {
                return false;
            }
        }
        
        if(!S.empty()) {
            return false;
        }
        return true;
        
    }
}
