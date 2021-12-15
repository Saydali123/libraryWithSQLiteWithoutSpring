package uz.elmurodov.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

/**
 * @author Elmurodov Javohir, Tue 3:44 PM. 12/14/2021
 */
public class BaseUtils {

    public static final Scanner getInt = new Scanner(System.in);

    public static Gson withNulls() {
        return new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    }

    public static Gson withoutNulls() {
        return new GsonBuilder().setPrettyPrinting().create();
    }
}
