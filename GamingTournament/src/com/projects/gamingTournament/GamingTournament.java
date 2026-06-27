package com.projects.gamingTournament;

import java.util.ArrayList;
import java.util.List;

public class GamingTournament {

    public List<Integer> entranceCode(List<Integer> playerId, List<Integer> regNum, int p) {
        int[] a = playerId.stream().mapToInt(i -> i).toArray();
        int[] b = regNum.stream().mapToInt(i -> i).toArray();
        int[] best = new int[p];

        for (int i = Math.max(0, p - b.length); i <= Math.min(p, a.length); i++) {
            int[] x = maxSub(a, i);
            int[] y = maxSub(b, p - i);
            int[] z = merge(x, y, p);
            if (greater(z, 0, best, 0)) best = z;
        }

        List<Integer> ans = new ArrayList<>();
        for (int num : best) ans.add(num);
        return ans;
    }

    private int[] maxSub(int[] arr, int k) {
        int[] st = new int[k];
        int top = -1, rem = arr.length;
        for (int n : arr) {
            while (top >= 0 && st[top] < n && rem > k - top - 1) top--;
            if (top + 1 < k) st[++top] = n;
            rem--;
        }
        return st;
    }

    private int[] merge(int[] a, int[] b, int k) {
        int[] m = new int[k];
        for (int i = 0, j = 0, t = 0; t < k; t++)
            m[t] = greater(a, i, b, j) ? a[i++] : b[j++];
        return m;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) { i++; j++; }
        return j == b.length || (i < a.length && a[i] > b[j]);
    }
}
