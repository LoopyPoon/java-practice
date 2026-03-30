package com.iholin.collections.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackPractice {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("Ваня");
        stack.push("Петя");
        stack.push("Маша");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.offerFirst("Дима");
        stack.offerFirst("Ксюша");
        stack.offerLast("Яна");

        System.out.println(stack.pollFirst());
        System.out.println(stack.pollLast());
        System.out.println(stack.peekFirst());
        System.out.println(stack.peekLast());

    }
}
