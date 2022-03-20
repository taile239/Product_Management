import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * The program aims to manage the products(ID, name, quantity and price) with below functions.
 * 1/Load data from text file and print out to the console
 * 2/Add product to list
 * 3/Print product's list to the console
 * 4/Save product's list to text file
 * 5/Search a product by its ID
 * 6/Delete a product from list by its ID
 * 7/Sort product's list with alphabetical order
 * 8/Get the first item's quantity, convert the integer from decimal to binary, then print out to the console
 * 9/Load data from text file, add it to stack data structure, then print all items to the console
 * 10/Load data from text file, add it to queue data structure, then print all items to the console
 */
public class ProductManagement {

    /**
     * Shows functions of the program
     */
    public static void showMenu(boolean isFirstTime) {
        if(isFirstTime)
            OperationToProduct.writeFirstLine("----------------------------------");

        else
            OperationToProduct.writeLine("----------------------------------");

        OperationToProduct.writeLine("Choose one of this options:");
        OperationToProduct.writeLine("Product list:");
        OperationToProduct.writeLine("1. Load data from file and display");
        OperationToProduct.writeLine("2. Input & add to the end");
        OperationToProduct.writeLine("3. Display data");
        OperationToProduct.writeLine("4. Save product list to file");
        OperationToProduct.writeLine("5. Search by ID");
        OperationToProduct.writeLine("6. Delete by ID");
        OperationToProduct.writeLine("7. Sort by ID");
        OperationToProduct.writeLine("8. Convert to Binary");
        OperationToProduct.writeLine("9. Load data from file to stack and display");
        OperationToProduct.writeLine("10. Load data from file to queue and display");
        OperationToProduct.writeLine("0. Exit");
        OperationToProduct.writeLine("----------------------------------");
    }


    public static void main(String[] args) {
        //Declare the product's list
        MyList<Product> list = new MyList<>();
        //Declare the product's stack
        MyStack<Product> stack = new MyStack<>();
        //Declare the product's queue
        MyQueue<Product> queue = new MyQueue<>();
        //Declare the OperationToProduct object, using this object to perform all operations
        OperationToProduct ope = new OperationToProduct();
        //Declare and initialize a scanner object
        Scanner sc = new Scanner(System.in);
        //Declare user's choice of desire operation
        int choice;

        boolean isFirstTime = true;
        while (true) {
            //Display menu of functions
            showMenu(isFirstTime);
            isFirstTime = false;
            OperationToProduct.writeOnly("Choice: ");
            //Get user's choice and assign
            choice = OperationToProduct.getInt(sc);
            //Break the program
            if(choice == 0) {
                OperationToProduct.writeLine("Many thanks!!");
                return;
            }
            switch (choice) {
                //Function 1: Load data from text file and print out to the console
                case 1 -> {
                    ope.getAllItemsFromFile("data.txt", list);
                    ope.displayList(list);
                }

                //Function 2: Add product to list
                case 2 -> ope.createProductAndAdd(sc, list);

                //Function 3: Print product's list to the console
                case 3 -> ope.displayList(list);

                //Function 4: Save product's list to text file
                case 4 -> ope.writeAllItemsToFile("data.txt", list);

                //Function 5: Search a product by its ID
                case 5 -> ope.searchByCode(list, sc);

                //Function 6: Delete a product from list by its ID
                case 6 -> ope.deleteByCode(list, sc);

                //Function 7: Sort product's list with alphabetical order
                case 7 -> ope.sort(list);

                //Function 8: Get the first item's quantity, convert the integer from decimal to binary, then print out to the console
                case 8 -> ope.writeConvertedDecimal(list);

                //Function 9: Load data from text file, add it to stack data structure, then print all items to the console
                case 9 -> {
                    //Get products from text file and add to stack
                    ope.getAllItemsFromFile("data.txt", stack);
                    //Print all items from stack to the console
                    ope.displayStack(stack);
                }

                //Function 10: Load data from text file, add it to queue data structure, then print all items to the console
                case 10 -> {
                    //Get products from text file and add to queue
                    ope.getAllItemsFromFile("data.txt", queue);
                    //Print all items from stack to the console
                    ope.displayQueue(queue);
                }
            }
        }
    }

}