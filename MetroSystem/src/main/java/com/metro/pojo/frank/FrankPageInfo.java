package com.metro.pojo.frank;

import java.io.Serializable;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/3/11
 * @Content:
 */
public class FrankPageInfo implements Serializable {
    private static final long serialVersionUID = -9065614200385450712L;
    private int pageSize;
    private int currentPage;

    public FrankPageInfo(int currentPage, int pageSize) {
        if (currentPage >= 1 && pageSize >= 1) {
            this.currentPage = currentPage;
            this.pageSize = pageSize;
        } else {
            throw new IllegalArgumentException("currentPage and pageSize must more than 0.");
        }
    }

    public FrankPageInfo() {
        this.currentPage = 1;
        this.pageSize = 20;
    }

    public int getPageStart() {
        if (this.currentPage < 1) {
            this.currentPage = 1;
        }

        return (this.currentPage - 1) * this.pageSize;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }
}
