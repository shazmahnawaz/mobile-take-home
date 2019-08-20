package com.test.therickandmortyapp.data.callbacks;

public interface DataCallback<T> {
    void onDataReady(T result);
}
