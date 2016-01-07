package org.ifollowyou.xman.jmx.mxbean;

public interface XSystemConfigMXBean {

    public int getThreadCount();

    public void setThreadCount(int noOfThreads);

    public String getSchemaName();

    public void setSchemaName(String schemaName);

    public String doConfig();

    // user datatype
    public Host getHost();

    public void setHost(Host host);
}
