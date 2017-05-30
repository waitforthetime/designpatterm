package com.wy.study.java.leetcode;

import java.util.*;

/**
 * Created by wy_ms on 2017/05/29.
 */
public class Minimum_Genetic_Mutation {

    public int minMutation(String start, String end, String[] bank) {

        /**快一点*/
//        return findroute(start,end,bank, 0, new ArrayList<>());
        /**慢一点*/
        return findroute2(start,end,new ArrayList<>(Arrays.asList(bank)), 0, new ArrayList<>());
    }

    boolean isnext(String start, String next) {
        int route = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i)!=next.charAt(i)) {
                route++;
            }
            if (route>1) {
                return false;
            }
        }
        return route==1;
    }

    int findroute(String start, String end, String[] bank, int route, List<String> routes) {

        routes.add(start);
        int temroute = -1;
        for (int i = 0; i < bank.length; i++) {
            String next = bank[i];
            if (routes.contains(next)) {
                continue;
            }

            if (isnext(start,next)) {
                if (next.equals(end)) {
                    temroute = routes.size();
                    break;
                }
                if ((temroute==-1&&route==0)||route>routes.size()+1) {
                    int result = findroute(next, end, bank, route, routes);
                    if (result>0) {
                        temroute = route = result;
                    }
                }
            }

        }
        routes.remove(start);
        return temroute;
    }

    int findroute2(String start, String end, List<String> bank, int route, List<String> routes) {

        routes.add(start);
        int temroute = -1;
        for (String next : bank) {
            if (routes.contains(next)) {
                continue;
            }

            if (isnext(start,next)) {
                if (next.equals(end)) {
                    temroute = routes.size();
                    break;
                }
                if ((temroute==-1&&route==0)||route>routes.size()+1) {
                    List<String> newbank = new ArrayList<>(bank);
                    newbank.remove(next);
                    int result = findroute2(next, end, newbank, route, routes);
                    if (result>0) {
                        temroute = route = result;
                    }
                }
            }

        }
        routes.remove(start);
        return temroute;
    }




    public static void main(String[] args) {
        Minimum_Genetic_Mutation m = new Minimum_Genetic_Mutation();
        int route = m.minMutation("AACCGGTT","AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"});
        System.out.println(route);/**except：2*/
        assert route==2;
        route = m.minMutation("AAAACCCC","CCCCCCCC", new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"});
        System.out.println(route);
        assert route==4;

    }

}
