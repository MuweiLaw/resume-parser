
package com.dc.framework.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 基于字符串的输出流
 *
 */
public class StringOutputStream extends OutputStream {
    
    private StringBuilder strs = new StringBuilder();
    
    @Override
    public void write(int b) throws IOException {

        strs.append(b);
    }
    
    public String toString() {

        int length = strs.length();
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) strs.charAt(i);
        }
        return new String(bytes);
    }
    
}
