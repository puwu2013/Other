package com.puwu.java.SortUtil;

public class Singleton {
	
	private String name;
	
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    private Singleton() {
		// TODO Auto-generated constructor stub
	}    //˽���޲ι��췽��
    //����������д���
    //��2�ַ�ʽ
    /*private static final TestStream ts=new TestStream();*/
    private static Singleton ts1=null;
    
    //���������Զ�������ϵͳ�ṩ���ʵ������
    public static Singleton getInstance(){
        if(ts1==null){
            ts1=new Singleton();
        }
        return ts1;
    }
    
    public void getInfo(){
        System.out.println("output message "+name);
    }
}
