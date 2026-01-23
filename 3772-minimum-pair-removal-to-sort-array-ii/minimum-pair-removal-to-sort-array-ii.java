class Solution {
    static class Node {
        long val;
        int idx;
        Node prev, next;
        boolean alive = true;
        Node(long v, int i) {
            val = v;
            idx = i;
        }
    }

    static class Pair {
        long sum;
        int idx;
        Node left;
        Pair(long s, int i, Node l) {
            sum = s;
            idx = i;
            left = l;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(nums[i], i);
        for (int i = 0; i < n; i++) {
            if (i > 0) nodes[i].prev = nodes[i - 1];
            if (i + 1 < n) nodes[i].next = nodes[i + 1];
        }

        java.util.PriorityQueue<Pair> pq = new java.util.PriorityQueue<>(
            (a, b) -> a.sum == b.sum ? Integer.compare(a.idx, b.idx) : Long.compare(a.sum, b.sum)
        );

        for (int i = 0; i + 1 < n; i++) {
            pq.offer(new Pair(nodes[i].val + nodes[i + 1].val, i, nodes[i]));
        }

        int ops = 0;

        while (true) {
            boolean ok = true;
            Node cur = nodes[0];
            while (cur != null && cur.next != null) {
                if (cur.val > cur.next.val) {
                    ok = false;
                    break;
                }
                cur = cur.next;
            }
            if (ok) break;

            Pair p;
            while (true) {
                p = pq.poll();
                if (p == null) return ops;
                Node l = p.left;
                if (l.alive && l.next != null && l.next.alive && l.val + l.next.val == p.sum) break;
            }

            Node a = p.left;
            Node b = a.next;

            a.val += b.val;
            b.alive = false;

            a.next = b.next;
            if (b.next != null) b.next.prev = a;

            if (a.prev != null) {
                pq.offer(new Pair(a.prev.val + a.val, a.prev.idx, a.prev));
            }
            if (a.next != null) {
                pq.offer(new Pair(a.val + a.next.val, a.idx, a));
            }

            ops++;
        }

        return ops;
    }
}
