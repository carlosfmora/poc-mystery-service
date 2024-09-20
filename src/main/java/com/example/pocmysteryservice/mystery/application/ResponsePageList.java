package com.example.pocmysteryservice.mystery.application;

import java.util.List;

public class ResponsePageList<T> {
    private final int page;
    private final int pageSize;
    private final List<T> data;

    public ResponsePageList(int page, int pageSize, List<T> data) {
        this.page = page;
        this.pageSize = pageSize;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ResponsePageList{" +
            "page=" + page +
            ", pageSize=" + pageSize +
            ", data=" + data +
            '}';
    }
}
