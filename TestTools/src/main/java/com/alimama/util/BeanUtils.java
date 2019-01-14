package com.alimama.util;


import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by zhangshuman on 2018/12/27.
 */
public class BeanUtils {

    private static BeanCopier FAILBACK = new BeanCopier() {
        public void copy(Object from, Object to, Converter converter) {
            throw new UnsupportedOperationException();
        }
    };
    private static ConcurrentMap<Class<? extends Object>, Object> beanCopierMap = new ConcurrentHashMap();

    public BeanUtils() {
    }

    public static Object copy(Object src, Object dest) {
        if(src == null) {
            return null;
        } else if(dest == null) {
            throw new NullPointerException("dest is null");
        } else {
            Object innerMap = (ConcurrentMap)beanCopierMap.get(src.getClass());
            if(innerMap == null) {
                innerMap = new ConcurrentHashMap();
                ConcurrentMap beanCopier = (ConcurrentMap)beanCopierMap.putIfAbsent(src.getClass(), innerMap);
                if(beanCopier != null) {
                    innerMap = beanCopier;
                }
            }

            BeanCopier beanCopier1 = (BeanCopier)((ConcurrentMap)innerMap).get(dest.getClass());
            if(beanCopier1 == null) {
                if(src.getClass().getClassLoader() != dest.getClass().getClassLoader()) {
                    beanCopier1 = FAILBACK;
                } else {
                    beanCopier1 = BeanCopier.create(src.getClass(), dest.getClass(), false);
                }

                BeanCopier temp = (BeanCopier)((ConcurrentMap)innerMap).putIfAbsent(dest.getClass(), beanCopier1);
                if(temp != null) {
                    beanCopier1 = temp;
                }
            }

            if(beanCopier1 == FAILBACK) {
                org.springframework.beans.BeanUtils.copyProperties(src, dest);
            } else {
                beanCopier1.copy(src, dest, (Converter)null);
            }

            return dest;
        }
    }

    public static <T> T copy(Object src, Class<T> destClass) {
        if(src == null) {
            return null;
        } else {
            try {
                Object e = destClass.newInstance();
                copy(src, e);
                return (T) e;
            } catch (Exception var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    public static <T> List<T> copyList(List<?> srcList, Class<T> destClass) {
        if(srcList == null) {
            return Collections.emptyList();
        } else {
            ArrayList retList = new ArrayList();
            Iterator var3 = srcList.iterator();

            while(var3.hasNext()) {
                Object src = var3.next();
                Object destInstance = copy(src, destClass);
                retList.add(destInstance);
            }

            return retList;
        }
    }

    public static Map<String, Object> transBeanToMap(Object obj) {
        if(obj == null) {
            return null;
        } else {
            HashMap map = new HashMap();

            try {
                BeanInfo e = Introspector.getBeanInfo(obj.getClass());
                PropertyDescriptor[] propertyDescriptors = e.getPropertyDescriptors();
                PropertyDescriptor[] var4 = propertyDescriptors;
                int var5 = propertyDescriptors.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    PropertyDescriptor property = var4[var6];
                    String key = property.getName();
                    if(!"class".equals(key)) {
                        Method getter = property.getReadMethod();
                        Object value = getter.invoke(obj, new Object[0]);
                        map.put(key, value);
                    }
                }

                return map;
            } catch (Exception var11) {
                throw new RuntimeException(var11);
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ObjenesisStd objenesis = new ObjenesisStd();
        ObjectInstantiator factory = objenesis.getInstantiatorOf(BeanUtils.User.class);
        long start = System.currentTimeMillis();

        int i;
        for(i = 0; i < 100000000; ++i) {
            objenesis.newInstance(BeanUtils.User.class);
        }

        start = System.currentTimeMillis() - start;
        System.out.println(start);
        start = System.currentTimeMillis();

        for(i = 0; i < 100000000; ++i) {
            BeanUtils.User.class.newInstance();
        }

        start = System.currentTimeMillis() - start;
        System.out.println(start);
    }

    private static class User {
        private String name;

        private User() {
        }
    }



}
