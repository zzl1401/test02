import cn.jd.sampleaddress.AddressCleanUtils;
import cn.jd.sampleaddress.model.CleaningRequest;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import domain.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CacheTest {
@Test
public void  fun1(){
    final List<Person> list = new ArrayList<Person>();
    list.add(new Person("1","zhangsan"));
    list.add(new Person("2","lisi"));
    list.add(new Person("3","wangwu"));

    LoadingCache<String,Person> cache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES)
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


}

    @Test
    public void  fun2(){
        CleaningRequest request = new CleaningRequest();
        request.setProvinceName("辽宁");
        request.setCityName("沈阳市");
        request.setCountyName("法库县");
        request.setTownName("县城内");
        request.setAddress( "辽宁沈阳市法库县县城内法库县欣风丽景九号楼一单元401");
        String sampleAddress = AddressCleanUtils.generateSampleAddress(request);
        System.out.println(sampleAddress);

    }


}
