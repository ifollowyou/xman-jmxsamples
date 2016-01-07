package org.ifollowyou.xman.jmx.mbean;

public interface SystemConfigMBean {

    public int getThreadCount();

    public void setThreadCount(int noOfThreads);

    public String getSchemaName();

    public void setSchemaName(String schemaName);

    // any method starting with get and set are considered
    // as attributes getter and setter methods, so I am
    // using do* for operation.
    public String doConfig();
}