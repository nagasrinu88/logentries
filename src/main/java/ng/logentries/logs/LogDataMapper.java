/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.logentries.logs;

import java.lang.reflect.Field;
import java.util.HashMap;
import ng.logentries.logs.db.pg.PostgresLogEntryData;
import ng.logentries.util.AttributeKey;

/**
 *
 * @author NavNag
 */
public class LogDataMapper {

    public static <T extends LogEntryData> T parse(String log, Class<T> cls) throws InstantiationException, IllegalAccessException {
        T data = cls.newInstance();
        String[] tokens = log.split("\\s");
        //String[] tokens = log.split("([^\"]\\S*|\".+?\")\\s*");
        HashMap<String, String> dataMap = new HashMap<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            //System.out.println(token);
            if (token.contains("=")) {
                String[] vals = token.split("=");
                dataMap.put(vals[0], vals[1]);
            } else {
                dataMap.put("" + i, token);
            }
        }
        populateData(dataMap, data);
        return data;
    }

    /**
     *
     * @param <T>
     * @param dataMap
     * @param data
     */
    private static <T extends LogEntryData> void populateData(HashMap<String, String> dataMap, T data) {
        Class<? extends LogEntryData> cls = data.getClass();
        do {
            //System.out.println(cls);
            for (Field field : cls.getDeclaredFields()) {
                try {
                    if (field.isAnnotationPresent(AttributeKey.class)) {
                        AttributeKey attr = field.getAnnotation(AttributeKey.class);
                        if (attr != null) {
                            //System.out.println(field.getName());
                            String key = attr.name();
                            String keyVal = dataMap.get(key);
                            Object val = null;
                            Class<?> fieldType = field.getType();
                            //System.out.println(key + ": " + keyVal + " " + fieldType);
                            if (fieldType.equals(Integer.TYPE)) {
                                keyVal = keyVal.replaceAll("\\D", "");
                                val = Integer.parseInt(keyVal);
                            } else if (fieldType.equals(Long.TYPE)) {
                                keyVal = keyVal.replaceAll("\\D", "");
                                val = Long.parseLong(keyVal);
                            } else if (fieldType.equals(Float.TYPE)) {
                                //keyVal = keyVal.replaceAll("/[\\D]/g", "");
                                val = Float.parseFloat(keyVal);
                            } else {
                                val = keyVal;
                            }

                            if (val != null) {
                                boolean accessChanged = false;
                                if (!field.isAccessible()) {
                                    field.setAccessible(true);
                                    accessChanged = true;
                                }
                                field.set(data, val);
                                // resetting the access
                                if (accessChanged) {
                                    field.setAccessible(false);
                                }
                                // removing the key
                                dataMap.remove(key);
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Unable to Set: " + e);
                }
            }
            cls = (Class<? extends LogEntryData>) cls.getSuperclass();
        } while (cls != null && !dataMap.isEmpty());
        //System.out.println(dataMap);
    }
}
