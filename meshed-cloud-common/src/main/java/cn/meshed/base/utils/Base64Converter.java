package cn.meshed.base.utils;


import com.alibaba.cola.exception.SysException;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class Base64Converter {

    final static Base64.Encoder encoder = Base64.getEncoder();
    final static Base64.Decoder decoder = Base64.getDecoder();

    /**
     * 给字符串加密
     * @param text
     * @return
     */
    public static String encode2String(String text) {
        byte[] textByte = new byte[0];
        try {
            textByte = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
           throw new SysException("加密失败");
        }
        String encodedText = encoder.encodeToString(textByte);
        return encodedText;
    }

    /**
     * 给字符串加密
     * @param text
     * @return
     */
    public static byte[] encode(String text) {
        byte[] textByte = new byte[0];
        textByte = text.getBytes(StandardCharsets.UTF_8);
        return encoder.encode(textByte);
    }

    /**
     * 将加密后的字符串进行解密
     * @param encodedText
     * @return
     */
    public static String decode(String encodedText) {
        String text = null;
        try {
            text = new String(decoder.decode(encodedText), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new SysException("解密失败");
        }
        return text;
    }

    /**
     * 将加密后的字符串进行解密
     * @param encoded
     * @return
     */
    public static String decode(byte[] encoded) {
        String text = null;
        try {
            text = new String(decoder.decode(encoded), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new SysException("解密失败");
        }
        return text;
    }
}
