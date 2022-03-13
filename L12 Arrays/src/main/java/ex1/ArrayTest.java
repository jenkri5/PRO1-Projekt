package ex1;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] b = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30};
        int[] c = new int[10];
        for (int i = 0; i < c.length; i++) {
            c[i] = i;
        }
        int[] d = new int[10];
        int temp = 0;
        for (int i = 0; i < d.length; i++) {
            temp += 2;
            d[i] = temp;
        }
        int[] e = new int[10];
        for (int i = 0; i < e.length; i++) {
            e[i] = (i+1)*(i+1);
        }
        int[] f = new int[10];
        for (int i = 0; i < f.length; i++) {
            f[i] = i%2;
        }
        int[] g = new int[10];
        for (int i = 0; i < g.length; i++) {
            if (i >= 5)
                g[i] = i - 5;
            else
                g[i] = i;
        }
        int[] h = new int[10];
        temp = 0;
        for (int i = 0; i < h.length; i++) {
            if (i==0)
                h[i] = temp;
            else if (i%2==0)
                h[i] = temp += 1;
            else
                h[i] = temp += 3;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(e));
        System.out.println(Arrays.toString(f));
        System.out.println(Arrays.toString(g));
        System.out.println(Arrays.toString(h));
    }

}
