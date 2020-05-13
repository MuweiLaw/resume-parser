package com.dc.common.util.resume.io;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * 将InputStream中的字节保存到ByteArrayOutputStream中
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳龙得水信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class InputStreamCacher {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(InputStreamCacher.class);

    private ByteArrayOutputStream byteArrayOutputStream = null;

    public InputStreamCacher(InputStream inputStream) {
        if (Objects.isNull(inputStream))
            return;

        byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buffer)) > -1 ) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public InputStream getInputStream() {
        if (Objects.isNull(byteArrayOutputStream))
            return null;

        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }
}