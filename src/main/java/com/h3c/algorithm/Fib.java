package com.h3c.algorithm;

/**
 * @author yudi
 * @date 2020-02-06 20:20
 * Description: 给定一个斐波那契数列，求第n项的值
 * <p>
 * 斐波那契数列：每一项等于前两项之和 ---> f(n) = f(n-1) + f(n-2)
 *
 * 0 1 1 2 3 5 8 13
 * <p>
 * 实现方式：1，递归实现
 *              --- 时间复杂度 ：O(2^n)
 *         2，迭代实现
 *              --- 时间复杂度： O(n)
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(fib2(0));
        System.out.println(fib2(1));
        System.out.println(fib2(2));
        System.out.println(fib2(3));
        System.out.println(fib2(4));
        System.out.println(fib2(5));
        System.out.println(fib2(6));
        System.out.println(fib2(7));
    }

    /**
     * Description 递归实现斐波那契数列
     * 递归的优缺点：
     * -- 优点： 简洁，在树当中先序，后序，中序的遍历较为方便
     * -- 缺点： 1,递归由于是函数调用自身，而函数调用是有时间和空间的消耗的：每一次函数调用，都需要在内存栈中分配空间以保存参数、返回地址以及临时变量，
     * 而往栈中压入数据和弹出数据都需要时间。->效率较差
     * 2,递归中很多计算都是重复的，由于其本质是把一个问题分解成两个或者多个小问题，多个小问题存在相互重叠的部分，则存在重复计算，
     * 如fibonacci斐波那契数列的递归实现。->效率较差
     * f(n) = f(n-1) + f(n-2)
     * f(n-1) = f(n-2) + f(n-3)
     * f(n-2) = f(n-3) + f(n-4)
     * 我们要算出f(n)的值 需要算出f(n-1)和f(n-2)，在计算f(n-1)和f(n-2)时，同时用到了f(n-3),使用递归时算了两遍f(n-3)，所以效率较差
     * 3,调用栈可能会溢出，其实每一次函数调用会在内存栈中分配空间，
     * 而每个进程的栈的容量是有限的，当调用的层次太多时，就会超出栈的容量，从而导致栈溢出。->性能较差
     *
     * @param n 第n项
     * @return 第n项的值
     */
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }


    /**
     * Description 迭代实现斐波那契数列
     * @param n 第n项
     * @return 第n项的值
     */
    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

}
