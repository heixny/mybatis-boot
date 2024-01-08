package com.gec.domain;

public class PageParam {
    private int page;
    private int limit;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public PageParam() {
    }

    public PageParam(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }
}
