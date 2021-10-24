package org.drvasile.levels.impl;

import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;

import org.drvasile.levels.Level;

public class Level2 implements Level
{
    private String testFilePath;

    public void setTestFilePath(String testFilePath) {
        this.testFilePath = testFilePath;
    }

    public void solve() {
        double wheelBase = 0.0;
        double distance = 0.0;
        double steeringAngle = 0.0;

        try (Scanner scanner = new Scanner(new FileReader(this.testFilePath))) {
            wheelBase = scanner.nextDouble();
            distance = scanner.nextDouble();
            steeringAngle = scanner.nextDouble();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        DecimalFormat df = new DecimalFormat("#0.00");

        double radius = wheelBase / Math.sin(Math.toRadians(Math.abs(steeringAngle)));
        double traversedAngle = Math.abs(distance / radius);
        System.out.println("Radius: " + radius);
        System.out.println("Angle: " + traversedAngle + " | " + Math.toDegrees(traversedAngle));
        double x = 0.0;
        double y = 0.0;
        double newAngle = 0.0;

        // TODO: This needs to be revised because it's probably not 100% correct.
        if (distance >= 0)
        {
            if (steeringAngle == 0)
            {
                x = 0;
                y = distance;
                newAngle = 0;
            } else if (steeringAngle < 0)
            {
                x = -1.0 * radius + (radius * Math.cos(traversedAngle));
                y = radius * Math.sin(traversedAngle);
                newAngle = 360 - (Math.toDegrees(traversedAngle) % 360);
            } else
            {
                x = radius - (radius * Math.cos(traversedAngle));
                y = radius * Math.sin(traversedAngle);
                newAngle = Math.toDegrees(traversedAngle);
            }
        } else {
            if (steeringAngle == 0)
            {
                x = 0;
                y = -distance;
                newAngle = 0;
            } else if (steeringAngle < 0)
            {
                x = -1.0 * radius + (radius * Math.cos(traversedAngle));
                y = -1.0 * radius * Math.sin(traversedAngle);
                newAngle = 90 + (Math.toDegrees(traversedAngle) % 360);
            } else
            {
                x = radius - (radius * Math.cos(traversedAngle));
                y = -1.0 * radius * Math.sin(traversedAngle);
                newAngle = 360 - (Math.toDegrees(traversedAngle) % 360);
            }
        }

        System.out.println(df.format(x) + ' ' + df.format(y) + ' ' + df.format(newAngle));
    }
}
