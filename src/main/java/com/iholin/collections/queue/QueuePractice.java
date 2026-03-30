package com.iholin.collections.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuePractice {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Ваня");
        queue.offer("Петя");
        queue.offer("Маша");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());


        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        System.out.println(pq);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
