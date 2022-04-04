package com.metro.util;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/28
 * @Content:
 */
public class ObjectUtils {
    /**
     * description:定义一个System.out.println的开（纯属个人习惯）
     **/
    private static int objectNullSystemOutFlag = 0;

    /**
     * description:判断当前对象是否为空（包括所有属性为空）
     *
     * @author ZhangXihui
     * @param object 入参类
     * @return boolean
     * @create 2019/6/3 17:34
     **/
    public static boolean objCheckIsNull(Object object) {
        if (object == null) {
            return true;
        }
        // 得到类对象
        Class clazz = object.getClass();
        // 得到所有属性
        Field[] fields = clazz.getDeclaredFields();
        //定义返回结果，默认为true
        boolean flag = true;
        for (Field field : fields) {
            //设置权限（很重要，否则获取不到private的属性，不了解的同学补习一下反射知识）
            field.setAccessible(true);
            Object fieldValue = null;
            String fieldName = null;
            try {
                //得到属性值
                fieldValue = field.get(object);
                //得到属性类型
                Type fieldType = field.getGenericType();
                //得到属性名
                fieldName = field.getName();
                //打印输出(调试用可忽略)
                if (objectNullSystemOutFlag == 1) {
                    System.out.println("属性类型：" + fieldType + ",属性名：" + fieldName + ",属性值：" + fieldValue);
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
            //只要有一个属性值不为null 就返回false 表示对象不为null
            if (fieldValue != null) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
