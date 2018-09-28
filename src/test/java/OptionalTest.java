import com.google.common.base.Optional;
import org.junit.Test;


public class OptionalTest {

    @Test
public void  testOptional() throws  Exception{
    Optional<Integer> possible=Optional.of(null);
    if (possible.isPresent()){
        System.out.println("possible is Present:" + possible.isPresent());
        System.out.println("possible value:"+possible.get());
    }
}
@Test
public  void  fun1(){
    Optional<Object> absent = Optional.absent();
    Optional<Object> nullable = Optional.fromNullable(null);
    Optional<Integer> integerOptional = Optional.fromNullable(10);

        System.out.println(absent.isPresent());

    if (nullable.isPresent()){
        System.out.println(nullable.isPresent());    }
    if (integerOptional.isPresent()){
        System.out.println(integerOptional.isPresent());
    }

}



}
