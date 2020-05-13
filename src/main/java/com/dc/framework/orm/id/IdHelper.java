package com.dc.framework.orm.id;

import java.lang.reflect.Field;

import org.springframework.util.Assert;

import com.dc.framework.lang.Arrays;
import com.dc.framework.lang.reflect.ClassWrapper;
import com.dc.framework.lang.reflect.Reflections;

/**
 * ID生成助手类。
 */
public class IdHelper {
   
	/**
	 * 根据已提供的算法来生成一个ID
	 * @param idtype ID生成算法类型。
	 */
    public static String genId(GenType idtype) {

        if (idtype == GenType.UUID) {
            return (String) new UUIDHexGenerator().generate();
        }
        return null;
    }
    
    /**
     * 检测一个实体是否注释了@ID，并且根据此来设置其ID值。
     * @param <T> 实体类型
     * @param entity 实体对象
     */
    public static <T> T setId(T entity) {

        ClassWrapper<T> cw = ClassWrapper.wrap(entity);
        Field[] fields  = cw.getFields(ID.class);
        if (Arrays.isNotEmpty(fields)) {
            Field  idField = fields[0];            
            Object idValue = cw.getValue(entity, idField);
            if ( idField.getType() == String.class && idValue == null) {
                GenType idtype = idField.getAnnotation(ID.class).genType();
                Reflections.setValue(entity, idField.getName(), genId(idtype));
            }
        } else {
            ID id = entity.getClass().getAnnotation(ID.class);
            if (id != null) {
	            Assert.notNull(id.value(), "在类中定义ID类型必须指定ID字段名称！");
	            Field idField = cw.getField(id.value());
	            Object idValue = cw.getValue(entity, idField);
	            if ( idField.getType() == String.class && idValue == null ) {	            	
	                Reflections.setValue(entity, idField.getName(), genId(id.genType()));
	            }
            }
        }
        return entity;
    }
    
    
}
