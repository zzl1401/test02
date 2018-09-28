import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class JsonUtil {
	
	private final static Logger logger = Logger.getLogger(JsonUtil.class);
	
	private static ObjectMapper objectMapper = null;
	
	static {
		objectMapper = new ObjectMapper();
	}
	
	/**
	 * json格式串转换为对象
	 * @param str
	 * @param clazz
	 * @return
	 */
	public static <T> T jsonToBean(String str, Class<T> clazz){
		if(str == null || "".equals(str)){
			return null;
		}
		try {
			return objectMapper.readValue(str, clazz);
		} catch (Exception e) {
			logger.error("【json转换异常】string to bean,"+e.getMessage(),e);
		} 
		return null;
	}
	
	/**
	 * 处理过的，转换成bean前对属性进行一些预处理
	 * @param str
	 * @param clazz
	 * @return
	 */
	public static<T> T jsonToBeanFormated(String str, Class<T> clazz){
		if(str == null || "".equals(str)){
			return null;
		}
		try {
			 objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			return objectMapper.readValue(str, clazz);
		} catch (Exception e) {
			logger.error("【json转换异常】string to bean,"+e.getMessage(),e);
		} 
		return null;
	}
	
	/**
	 * 对象转换为json格式串
	 * @param obj
	 * @return
	 */
	public static String toJson(final Object obj) {
		if(obj == null){
			return null;
		}
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			logger.error("【json转换异常】bean to string,"+e.getMessage(),e);
		} 
		return null;
	}
	
	/**
	 * 对象转换为json格式串，转换前对属性格式化
	 * @param obj
	 * @return
	 */
	public static String toJsonFormated(final Object obj) {
		if(obj == null){
			return null;
		}
		try {
			objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			logger.error("【json转换异常】bean to string,"+e.getMessage(),e);
		} 
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static String listToJson(List list) {
		if(list == null || list.size() == 0){
			return null;
		}
		try {
			return objectMapper.writeValueAsString(list);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * json字符串转换Map集合
	 * @param str
	 * @return
	 */
	public static Map jsonToMap(String str){
		try {
	        Map<String, Map<String, Object>> maps = objectMapper.readValue(str, Map.class);
	        Set<String> key = maps.keySet();
	        Iterator<String> iter = key.iterator();
	        while (iter.hasNext()) {
	            String field = iter.next();
	        }
	        return maps;
	    } catch (JsonParseException e) {
	        e.printStackTrace();
	    } catch (JsonMappingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	/**
	 * json字符串转换成Array
	 * @param str
	 * @return
	 */
	/*public static TriggerMessage[] jsonToArray(String str) {
	    try {
	    	TriggerMessage[] arr = objectMapper.readValue(str, TriggerMessage[].class);
	        return arr;
	    } catch (JsonParseException e) {
	        e.printStackTrace();
	    } catch (JsonMappingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null;
	}*/
	
	/**
	 * map转换为json格式串
	 * @param obj
	 * @return
	 */
	public static String mapToJson(Map map) {
		if(map == null){
			return null;
		}
		try {
			return objectMapper.writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

}
