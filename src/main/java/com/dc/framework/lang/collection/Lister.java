/**
 * 修改历史：<br/>
 * =================================================================<br/>
 * 修改人 修改时间 修改原因/内容<br/>
 * =================================================================<br/>
 * sam 20100111 增加修改历史注释<br/>
 */

package com.dc.framework.lang.collection;

import java.util.List;

/**
 * 提供对某个List的链式操作
 * <p>
 * 用法1：<br>
 * 
 * <pre>
 *  Lister.start(o1,o2,o3....).removeIfEmpty().toArray();
 * </pre>
 * <br>
 * 用法2:<br>
 * 
 * <pre>
 *  Lister.start(list).marge(lists...).end();
 * </pre>
 * </p>
 */
public class Lister<T> {
    
    private List<T> l;
    
    private Lister(List<T> l) {

        this.l = l;
    }
    
    public List<T> getList() {

        return l;
    }
    
    public static <T> Lister<T> start(List<T> l) {

        return new Lister<T>(l);
    }
    
    public static <T> Lister<T> start(T... objs) {

        return start(Collections.list(objs));
    }
    
    public Lister<T> removeIfEmpty() {

        l = Collections.removeIfEmpty(l);
        return this;
    }
    
    public Lister<T> remove(int index) {

        l.remove(index);
        return this;
    }
    
    public Lister<T> add(T object) {

        l.add(object);
        return this;
    }
    
    public Lister<T> add(T object, int index) {

        l.add(index, object);
        return this;
    }
    
    public Lister<T> merge(List<T>... lists) {

        for (List<T> l : lists) {
            this.l.addAll(l);
        }
        return this;
    }
    
    public T[] toArray() {

        return Lists.toArray(l);
    }
    
    public List<T> end() {

        return l;
    }
}
