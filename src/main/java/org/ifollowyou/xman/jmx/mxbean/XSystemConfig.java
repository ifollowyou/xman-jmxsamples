package org.ifollowyou.xman.jmx.mxbean;

public class XSystemConfig implements XSystemConfigMXBean {
    private Host host;

    private int threadCount;
    private String schemaName;

    public XSystemConfig(int numThreads, String schema) {
        this.threadCount = numThreads;
        this.schemaName = schema;
    }

    public int getThreadCount() {
        return this.threadCount;
    }

    public void setThreadCount(int noOfThreads) {
        this.threadCount = noOfThreads;
    }

    public String getSchemaName() {
        return this.schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }


    @Override
    public String doConfig() {
        return "threadCount=" + this.threadCount
                + " and schemaName=" + this.schemaName
                + " and hostname=" + this.getHost().getName()
                ;
    }


}
