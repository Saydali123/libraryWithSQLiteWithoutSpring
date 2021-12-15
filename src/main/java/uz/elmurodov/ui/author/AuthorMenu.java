package uz.elmurodov.ui.author;

import uz.elmurodov.utils.BaseUtils;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.Scanner;

/**
 * @author Elmurodov Javohir, Tue 5:44 PM. 12/14/2021
 */
public class AuthorMenu {
    public static void menu() {
        Print.println("Create -> 1");
        Print.println("Get -> 2");
        Print.println("Update -> 3");
        Print.println("Delete -> 4");
        Print.println("All -> 5");
        Print.println("Back -> 6");
        Scanner scanner = BaseUtils.getInt;
            Print.print("?:");
        if (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
                case 1 -> AuthorUI.create();
                case 2 -> AuthorUI.get();
                case 3 -> AuthorUI.update();
                case 4 -> AuthorUI.delete();
                case 5 -> AuthorUI.getALL();
                case 6 -> {
                    AuthorUI.back();
                    return;
                }
                default -> Print.println(Color.RED, "Wrong Choice");
            }
            menu();
        } else {
            Print.println(Color.RED, "Wrong Choice");
            menu();
        }
    }
}
