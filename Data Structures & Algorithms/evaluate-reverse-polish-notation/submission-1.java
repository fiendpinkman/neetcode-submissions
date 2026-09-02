class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();
        for(String token: tokens) {
            if (token.equals("+") || token.equals("-")
                || token.equals("*") || token.equals("/")){
                int secondNumber = Integer.parseInt(s.pop());
                int firstNumber = Integer.parseInt(s.pop());
                int finalOp = performOpertaion(token, firstNumber, secondNumber);
                s.push(String.valueOf(finalOp));
            } else {
                s.push(token);
            }
        }
        return Integer.parseInt(s.pop());
    }

    public static int performOpertaion(String token, int firstNumber, int secondNumber) {
        int finalOp = 0;
        switch(token) {
            case "+":
                finalOp = firstNumber + secondNumber;
                break;
            case "-":
                finalOp = firstNumber - secondNumber;
                break;  
            case "*":
                finalOp = firstNumber * secondNumber;
                break; 
            case "/":
                finalOp = firstNumber / secondNumber;
                break;
        }
        return finalOp;
    }
}
