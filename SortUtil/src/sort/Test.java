package sort;

public class Test
{

    public static void main(String[] args)
    {
        A a = new B();
        System.out.println(a.i);
        a.print();
    }

}

class A
{
    int i = 1;
    public A()
    {
        int i = 2;
    }
    
    public void print()
    {
        System.out.println("The result is:" + i);
    }
}

class B extends A
{
    private int i = 3;
    
    public B()
    {
        int i = 6;
    }
    
    public void print()
    {
        System.out.println("The result is:" + i);
    }
}
