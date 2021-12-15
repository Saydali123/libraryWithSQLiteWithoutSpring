package uz.elmurodov.migrations;

import uz.elmurodov.configs.DbConfig;
import uz.elmurodov.configs.PropertyConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * @author Elmurodov Javohir, Tue 4:49 PM. 12/14/2021
 */
public class Migrate {
    public static void init() {
        try (FileReader fileReader = new FileReader(PropertyConfig.get("db.migrations")); BufferedReader bufferedReader = new BufferedReader(fileReader); Connection c = DbConfig.conn(); Statement s = c.createStatement()) {
            StringTokenizer tokens = new StringTokenizer(bufferedReader.lines().collect(Collectors.joining()), ";");
            while (tokens.hasMoreTokens()) s.addBatch(tokens.nextToken());
            s.executeBatch();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
