import org.junit.Test;

import java.util.Comparator;

/**
 * zhongliang 2018/9/3.
 */
public class Lambda {
    @Test
    public void lambda1(){
       //Runnable r2 = () -> System.out.println("hello lambda");
      // r2.run();
     /*  Comparator<Integer> c1 = ( x , y ) -> {
           System.out.println(Integer.compare(x,y) + "函数式接口");
           return Integer.compare(x,y);
       };*/
        Comparator<Integer> c2 = Integer::compare;
        System.out.println(c2.compare( 1, 3));

    }
    @Test
    public void lambda2(){
        long r = getR(25L ,30L,(t1 , t2) -> t1 * t2);
        System.out.println(r);



    }

    public <T ,R> R getR (T t1 ,T t2 , MyFunction<T ,R> mf){
        return mf.method(t1 ,t2);
    }


    interface MyFunction<T ,R >{

        R method(T t1, T t2);
    }


}
