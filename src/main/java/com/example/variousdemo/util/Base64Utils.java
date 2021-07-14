package com.example.variousdemo.util;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * ����������
 * ��Base64����PDF�ļ��Ļ�����
 * @Date: 18:40 2021/7/6 0006
 **/
public class Base64Utils {

    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    public static void main(String[] args) {
        // ��PDF��ʽ�ļ�ת��base64����
        String base64String = getPDFBinary(new File("D:\\signed_dest.pdf"));
        System.out.println(base64String);
        base64StringToPDF(base64String,"D:test.pdf");
    }

    /**
     *  ��PDFת����base64����
     *  1.ʹ��BufferedInputStream��FileInputStream��Fileָ�����ļ��ж�ȡ���ݣ�
     *  2.Ȼ����д�뵽ByteArrayOutputStream�ײ����������Ļ��������BufferedOutputStream
     *  3.�ײ������ת�����ֽ����飬Ȼ����BASE64Encoder�Ķ���������б���
     * */
    public static String getPDFBinary(File file) {
        FileInputStream fin = null;
        BufferedInputStream bin = null;
        ByteArrayOutputStream baos = null;
        BufferedOutputStream bout = null;
        try {
            // ������ȡ�ļ����ļ������
            fin = new FileInputStream(file);
            // ���ļ�������ϰ�װ�ڵ���������Ч�ʶ�ȡ��
            bin = new BufferedInputStream(fin);
            // ����һ���µ� byte �����������������ָ����С�Ļ���������
            baos = new ByteArrayOutputStream();
            // ����һ���µĻ�����������Խ�����д��ָ���ĵײ������
            bout = new BufferedOutputStream(baos);
            byte[] buffer = new byte[1024];
            int len = bin.read(buffer);
            while (len != -1) {
                bout.write(buffer, 0, len);
                len = bin.read(buffer);
            }
            // ˢ�´��������ǿ��д�����л��������ֽڣ��������д��룬�����п���������
            bout.flush();
            byte[] bytes = baos.toByteArray();
            // sun��˾��API
            return encoder.encodeBuffer(bytes).trim();
            // apache��˾��API
            // return Base64.encodeBase64String(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fin.close();
                bin.close();
                // �ر� ByteArrayOutputStream ��Ч�������еķ����ڹرմ������Կɱ����ã�����������κ� IOException
                // IOException
                // baos.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * ��base64����ת����PDF
     *
     * @param base64sString
     *            1.ʹ��BASE64Decoder�Ա�����ַ���������ֽ�����
     *            2.ʹ�õײ�������ByteArrayInputStream������ֽ������л�ȡ���ݣ�
     *            3.�����ӵײ��������ж�ȡ���ݵ�BufferedInputStream�������������
     *            4.ʹ��BufferedOutputStream��FileOutputSteam������ݵ�ָ�����ļ���
     */
    public static void base64StringToPDF(String base64sString,String filePath) {
        BufferedInputStream bin = null;
        FileOutputStream fout = null;
        BufferedOutputStream bout = null;
        try {
            // ��base64������ַ���������ֽ�����
            byte[] bytes = decoder.decodeBuffer(base64sString);
            // apache��˾��API
            // byte[] bytes = Base64.decodeBase64(base64sString);
            // ����һ����bytes��Ϊ�仺������ByteArrayInputStream����
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            // �����ӵײ��������ж�ȡ���ݵĻ�������������
            bin = new BufferedInputStream(bais);
            // ָ��������ļ�
            File file = new File(filePath);
            // ������ָ���ļ��������
            fout = new FileOutputStream(file);
            // Ϊ�ļ�������Խӻ������������
            bout = new BufferedOutputStream(fout);

            byte[] buffers = new byte[1024];
            int len = bin.read(buffers);
            while (len != -1) {
                bout.write(buffers, 0, len);
                len = bin.read(buffers);
            }
            // ˢ�´��������ǿ��д�����л��������ֽڣ��������д��룬�����п���������
            bout.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bin.close();
                fout.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
