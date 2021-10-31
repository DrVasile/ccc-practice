package org.drvasile.levels.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

import org.drvasile.levels.Level;

public class Level3 extends Level
{
    private double currentX = 0.0;
    private double currentY = 0.0;
    private double currentAngle = 0.0;

    private void calculateNextState(double radius, double traversedAngle, double steeringAngle)
    {
        if (steeringAngle == 0)
        {
            this.currentX = 0;
            this.currentY = 0;
            this.currentAngle = 0;
        }
        else if (steeringAngle < 0)
        {
            this.currentX = radius * (Math.cos(traversedAngle) - 1);
            this.currentY = radius * Math.sin(traversedAngle);
            this.currentAngle = 360 - (Math.toDegrees(traversedAngle) % 360);
        }
        else
        {
            this.currentX = radius * (1  - Math.cos(traversedAngle));
            this.currentY = radius * Math.sin(traversedAngle);
            this.currentAngle = (360 + Math.toDegrees(traversedAngle) % 360) % 360;
        }
    }

    public void solve()
    {
        try (Scanner scanner = new Scanner(new FileReader(this.testFilePath)))
        {
            double wheelBase = scanner.nextDouble();
            int n = scanner.nextInt();

            double distance = 0.0;
            double steeringAngle = 0.0;

            for (int i = 0; i < n; i++)
            {
                distance = scanner.nextDouble();
                steeringAngle = scanner.nextDouble();

                double radius = wheelBase / Math.sin(Math.toRadians(Math.abs(steeringAngle)));
                double traversedAngle = distance / radius;

                calculateNextState(radius, traversedAngle, steeringAngle);
            }

            DecimalFormat df = new DecimalFormat("#0.00");

            File newFile = new File("output/level2/" + testFilePath.substring(testFilePath.indexOf('.') - 1));
            FileWriter writer = new FileWriter(newFile.getAbsolutePath());
            writer.write(df.format(this.currentX) + ' ' + df.format(this.currentY) + ' ' + df.format(this.currentAngle));
            writer.close();
        } catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
