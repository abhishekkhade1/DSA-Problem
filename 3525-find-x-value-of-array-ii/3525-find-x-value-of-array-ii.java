class Solution {

    static class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            cnt = new int[k];
            prod = 1 % k;
        }
    }

    int n, k;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Persistent update
            update(1, 0, n - 1, index, value);

            // Query [start, n - 1]
            Node ans = query(1, 0, n - 1, start, n - 1);

            result[i] = ans.cnt[x];
        }

        return result;
    }

    // ---------------- BUILD ----------------

    void build(int node, int l, int r, int[] nums) {

        if (l == r) {
            tree[node] = new Node(k);

            int val = nums[l] % k;

            tree[node].prod = val;
            tree[node].cnt[val] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        tree[node] = merge(tree[node * 2],
                           tree[node * 2 + 1]);
    }

    // ---------------- MERGE ----------------

    Node merge(Node left, Node right) {

        Node res = new Node(k);

        // Product of complete segment
        res.prod = (int) ((long) left.prod * right.prod % k);

        // Prefixes completely inside left
        for (int r = 0; r < k; r++) {
            res.cnt[r] += left.cnt[r];
        }

        // Prefixes = entire left + prefix of right
        for (int r = 0; r < k; r++) {

            int newR =
                (int) ((long) left.prod * r % k);

            res.cnt[newR] += right.cnt[r];
        }

        return res;
    }

    // ---------------- UPDATE ----------------

    void update(int node, int l, int r,
                int index, int value) {

        if (l == r) {

            tree[node] = new Node(k);

            int val = value % k;

            tree[node].prod = val;
            tree[node].cnt[val] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r,
                   index, value);
        }

        tree[node] = merge(tree[node * 2],
                           tree[node * 2 + 1]);
    }

    // ---------------- QUERY ----------------

    Node query(int node, int l, int r,
               int ql, int qr) {

        // Completely inside range
        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = l + (r - l) / 2;

        // Entirely in left
        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        // Entirely in right
        if (ql > mid) {
            return query(node * 2 + 1,
                         mid + 1, r, ql, qr);
        }

        // Split between left and right
        Node left =
            query(node * 2, l, mid, ql, qr);

        Node right =
            query(node * 2 + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }
}