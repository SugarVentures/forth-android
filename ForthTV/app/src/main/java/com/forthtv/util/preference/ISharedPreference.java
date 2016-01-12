package com.forthtv.util.preference;

/**
 * Created by cuongvo on 1/12/16.
 */
public interface ISharedPreference<T> {
    public T getValue();
    public void setValue(T value);
    public void setKey(String name);
}
