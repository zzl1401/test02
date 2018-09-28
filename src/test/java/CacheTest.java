import com.google.common.cache.*;
import com.jd.ql.presort.intelligence.addressclean.AddressCleanUtils;
import com.jd.ql.presort.intelligence.domain.CleaningRequest;
import domain.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CacheTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final List<Person> list = new ArrayList<Person>();
        list.add(new Person("2", "lisi"));
        list.add(new Person("3", "wangwu"));
        list.add(new Person("1", "zhangsan"));

        RemovalListener<String, Person> removalListener = new RemovalListener<String, Person>() {
            public void onRemoval(RemovalNotification<String, Person> removal) {
                System.out.println("cause:" + removal.getCause() + " key:" + removal.getKey() + " value:"
                        + removal.getValue());
            }
        };


        LoadingCache<String, Person> cache = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS).removalListener(removalListener)
                .maximumSize(100).build(new CacheLoader<String, Person>() {
                    //当缓存没命中,调用load方法获取并存入缓存中
                    @Override
                    public Person load(String key) throws Exception {
                        System.out.println(key + "load in cache");
                        return getPerson(key);
                    }

                    private Person getPerson(String key) {
                        System.out.println(key + "query");
                        for (Person person : list) {
                            if (person.getId().equals(key)) {
                                return person;
                            }
                        }
                        return null;
                    }
                });

        Person person = cache.get("7");
        System.out.println("睡眠前"+person);
        //Thread.sleep(10000);
       // Person person1 = cache.getIfPresent("1");
       // System.out.println("睡眠后"+person1);

    }
@Test
    public void  fun2(){
        CleaningRequest request = new CleaningRequest();
        request.setProvinceName("上海");
        request.setCityName("闵行区");
        request.setCountyName(null);
        request.setTownName(null);
        request.setAddress( "上海市上海市闵行区灯辉路501弄105号301室");
        String sampleAddress = AddressCleanUtils.generateSampleAddress(request);
        System.out.println(sampleAddress);

    }
    @Test
    public void fun3(){
        String lastNumber ="\\d*9758$";
        String tel = "1239758";
      /*  Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]{4}$");
        Matcher matcher = NUMBER_PATTERN.matcher(" 999");*/
        Matcher matcher = Pattern.compile(lastNumber).matcher(tel);
        // boolean matches = Pattern.matches(lastNumber + "$", tel);
        System.out.println(matcher.matches());
       // Assert.assertTrue(matches);

    }




}
