package com.dc.framework.io;

import java.io.IOException;
import java.io.InputStream;

import com.dc.framework.lang.Strings;

/**
 * String输入流
 * 
 */
public class StringInputStream extends InputStream {
    
    protected byte[] bytes = new byte[0];
    private int skip = 0;
    
    public StringInputStream(String s) {

        if (Strings.isNotEmpty(s)) {
            bytes = s.getBytes();
        }
    }
    
    public StringInputStream(byte[] bytes) {

        if (bytes != null && bytes.length > 0)
            this.bytes = bytes;
    }
    
    public int read() throws IOException {

        if (skip == bytes.length)
            return -1;
        int oneByte = bytes[skip];
        skip++;
        return oneByte;
    }
    
}
