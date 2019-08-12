package ru.geekbrains.datastructure.lesson3.stack;

public class Brackets {

    public static void main(String[] args) {
        String example = "    private static void addToStack(Stack<Integer> stack, int value) {        if (!stack.isFull()) {            stack.push(value);        }    }";
        new Brackets(example).check();
    }

    private final String text;

    public Brackets(String text) {
        this.text = text;
    }

    public void check() {
        Stack<Character> stack = new StackImpl<>(text.length());
        for (int index = 0; index < text.length(); index++) {
            char currentChar = text.charAt(index);
            checkCurrentChar(stack, index, currentChar);
        }

        if ( !stack.isEmpty() ) {
            System.out.println("Error: missing right delimiter");
        }
    }

    private void checkCurrentChar(Stack<Character> stack, int index, char currentChar) {
        switch (currentChar) {
            case '[':
            case '{':
            case '(':
            case '<':
                stack.push(currentChar);
                break;
            case ']':
            case '}':
            case ')':
            case '>':
                if (stack.isEmpty()) {
                    System.out.println("Error: " + currentChar + " at " + index);
                    break;
                }

                Character lastOpenedBracket = stack.pop();
                if (lastOpenedBracket == '[' && currentChar != ']' ||
                        lastOpenedBracket == '{' && currentChar != '}' ||
                        lastOpenedBracket == '(' && currentChar != ')' ||
                        lastOpenedBracket == '<' && currentChar != '>'
                ) {
                    System.out.println("Error: " + currentChar + " at " + index);
                }
            default:
                break;
        }
    }

}
