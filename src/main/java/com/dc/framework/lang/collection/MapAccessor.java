/**
 * 修改历史：<br/>
 * =================================================================<br/>
 * 修改人 修改时间 修改原因/内容<br/>
 * =================================================================<br/>
 * sam 20100111 增加修改历史注释<br/>
 */

package com.dc.framework.lang.collection;

import java.util.Date;
import java.util.Map;

import com.dc.framework.lang.Arrays;
import com.dc.framework.lang.reflect.Converts;
import org.springframework.util.Assert;


/**
 * map 访问器，包装一个未指定泛型类型<K,V>的map然后可以对map的值以任何类型返回， 有可能会出现CaseException
 * <p>
 * 用法： <br>
 * 
 * <pre>
 * MapAccessor mapAccessor = MapAccessor.create(yourMap);
 * mapAccessor.getLongValue(key); //把map中的值某个值以 long类型返回
 * mapAccessor.getDateValue(key); //把map中的值某个值以 Date类型返回'
 * mapAccessor.save(key,object);  //保存一个值到map中
 * mapAccessor.remove(key);		  //删除某一个值
 * mapAccessor.toBean(clazz);	  //创建某个指定类型的对象，并把map中的值映射到当中去
 * </pre>
 * </p>
 */
public class MapAccessor {
    
    public static MapAccessor create(Map<?, ?> map) {

        return new MapAccessor(map);
    }
    
    public Date getDateValue(Object key) {

        return getValue(key, Date.class);
    }
    
    public short getShortValue(Object key) {

        return getValue(key, short.class);
    }
    
    public double getDoubleValue(Object key) {

        return getValue(key, double.class);
    }
    
    public long getLongValue(Object key) {

        return getValue(key, long.class);
    }
    
    public String getStringValue(Object key) {

        return getValue(key, String.class);
    }
    
    public int getIntValue(Object key) {

        return getValue(key, int.class);
    }
    
    public <T> T[] getArray(Object key, Class<T> type) {

        Object[] objects = (Object[]) map.get(key);
        return Arrays.to(type, objects);
    }
    
    public <T> T getValue(Object key, Class<T> type) {

        Object v = map.get(key);
        T t = Converts.convert(v, type);
        return t;
    }
    

    @SuppressWarnings("unchecked")
    public void save(Object key, Object value) {

        map.put(key, value);
    }
    
    public void remove(Object key) {

        map.remove(key);
    }
    
    protected MapAccessor() {

    }
    
    public MapAccessor(Map<?, ?> map) {

        Assert.notEmpty(map, "map can not be empty!");
        this.map = map;
    }
    
    @SuppressWarnings("unchecked")
    protected Map map;
}
