package com.thoughtworks.collection;

import java.util.List;

public class SingleLinkRealize<T> implements SingleLink<T> {
    private int size = 0;
    private Entry<T> header = new Entry<>(null, null);

    private static class Entry<T> {
        T element;
        Entry<T> next;

        Entry(T element, Entry<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    public SingleLinkRealize() {
        header.next = header;
    }

    public T getHeaderData() {
        return header.next.element;
    }

    public T getTailData() {
        Entry<T> current = new Entry(null, header);
        while (current.next != null) {
            current = current.next;
        }
        return current.element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public boolean deleteFirst() {
        if (!isEmpty()) {
            header.next = header.next.next;
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!isEmpty()) {
            Entry<T> current = new Entry<T>(null, header);
            for (int i = 0; i < size; i++) {
                current = current.next;
                if (i == size - 1) {
                    current.next = null;
                }
            }
            return true;
        }
        return false;
    } // 删除尾部元素；

    public void addHeadPointer(T item) {
        Entry<T> current = new Entry<T>(item, header.next);
        header.next = current;
        size++;
    } // 添加头指针

    public void addTailPointer(T item) {
        Entry<T> current = new Entry<T>(null, header);
        for (int i = 0; i <= size; i++) {
            current = current.next;
            if (i == size) {
                current.next = new Entry<T>(item, null);
            }
        }
        size++;
    } // 添加尾指针

    public T getNode(int index) {
        Entry<T> current = new Entry<T>(null, header);
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.element;
    }
}
