import java.io.*;
import java.util.Scanner;

/**
 * This class manages all functions relate to the product
 */
public class OperationToProduct  {

    /**
     * Creating and returning a product with info input from keyboard and add to the list
     *
     *
     */
    public void createProductAndAdd(Scanner sc, MyList<Product> list) {
        //Get user input for product's ID, name, quantity and price
        writeOnly("Input new ID: ");
        String id = sc.nextLine();
        writeOnly("Input Product's Name: ");
        String title = sc.nextLine();
        writeOnly("Input Product's quantity: ");
        int quantity = getInt(sc);
        writeOnly("Input Product's price: ");
        double price = getDouble(sc);
        //Declare new product with user's input
        Product newProduct = new Product(id, title, quantity, price);
        //Add new product to the list
        list.insertToTail(newProduct);
        writeLine("Added product");
    }

    /**
     * Reading all products from the file and insert them to the list at tail.
     *
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyList<Product> list) {
        //Clear the list before reading file
        list.clear();
        //Declare and initialize scanner object to read file
        Scanner sc;
        //Declare product's id, name, quantity and price
        String id, title;
        int quantity;
        double price;
        try {
            //Declare new file object with given path
            File file = new File(fileName);
            //Assign scanner object with created file object
            sc = new Scanner(file);
            //Declare line to store each line of text file
            String line;
            //Read text file line by line, get the info the assign to declared variables
            while(sc.hasNextLine()) {
                line = sc.nextLine();
                String[] splitStr = line.split("\\|");
                id = splitStr[0].trim();
                title = splitStr[1].trim();
                quantity = Integer.parseInt(splitStr[2].trim());
                price = Double.parseDouble(splitStr[3].trim());
                //Declare new product with read information
                Product newProduct = new Product(id, title, quantity, price);
                //Add product to the list
                list.insertToTail(newProduct);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reading all products from the file and insert them to the stack.
     *
     * @param fileName The file name of the file
     * @param stack    The Stack contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
        //Clear the stack before reading file
        stack.clear();
        //Declare and initialize scanner object to read file
        Scanner sc;
        //Declare product's id, name, quantity and price
        String id, title;
        int quantity;
        double price;
        try {
            //Declare new file object with given path
            File file = new File(fileName);
            //Assign scanner object with created file object
            sc = new Scanner(file);
            //Declare line to store each line of text file
            String line;
            //Read text file line by line, get the info the assign to declared variables
            while(sc.hasNextLine()) {
                line = sc.nextLine();
                String[] splitStr = line.split("\\|");
                id = splitStr[0].trim();
                title = splitStr[1].trim();
                quantity = Integer.parseInt(splitStr[2].trim());
                price = Double.parseDouble(splitStr[3].trim());
                //Declare new product with read information
                Product newProduct = new Product(id, title, quantity, price);
                //Add product to the stack
                stack.push(newProduct);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reading all products from the file and insert them to the queue.
     *
     * @param fileName The file name of the file
     * @param queue    The Queue contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
        //Clear the queue before reading file
        queue.clear();
        //Declare and initialize scanner object to read file
        Scanner sc;
        //Declare product's id, name, quantity and price
        String id, title;
        int quantity;
        double price;
        try {
            //Declare new file object with given path
            File file = new File(fileName);
            //Assign scanner object with created file object
            sc = new Scanner(file);
            //Declare line to store each line of text file
            String line;
            //Read text file line by line, get the info the assign to declared variables
            while(sc.hasNextLine()) {
                line = sc.nextLine();
                String[] splitStr = line.split("\\|");
                id = splitStr[0].trim();
                title = splitStr[1].trim();
                quantity = Integer.parseInt(splitStr[2].trim());
                price = Double.parseDouble(splitStr[3].trim());
                //Declare new product with read information
                Product newProduct = new Product(id, title, quantity, price);
                //Add product to the queue
                queue.enqueue(newProduct);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Printing all products of the list to console screen
     *
     * @param list: The linked list of product's node
     */
    public void displayList(MyList<Product> list) {
        //Declare new node and assign list's head
        Node<Product> current = list.head;
        if(current == null) {
            writeLine("List is empty");
            return;
        }
        writeLine("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        writeLine("+" + getStr("ID", "Title", "Quantity", "Price") + "+");
        //Print out new node information, and update new node as next node, as long as current node is not null
        while(current != null) {
            writeLine(current.info + "");
            current = current.next;
        }
        writeLine("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    /**
     * Printing all products of the stack to console screen
     *
     * @param stack: The stack of product's node
     */
    public void displayStack(MyStack<Product> stack) {
        //Declare new node and assign stack's head
        Node<Product> current = stack.head;
        if(current == null) {
            writeLine("Stack is empty");
            return;
        }
        writeLine("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        writeLine("+" + getStr("ID", "Title", "Quantity", "Price") + "+");
        //Print out new node information, and update new node as next node, as long as current node is not null
        while(current != null) {
            writeLine(current.info + "");
            current = current.next;
        }
        writeLine("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    /**
     * Printing all products of the stack to console screen
     *
     * @param queue: : The queue of product
     */
    public void displayQueue(MyQueue<Product> queue) {
        //Declare new node and assign queue's head
        Node<Product> current = queue.head;
        if(current == null) {
            writeLine("Queue is empty");
            return;
        }
        writeLine("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //Print out new node information, and update new node as next node, as long as current node is not null
        writeLine("+" + getStr("ID", "Title", "Quantity", "Price") + "+");
        while(current != null) {
            writeLine(current.info + "");
            current = current.next;
        }
        writeLine("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    /**
     * Writing all products from the list to the file
     *
     * @param fileName Input file name
     * @param list     Input Linked list
     */
    public void writeAllItemsToFile(String fileName, MyList<Product> list) {
        //Declare new file writer object with given path
        try(FileWriter out = new FileWriter(fileName)) {
            //Declare and assign new node with list's head
            Node<Product> current = list.head;
            //Declare Product object to hold product of each node
            Product currentProduct;
            //While current node is not null, keep updating Product object of given node and getting new node,
            // then print out product's info to the console
            while (current != null) {
                currentProduct = current.info;
                out.write(getStr(currentProduct.id, currentProduct.title, currentProduct.quantity + "", currentProduct.price + "") + "\n");
                current = current.next;
            }
            writeLine("Write file successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Format the output when printing out product's info to the console, each has total 20 characters separated by "|"
     * @param id: product's ID
     * @param title: product's name
     * @param quantity: product's quantity
     * @param price: product's price
     * @return formatted string when printing out product's info
     */
    public static String getStr(String id, String title, String quantity, String price) {
        return getSubStr(id,true)  +getSubStr(title, true) + getSubStr(quantity, true) + getSubStr(price, false);
    }

    /**
     * Format the output of each product's item when printing out to the console, each has total 20 characters separated by "|"
     * @param str: given string(product's item)
     * @param lastChar: to define whether "|" is necessary
     * @return formatted string
     */
    public static String getSubStr(String str, Boolean lastChar) {
        //Declare number of spaces and assign by subtracting 20 with given product's item
        int spaceNum = 20 - str.length();
        //Adds three spaces before the item
        String result = "   " + str;
        //For each number of space, add a space after the item
        for(int i = 0; i < spaceNum; i++) {
            result += " ";
        }
        if(lastChar) {
            result += "|";
        }
        return result;
    }

    /**
     * Searching product by ID input from keyboard.
     *
     * @param list: The linked list storing product
     */
    public void searchByCode(MyList<Product> list, Scanner sc) {
        writeOnly("ID to be searched: ");
        //Declare ID to be searched and assign by user's input
        String searchID = sc.nextLine();
        //Declare and assign new node as list's head
        Node<Product> current = list.head;
        //While current node is not null, compare its product's id to search ID,
        // then print out if match is found and break
        while(current != null) {
            if(searchID.equals(current.info.id)) {
                writeLine(current.info + "");
                return;
            }
            current = current.next;
        }
        //No product with searched ID
        writeLine("There is no product with ID: " + searchID);
    }

    /**
     * Deleting first product that has the ID input from keyboard from the list.
     *
     * @param list: The linked list storing product
     */
    public void deleteByCode(MyList<Product> list, Scanner sc) {
        writeOnly("Delete product with ID: ");
        //Declare and assign id to be deleted with user's input
        String delId = sc.nextLine();
        //Declare and assign current node as list's head
        Node<Product> current = list.head;
        //Declare temporary next node
        Node<Product> tmpNext;
        if(current == null) {
            writeLine("List is empty");
        }
        //If current node(head node) is id to be deleted, remove it by point head to next node
        if(current.info.id.equals(delId)) {
            list.head = current.next;
            return;
        }
        //While current's next node is not null, get next node and update temporary next node,
        //check with id to be deleted, then remove matched node by shifting pointer
        //If matched node to be deleted is tail, update tail as previous node
        while(current.next != null) {
            tmpNext = current.next;
            if(tmpNext.info.id.equals(delId)) {
                if(current == list.tail) {
                    current.next = null;
                    list.tail = current;
                } else {
                    Node<Product> next = current.next.next;
                    current.next = next;
                }
                writeLine("Deleted product!");
                return;
            }
            current = current.next;
        }
        //No matched node found
        writeLine("ID is not existed");
    }

    /**
     * Convert a decimal to a string presenting its binary. Example: input i = 18 -> Output = "10010"
     *
     * @param i: Input decimal number
     * @return String presenting i's as binary
     */
    public String convertToBinary(int i) {
        int n = i / 2;
        if(n == 0) {
            return "1";
        }
        if(i % 2 == 0) {
            return convertToBinary(n) + "0";
        } else {
            return convertToBinary(n) + "1";
        }

    }

    /**
     * Get the linked list of product, then call convertToBinary function with linked list head(first item)
     * @param list: The linked list
     */
    public void writeConvertedDecimal(MyList<Product> list) {
        Node<Product> temp = list.head;
        if(temp == null) {
            writeLine("List is empty");
            return;
        }
        writeLine("First item's quantity: " + temp.info.quantity);
        writeOnly("Converting to binary -> ");
        writeLine(convertToBinary(temp.info.quantity));
    }

    /**
     * Take first and last node, choose last node as pivot, iterate through the list with two pointer,
     * for node with ID smaller than pivot, swap the ID of node of two pointers, then swap the ID of pivot with current node and return the node
     * @param start: start Node
     * @param end: end Node
     * @return: current Node that was chosen as pivot
     */
    public Node<Product> partitionLast(Node<Product> start, Node<Product> end)
    {
        if (start == end || start == null || end == null)
            return start;

        Node<Product> pivot_prev = start;
        Node<Product> curr = start;
        Product pivot = end.info;

        //Iterate till one before the end,
        //no need to iterate till the end
        //because end is pivot
        while (start != end) {
            if (start.info.id.compareTo(pivot.id) < 0) {
                //Keep tracks of last modified item
                pivot_prev = curr;
                String temp = curr.info.id;
                curr.info.id = start.info.id;
                start.info.id = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        //Swap the position of curr i.e.
        //next suitable index and pivot
        Product temp = curr.info;
        curr.info = pivot;
        end.info = temp;

        //Return one previous to current
        //because current is now pointing to pivot
        return pivot_prev;
    }

    /**
     * Sort a linked list in alphabetical order
     * @param list: The linked list
     */
    public void sort(MyList<Product> list) {
        sort(list.head, list.tail);
        writeLine("Sorted the list");
    }

    /**
     * Sort a linked list in alphabetical order using quicksort approach
     * @param start: Head node of linked list
     * @param end: Tail node of linked list
     */
    private void sort(Node<Product> start, Node<Product> end)
    {
        if(start == null || start == end|| start == end.next )
            return;

        //Split list and partition recurse
        Node<Product> pivot_prev = partitionLast(start, end);
        sort(start, pivot_prev);

        //If pivot is picked and moved to the start,
        //that means start and pivot is same
        //so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);

            //If pivot is in between of the list,
            //start from next of pivot,
            //since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null
                && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }

    /**
     * Get user's input for integer variable
     *
     * @param sc: Scanner object
     * @return user's input(integer)
     * @throws NumberFormatException: if user's input is not an integer
     */
    public static int getInt(Scanner sc) {
        //Declare and initialize user's input as zero
        int answer = 0;
        try {
            //Get user's input and assign it to answer
            answer = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return answer;
    }

    /**
     * Get user's input for double variable
     *
     * @param sc: Scanner object
     * @return user's input(double)
     * @throws NumberFormatException: if user's input is not a double
     */
    public static double getDouble(Scanner sc) {
        //Declare and initialize user's input as zero
        double answer = 0;
        try {
            //Get user's input and assign it to answer
            answer = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return answer;
    }

    /**
     * Write to existing text file "console_output.txt"
     * @param text: text to be written
     */
    public static void consoleOutput(String text) {
        try(FileWriter fw = new FileWriter("console_output.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {

            out.println(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write to new text file "console_output.txt"
     * @param text: text to be written
     */
    public static void firstConsoleOutput(String text) {
        try(FileWriter fw = new FileWriter("console_output.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {

            out.println(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write text to the console with line break and to existing text file
     * @param text: text to be written
     */
    public static void writeLine(String text) {
        System.out.println(text);
        consoleOutput(text);
    }

    /**
     * Write text to the console without line break and to existing text file
     * @param text: text to be written
     */
    public static void writeOnly(String text) {
        System.out.print(text);
        consoleOutput(text);
    }

    /**
     * Write text to the console with line break and to new text file
     * @param text: text to be written
     */
    public static void writeFirstLine(String text) {
        System.out.println(text);
        firstConsoleOutput(text);
    }

}