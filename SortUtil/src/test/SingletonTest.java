package test;

import org.junit.Test;

import sort.Singleton;

public class SingletonTest {

	@Test
	public void test() {
		Singleton s=Singleton.getInstance();
        s.setName("张孝祥");
        System.out.println(s.getName());
        Singleton s1=Singleton.getInstance();
        s1.setName("张孝祥");
        System.out.println(s1.getName());
        s.getInfo();
        s1.getInfo();
        if(s==s1){
            System.out.println("创建的是同一个实例");
        }else if(s!=s1){
            System.out.println("创建的不是同一个实例");
        }else{
            System.out.println("application error");
        }
	}

}
