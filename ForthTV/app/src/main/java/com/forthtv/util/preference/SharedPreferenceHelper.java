package com.forthtv.util.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by cuongvo on 1/12/16.
 */
public class SharedPreferenceHelper<T> implements ISharedPreference {

    private Context mContext;
    private String preferenceName;
    private String key;
    private T value;

    public SharedPreferenceHelper(){}

    public SharedPreferenceHelper(Context context){
        this.mContext = context;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPreferenceName() {
        return preferenceName;
    }

    public void setPreferenceName(String preferenceName) {
        this.preferenceName = preferenceName;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {

    }


    public boolean addPreference(){
        boolean result = true;

        try{
            SharedPreferences sharedPreferences = getSharedPreferences(preferenceName);
            buildPreference(sharedPreferences);
        } catch (Exception ex) {
            result = false;
        }

        return result;
    }

    public T getPreference(String key, Class<T> classType) {
        T result = null;
        SharedPreferences sharedPreferences = getSharedPreferences(preferenceName);
        Log.d("Cuong","getPreference result ");
        if (sharedPreferences.contains(key)) {
            if (classType.equals(Boolean.class)) {
                Log.d("Cuong", "getPreference result Boolean");
                result = classType.cast(sharedPreferences.getBoolean(key, false));
            } else if (classType.equals(Integer.class)) {
                Log.d("Cuong","getPreference result Integer");
                result = classType.cast(sharedPreferences.getInt(key, -1));
            } else if (classType.equals(Float.class)) {
                Log.d("Cuong","getPreference result Float");
                result = classType.cast(sharedPreferences.getFloat(key, -1.0F));
            } else if (classType.equals(Long.class)) {
                Log.d("Cuong","getPreference result Long");
                result = classType.cast(sharedPreferences.getLong(key, -1L));
            } else if (classType.equals(String.class)) {
                Log.d("Cuong","getPreference result String");
                result = classType.cast(sharedPreferences.getString(key, null));
            }
        }
        Log.d("Cuong","getPreference result " + result);
        return result;
    }

    public boolean isContainKey(String key){
        SharedPreferences sharedPreferences = getSharedPreferences(preferenceName);

        return sharedPreferences.contains(key);
    }

    private void buildPreference(SharedPreferences sharedPreferences){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (value.getClass().equals(Integer.class)) {
            editor.putInt(key, (Integer) value);
        } else if (value.getClass().equals(Boolean.class)) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value.getClass().equals(Float.class)) {
            editor.putFloat(key, (Float) value);
        } else if (value.getClass().equals(Long.class)) {
            editor.putLong(key, (Long)value);
        } else if (value.getClass().equals(String.class)) {
            editor.putString(key, (String)value);
        }

        editor.commit();
    }

    private SharedPreferences getSharedPreferences(String preferenceName) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        return sharedPreferences;
    }
}
