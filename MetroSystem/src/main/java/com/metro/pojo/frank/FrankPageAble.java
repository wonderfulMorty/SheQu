package com.metro.pojo.frank;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/3/11
 * @Content:
 */
public class FrankPageAble<T> implements Serializable {
    private static final long serialVersionUID = -3628865867907230918L;
    private long pageSize;
    private long currentPage;
    private long totalPages;
    private long totalRows;
    private long minRowNumber;
    private long maxRowNumber;
    private Collection<T> datas;

    public FrankPageAble() {
    }

    public FrankPageAble(Collection<T> list, FrankPageInfo page, long totalCount) {
        if (totalCount >= 0L && page != null && page.getPageSize() > 0 && page.getCurrentPage() >= 0) {
            this.datas = list;
            this.totalRows = totalCount;
            this.pageSize = (long)page.getPageSize();
            this.currentPage = (long)page.getCurrentPage();
            if (totalCount == 0L) {
                this.totalPages = 0L;
            } else if (totalCount % (long)page.getPageSize() > 0L) {
                this.totalPages = totalCount / (long)page.getPageSize() + 1L;
            } else {
                this.totalPages = totalCount / (long)page.getPageSize();
            }

            if (this.totalRows == 0L) {
                this.minRowNumber = 0L;
            } else {
                this.minRowNumber = (this.currentPage - 1L) * (long)page.getPageSize() + 1L;
            }

            if (this.currentPage * (long)page.getPageSize() > this.totalRows) {
                this.maxRowNumber = this.totalRows;
            } else {
                this.maxRowNumber = this.currentPage * (long)page.getPageSize();
            }

        } else {
            throw new IllegalArgumentException("totalCount must more than 0");
        }
    }

    public long getCurrentPage() {
        return this.currentPage;
    }

    public long getTotalPages() {
        return this.totalPages;
    }

    public long getTotalRows() {
        return this.totalRows;
    }

    public Collection<T> getDatas() {
        return this.datas;
    }

    public long getMinRowNumber() {
        return this.minRowNumber;
    }

    public long getMaxRowNumber() {
        return this.maxRowNumber;
    }

    public long getPageSize() {
        return this.pageSize;
    }
}
