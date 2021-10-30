package org.drvasile.levels.impl;

import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;

import org.drvasile.levels.Level;

public class Level3 implements Level
{
    private String testFilePath;

    public void setTestFilePath(String testFilePath)
    {
        this.testFilePath = testFilePath;
    }

    public void solve()
    {
        int n;
        double wheelBase = 0.0;

        try (Scanner scanner = new Scanner(new FileReader(this.testFilePath)))
        {
            wheelBase = scanner.nextDouble();
            n = scanner.nextInt();

            double distance = 0.0;
            double direction = 0.0;

            for (int i = 0; i < n; i++)
            {
                distance = scanner.nextDouble();
                direction = scanner.nextDouble();
            }
        } catch (Exception exception)
        {
            exception.printStackTrace();
        }

        DecimalFormat df = new DecimalFormat("#0.00");

        //System.out.println(df.format(x) + ' ' + df.format(y) + ' ' + df.format(newAngle));
    }
}
