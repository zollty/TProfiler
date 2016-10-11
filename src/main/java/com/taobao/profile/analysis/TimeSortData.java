/**
 * (C) 2011-2012 Alibaba Group Holding Limited.
 * <p>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation.
 */
package com.taobao.profile.analysis;

import java.util.Stack;

/**
 * 可排序数据对象
 *
 * @author shutong.dy
 * @since 2012-1-11
 */
public class TimeSortData implements Comparable<TimeSortData> {

    private long sum = 0;
    private String methodName;
    private Stack<Long> valueStack = new Stack<>();

    public TimeSortData() {}

    public TimeSortData(String methodName) {
        this.methodName = methodName;
    }

    /**
     * @return the methodName
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * @param methodName the methodName to set
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * @return the valueStack
     */
    public Stack<Long> getValueStack() {
        return valueStack;
    }

    /**
     * @param useTime
     */
    public void addStackValue(long useTime) {
        valueStack.add(useTime);
        sum += useTime;
    }

    /**
     * @return the sum
     */
    public long getSum() {
        return sum;
    }

    public int compareTo(TimeSortData o) {
        return Long.compare(o.sum, this.sum);
    }
}
