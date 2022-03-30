package uz.elmurodov;

import uz.elmurodov.ui.author.AuthorMenu;
import uz.elmurodov.utils.Color;
import uz.elmurodov.utils.Input;
import uz.elmurodov.utils.Print;


/**
 * @author Elmurodov Javohir, Tue 2:46 PM. 12/14/2021
 */
public class Application {
    public static void main(String[] args) {
        //Migrate.init();
        Print.println(Color.GREEN, "Author Menu -> 1");
        Print.println(Color.GREEN, "Quit -> 5");
        switch (Input.getNum("?:")) {
            case 1 -> AuthorMenu.menu();
            case 5 -> {
                Print.println("Gaplashamiza");
                return;
            }
            default -> Print.println("Gonna talk man");
        }
        main(args);
    }
}
