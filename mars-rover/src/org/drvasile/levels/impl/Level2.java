package org.drvasile.levels.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import org.drvasile.levels.Level;

public class Level2 extends Level
{
    public void solve()
    {
        double wheelBase = 0.0;
        double distance = 0.0;
        double steeringAngle = 0.0;

        try (Scanner scanner = new Scanner(new FileReader(this.testFilePath)))
        {
            wheelBase = scanner.nextDouble();
            distance = scanner.nextDouble();
            steeringAngle = scanner.nextDouble();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

        DecimalFormat df = new DecimalFormat("#0.00");

        double radius = wheelBase / Math.sin(Math.toRadians(Math.abs(steeringAngle)));
        double traversedAngle = distance / radius;

        double x = 0.0;
        double y = 0.0;
        double newAngle = 0.0;

        if (steeringAngle == 0)
        {
            x = 0;
            y = distance;
            newAngle = 0;
        }
        else if (steeringAngle < 0)
        {
            x = radius * (Math.cos(traversedAngle) - 1);
            y = radius * Math.sin(traversedAngle);
            newAngle = 360 - (Math.toDegrees(traversedAngle) % 360);
        }
        else
        {
            x = radius * (1  - Math.cos(traversedAngle));
            y = radius * Math.sin(traversedAngle);
            newAngle = (360 + Math.toDegrees(traversedAngle) % 360) % 360;
        }

        try
        {
            File newFile = new File("output/level2/" + testFilePath.substring(testFilePath.indexOf('.') - 1));
            FileWriter writer = new FileWriter(newFile.getAbsolutePath());
            writer.write(df.format(x) + ' ' + df.format(y) + ' ' + df.format(newAngle));
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
