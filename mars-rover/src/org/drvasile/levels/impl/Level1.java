package org.drvasile.levels.impl;

import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;

import org.drvasile.levels.Level;

public class Level1 implements Level
{
    private String testFilePath;

    public void setTestFilePath(String testFilePath) {
        this.testFilePath = testFilePath;
    }

    public void solve() {
        double a = 0.0;
        double b = 0.0;

        try (Scanner scanner = new Scanner(new FileReader(this.testFilePath))) {
            a = scanner.nextDouble();
            b = scanner.nextDouble();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println(df.format(a / Math.sin(Math.toRadians(b))));
    }
}
