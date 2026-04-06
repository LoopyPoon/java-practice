package com.iholin.generics;

import java.util.ArrayList;
import java.util.List;

public class Storage<T> {
    private final List<T> storageList;

    public Storage() {
        this.storageList = new ArrayList<>();
    }

    public void add(T item) {
        storageList.add(item);
    }

    public T get(int index) {
        return storageList.get(index);
    }

    public void remove(int index) {
        storageList.remove(index);
    }

    public List<T> getAll() {
        return storageList.stream().toList();
    }

    public void printAll() {
        storageList.forEach(System.out::println);
    }
}
