package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        if (args.length <= 2) {
            System.out.println("Arguments missing");
            return;
        }
        int n = Integer.parseInt(args[0]);
        List<Double> weight = new ArrayList<Double>();  // cumulative weight
        weight.add(0.0);
        for (int i = 1 ; i < args.length - 1; i++) {
            weight.add(Double.parseDouble(args[i]) + weight.get(i-1));
        }

        int[] count = new int[weight.size()];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            double curr = rand.nextDouble();
            int bin = binarySearch(weight, curr);
            count[bin]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }

    private static int binarySearch(List<Double> list, double target) {
        int l = 0, r = list.size() - 1;
        if (target >= list.get(r)) {
            return r;
        }
        while(r - l > 1) {
            int m = l + (r - l) / 2;
            if(list.get(m) == target) {
                return m;
            } else if(list.get(m) > target) {
                r = m;
            } else {
                l = m;
            }
        }
        return l;
    }
}