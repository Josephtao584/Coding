package singleton;

public class lazyer {
    private volatile static lazyer uniqueInstance;

//    private static synchronized lazyer getInstance(){
//        if(uniqueInstance == null){
//            uniqueInstance = new lazyer();
//        }
//        return uniqueInstance;
//    }         耗时长

    private static lazyer getInstance(){
        if(uniqueInstance == null){
            synchronized (lazyer.class){
                if(uniqueInstance == null)
                    uniqueInstance = new lazyer();
            }
        }
        return uniqueInstance;
    }
    private lazyer(){

    }
}
