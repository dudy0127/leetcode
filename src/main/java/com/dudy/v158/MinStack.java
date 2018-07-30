package com.dudy.v158;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 *
 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。
 示例:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.getMin();   --> 返回 -2.
 *
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class MinStack {


    private Integer min;

    private List<Integer> data;

    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayList<Integer>();
    }
    
    public void push(Integer x) {
        data.add(x);

        if(min == null || x.compareTo(min) < 0){
            min = x;
        }
    }
    
    public void pop() {
        if(data == null || data.size() == 0){
            return;
        }
        Integer remove = data.remove(data.size() - 1);

        if(remove.equals(min)){
            setMin();
        }
    }

    private void setMin() {

        Optional<Integer> optional = data.stream().min(Integer::compareTo);
        if (optional.isPresent()){
            min = optional.get();
        } else {
            min = null;
        }
    }

    public Integer top() {
        if(data == null || data.size() == 0){
            return null;
        }
        return data.get(data.size() -1);
    }
    
    public Integer getMin() {
        return min;
    }

    public static void main(String[] args) {
//        MinStack minStack = new MinStack();
//        minStack.push(1);
//        minStack.push(2);
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.getMin());
//        System.out.println(minStack.top());

    }

}
