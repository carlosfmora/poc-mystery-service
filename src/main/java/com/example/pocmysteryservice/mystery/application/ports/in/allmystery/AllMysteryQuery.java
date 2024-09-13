package com.example.pocmysteryservice.mystery.application.ports.in.allmystery;

import com.example.pocmysteryservice.mystery.application.UncheckedInputDataException;

public class AllMysteryQuery {
    private int page;
    private int pageSize;

    /**
     * @param page
     * @param pageSize
     * @throws UncheckedInputDataException
     */
    private AllMysteryQuery(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
        this.execute();
    }

    /**
     * @param page
     * @param pageSize
     * @return
     * @throws UncheckedInputDataException
     */
    public static AllMysteryQuery from(int page, int pageSize) throws UncheckedInputDataException {
        return new AllMysteryQuery(page, pageSize);
    }

    private void execute() {

    }
}
