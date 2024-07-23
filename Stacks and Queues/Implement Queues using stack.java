class MyQueue {
Stack<Integer> s1;
Stack<Integer> s2;
    public MyQueue() {
        s1=new  Stack<Integer>();
        s2=new Stack<Integer>();
    }
    
    public void push(int x) {
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty())
        {
            s1.push(s2.pop());

        }


    }
    
    public int pop() {
        int x=0;
        if(!s1.isEmpty())
        {
             x=s1.pop();
        }
        return x;
    }
    
    public int peek() {
        int x=0;
         if(!s1.isEmpty())
        {
             x=s1.peek();
        }
        return x;
    }
    
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
