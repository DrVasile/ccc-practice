package org.drvasile;

import java.io.File;

import org.drvasile.levels.Level;

public class Main {

    private static void solveLevel(int level) {
        Level levelObj = null;
        System.out.println("Trying to solve level: " + level + '.');

        try
        {
            levelObj = (Level) Class.forName("org.drvasile.levels.impl.Level" + level).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            System.out.println("Solution not implemented yet.");
        }

        assert levelObj != null;

        boolean stillGoing = true;
        int idx = 1;

        while (true) {
            String filePath = "test-cases/level" + level + "/test" + idx + ".txt";
            stillGoing = new File(filePath).isFile();

            if (!stillGoing)
                break;

            levelObj.setTestFilePath(filePath);
            levelObj.solve();
            idx++;
        }

        System.out.println("----------");
    }

    public static void main(String[] args) {
        solveLevel(1);
        solveLevel(2);
        // solveLevel(3);
        // solveLevel(4);
    }
}
