package org.drvasile.levels;

public abstract class Level
{
    protected String testFilePath;

    public void setTestFilePath(String testFilePath)
    {
        this.testFilePath = testFilePath;
    }

    public abstract void solve();
}
