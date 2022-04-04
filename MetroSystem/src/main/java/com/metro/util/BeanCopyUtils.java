package com.metro.util;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/3/9
 * @Content:
 */

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BeanCopyUtils {
    public BeanCopyUtils() {
    }

    public static <T> T copyProperties(Object source, Class<T> targetClazz) {
        Object target = null;

        try {
            target = targetClazz.newInstance();
            BeanUtils.copyProperties(source, target);
            return (T) target;
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }

    public static <T> T copyProperties(Object source, T target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }


    public static <V, E> List<E> copy(Collection<V> list, Class<E> clazz) {
        List<E> result = new ArrayList(12);
        Object target;
        if (!CollectionUtils.isEmpty(list)) {
            for(Iterator var3 = list.iterator(); var3.hasNext(); result.add((E) target)) {
                V source = (V) var3.next();
                target = null;

                try {
                    target = clazz.newInstance();
                    BeanUtils.copyProperties(source, target);
                } catch (Exception var7) {
                    throw new RuntimeException(var7);
                }
            }
        }

        return result;
    }
}

