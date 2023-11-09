package com;

public class BugEx {

    private static final String CONSTANT_STRING = "unused"; // 未使用的私有字段

    public static int divide(int a, int b) {
        // 没有检查除数是否为0，可能会导致运行时异常 ArithmeticException
        return a / b;
    }

    public static void main(String[] args) {
        // 调用 divide 方法时，没有对除数为0的情况做处理
        System.out.println(divide(10, 0));
    }
}
