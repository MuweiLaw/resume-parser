package com.lds.common.resume.util;

import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;


public class Base64Utils {

    public static String decode(String encoderText, String charsetName){
        try{
            final BASE64Decoder decoder = new BASE64Decoder();
            return new String(decoder.decodeBuffer(encoderText), charsetName);
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            try {
                return new String(Base64.getUrlDecoder().decode(encoderText),charsetName);
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
        }
        return "";
    }

}
