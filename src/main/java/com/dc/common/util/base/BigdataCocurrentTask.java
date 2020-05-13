/*
 * 文件名：BigdataCocurrentTask.java
 * 版权：Copyright by www.zszq.com
 * 描述：
 * 修改人：lq
 * 修改时间：2016年10月14日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.dc.common.util.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BigdataCocurrentTask
{
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    
    public static <T> Future<T> execute(Callable<T> callable)
    {
         
        Future<T> result = executor.submit(callable);
        return result;
    }

}

