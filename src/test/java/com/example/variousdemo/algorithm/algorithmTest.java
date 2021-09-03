package com.example.variousdemo.algorithm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


/**
 * @className: algorithmTest
 * @description:
 * @created: 2021/08/30 15:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class algorithmTest {

    /**
     * 功能描述：
     * 〈两数之和找下标〉
     * @Date: 15:38 2021/8/30 0030
     * @param
     * @return: void
     **/
    @Test
    public void twoSum(){
        Map map = new HashMap<>();
        int target = 9;
        int a[] = {1,2,3,4,5,6,7,8,9};
        for(int i = 0 ; i <  a.length ; i++){
            if(map.containsKey(9-a[i])){
                System.out.println("数组下标为" + i + ","+map.get(9-a[i]));
            } else {
                map.put(a[i],i);
            }
        }
    }

    /**
     * 功能描述：
     * 〈将整数反转,如123翻过来为321〉
     * @Date: 15:52 2021/8/30 0030
     * @param
     * @return: void
     **/
    @Test
    public void reverse(){
        int target = 123;
        int result = 0;
        while(target != 0){
            int x = target %10;
            target = target /10;
            result = result * 10 + x;
        }
        System.out.println(result);
    }

    /**
     * 功能描述：
     * 〈括号匹配问题〉
     * @Date: 10:03 2021/8/31 0031
     * @param
     * @return: void
     **/
    @Test
    public void matchTest(){
        System.out.println(match("(){}[]{"));
    }

    /**
     * 功能描述：
     * 〈冒泡排序：时间复杂度：n^2,稳定排序〉
     * @Date: 16:30 2021/8/30 0030
     * @param
     * @return: void
     **/
    @Test
    public void BubbleSort(){
        int a[] = {1,3,2,5,7,5,8};
        int t;

        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a.length-1-i ; j++){
                if(a[j] > a[j+1]){
                    t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 功能描述：
     * 〈直接插入排序,时间复杂度为n^2,稳定算法〉
     * @Date: 9:31 2021/8/31 0031
     * @param
     * @return: void
     **/
    @Test
    public void directInsert(){
        int a[] = {2,4,1,4,6,3,7};
        //待插入的元素
        int value;
        //插入的前一个元素的索引
        int index;
        //默认第一个数是有序的
        for(int i = 1; i < a.length ; i++){
            value = a[i];
            index = i - 1;
            while(index >= 0 && value < a[index]){
                //不断的后移 不用怕覆盖 因为已经保存在value中
                a[index + 1] = a[index];
                index--;
            }
            //退出循环说明已经找到了位置
            a[index + 1] = value;
        }
        System.out.println(Arrays.toString(a));
    }

    public boolean match(String demo){
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Deque<Character> deque = new LinkedList<>();

        for(int i = 0 ; i < demo.length() ; i++){
            char t = demo.charAt(i);
            if(map.containsKey(t)){
                if(deque.isEmpty() || deque.peek() != map.get(t)){
                    return false;
                }
                //出栈
                deque.pop();
            }else{
                //入栈
                deque.push(t);
            }
        }
        return deque.isEmpty();
    }

    /**
     * 功能描述：
     * 〈移除重复元素〉
     * @Date: 14:38 2021/8/31 0031
     * @param
     * @return: void
     **/
    @Test
    public void removeDuplicate(){
        int a[] = {3,2,3,2,3};
        int target = 2;
        int left = 0;
        for(int right = 0 ; right < a.length ; right++){
            if(a[right] != target){
                a[left] = a[right];
                left++;
            }
        }
        System.out.println("数组长度为："+left);
    }

    /**
     * 功能描述：
     * 〈加1〉
     * @Date: 16:49 2021/8/31 0031
     * @param
     * @return: void
     **/
    @Test
    public void plusOne(){
        int a[] = {9};
        int length = a.length;
        int t = -1;
        if(a[length -1] == 9){
            a[length - 1] = 0;
            for(int i = length - 2 ; i >= 0 ; i --){
                if(a[i] != 9){
                    a[i] = a[i] + 1;
                    break;
                } else {
                    t = i;
                    a[i] = 0;
                }
            }
            if(t == 0 || a.length == 1){
                a = new int[a.length+1];
                a[0] = 1;
            }
        } else {
            a[length-1] = a[length-1] + 1;
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 功能描述：
     * 〈加1（2.0版本）〉
     * @Date: 16:58 2021/8/31 0031
     * @param
     * @return: void
     **/
    @Test
    public void TestplusOne2(){
        int demo2[] = {1,9,9};
        int[] a = plusOne2(demo2);
        System.out.println(Arrays.toString(a));
    }

    public int[] plusOne2(int[] demo){
        for(int i = demo.length-1 ; i >= 0 ;i--){
            demo[i]++;
            demo[i] = demo[i] % 10;
            if(demo[i] != 0){
                return demo;
            }
        }
        demo = new int[demo.length +1];
        demo[0] = 1;
        return demo;
    }

    /**
     * 功能描述：
     * 〈计算字符串中最后一个单词的长度〉
     * @Date: 9:51 2021/9/1 0001
     * @param
     * @return: void
     **/
    @Test
    public void lengthOfLastWord(){
        String demo =  "   fly me   to   the moon ";
        int finalLength = 0;
        for(int i = demo.length()-1 ; i >= 0 ; i--){
            char ch = demo.charAt(i);
            if(finalLength > 0 && ch == ' '){
                break;
            }
            if(ch != ' '){
                finalLength++;
            } else {
                finalLength = 0;
            }
        }
        System.out.println("长度为："+finalLength);
    }

    /**
     * 功能描述：
     * 〈验证回文串〉
     * @Date: 16:19 2021/9/1 0001
     * @param
     * @return: void
     **/
    @Test
    public void verifyHuiwen(){
        String demo = "race a car";
        StringBuffer stringBuffer = new StringBuffer();
        //去除多余的字符,只保留数字或字符
        for(int i = 0 ; i < demo.length() ; i++){
            char ch = demo.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stringBuffer.append(Character.toLowerCase(ch));
            }
        }

        StringBuffer reBuffer = new StringBuffer(stringBuffer).reverse();
        if(stringBuffer.toString().equals(reBuffer.toString())){
            System.out.println(stringBuffer+"是一个回文串");
        }
    }

    @Test
    public void testVerifyHuiwen2(){
        System.out.println(verifyHuiwen2("A man, a plan, a canal: Panama"));
    }

    public boolean verifyHuiwen2(String demo){
        StringBuffer stringBuffer = new StringBuffer();
        //去除多余的字符,只保留数字或字符
        for(int i = 0 ; i < demo.length() ; i++){
            char ch = demo.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stringBuffer.append(Character.toLowerCase(ch));
            }
        }
        int left = 0;
        int right = stringBuffer.length()-1;
        while(left < right){
            if(Character.toLowerCase(stringBuffer.charAt(left)) != Character.toLowerCase(stringBuffer.charAt(right))){
                return  false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 功能描述：
     * 〈二进制求和〉
     * @Date: 9:35 2021/9/2 0002
     * @param
     * @return: void
     **/
    @Test
    public void binaryAdd(){
        String a = "11";
        String b = "1";
        //先转换为数字
        int anum = 0;
        int bnum = 0;
        int at = 1;
        int bt = 1;
        for(int i = a.length()-1 ; i >= 0 ; i--){
            char aCharacter = a.charAt(i);
            if(aCharacter == '1'){
                anum = anum + 1 * at;
            }
            at = at * 2;
        }

        for(int j = b.length()-1 ; j >= 0 ; j--){
            char bCharacter = b.charAt(j);
            if(bCharacter == '1'){
                bnum = bnum + 1 * bt;
            }
            bt = bt * 2;
        }

        int sum = anum + bnum;
        StringBuffer buffer = new StringBuffer();
        //转换为二进制
        while(sum != 0){
        }
        System.out.println(anum);
        System.out.println(bnum);
    }
}
