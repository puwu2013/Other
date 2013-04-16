package sort;

public class Singleton {
	
	private String name;
	
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    //该类只能有一个实例
    private Singleton() {
		// TODO Auto-generated constructor stub
	}    //私有无参构造方法
    //该类必须自行创建
    //有2种方式
    /*private static final TestStream ts=new TestStream();*/
    private static Singleton ts1=null;
    
    //这个类必须自动向整个系统提供这个实例对象
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
