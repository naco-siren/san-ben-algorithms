package java_lang;

import java.util.PriorityQueue;

/**
 * Created by naco_siren on 8/22/17.
 */
public class queue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(3);
        pq.offer(6);
        pq.offer(2);
        pq.offer(5);
        pq.offer(4);
        pq.offer(1);

        int i1 = pq.poll();
        int i2 = pq.poll();
        int i3 = pq.poll();

        int i4 = pq.peek();
        return;
    }

}
