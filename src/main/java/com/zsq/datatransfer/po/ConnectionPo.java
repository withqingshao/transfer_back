package com.zsq.datatransfer.po;

import java.util.List;

public class ConnectionPo {
    /**
     * domains : [{"value":"dfd","key":"username"},{"value":"11","key":"password"},{"value":"212","key":"url"}]
     * name : dfsds
     * type : 1
     */
    private String name;
    private Integer type;
    private List<DomainsBean> domains;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DomainsBean> getDomains() {
        return domains;
    }

    public void setDomains(List<DomainsBean> domains) {
        this.domains = domains;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static class DomainsBean {
        /**
         * value : dfd
         * key : username
         */

        private String value;
        private String key;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
