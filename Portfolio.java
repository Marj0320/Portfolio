
import java.io.*;
import java.util.*;


public class Portfolio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("--------------------------------");
            System.out.println("           PORTFOLIO IN");
            System.out.println("     DATA STRUCTURE ALGORITHM");
            System.out.println("[1] List");
            System.out.println("[2] Linked List");
            System.out.println("[3] Stack");
            System.out.println("[4] Queue");
            System.out.println("[5] Tree");
            System.out.println("[6] BinaryTree");
            System.out.println("[7] Graph");
            System.out.println("[8] Exit");
            System.out.println("--------------------------------");
            System.out.print("Select type of Data Structure: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // consume non-integer input
                continue;
            }

            switch (choice) {
                case 1:
                    // Handle case 1
                    JavaList.main(args);
                    break;

                case 2:
                    // Assuming you want to use LinkedList for stack operations
                    LinkedList.main(args);
                    break;

                case 3:
                    // Handle case 3
                    stackOperations();
                    break;

                case 4:
                    // Handle case 4
                    cipherText(sc);
                    break;
                case 5:
                     Trees.main(args);
                     break;
                
                case 6:
                     BinaryTree.main(args);
                     break;
                
                case 7:
                      Graph.main(args);
                     break;
                

                case 8:
                    exitProgram = true;
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    
    
    
      // Separate method for stack operations
    private static void stackOperations() {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        boolean exitStackMenu = false;

        while (!exitStackMenu) {
            System.out.println("--------------------------------");
            System.out.println("            STACK MENU");
            System.out.println("[1] Push");
            System.out.println("[2] Pop");
            System.out.println("[3] Print");
            System.out.println("[4] Top");
            System.out.println("[5] Exit to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("--------------------------------");
            switch (choice) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    System.out.println(element + " pushed onto the stack.");
                    break;

                case 2:
                    if (!stack.isEmpty()) {
                        int poppedElement = stack.pop();
                        System.out.println("Popped element: " + poppedElement);
                    } else {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                    break;

                case 3:
                    if (!stack.isEmpty()) {
                        System.out.print("Stack: ");
                        for (Integer item : stack) {
                            System.out.print(item + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Top: " + (stack.isEmpty() ? "Stack is empty." : stack.peek()));
                    break;

                case 5:
                    exitStackMenu = true;
                    System.out.println("Exiting Stack Operations. Returning to the main menu.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }


    

    private static void cipherText(Scanner sc) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("        QUEUE- CIPHERTEXT");
        System.out.print("Enter the plaintext: ");
        sc.nextLine();
        String plaintext = sc.nextLine().toUpperCase();

        int k;

        while (true) {
            System.out.print("Enter the value of k: ");
            try {
                k = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for k.");
            }
        }

        String ciphertext = encrypt(plaintext, k);
        System.out.println("Ciphertext: " + ciphertext);
        System.out.println("Cipher Done.");
        
    }

    private static String encrypt(String plaintext, int k) {
        // Implement your encryption logic here
        // For simplicity, let's assume a basic Caesar cipher
        StringBuilder encryptedText = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char shifted = (char) ('A' + (c - 'A' + k) % 26);
                encryptedText.append(shifted);
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }
   }

class JavaList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> myList = new ArrayList<>();
        
        System.out.println("--------------------------------");
        System.out.println("             LIST MENU");
        System.out.println("--------------------------------");
        
        while (true) {
            
            
            System.out.println("[1] Add Element");
            System.out.println("[2] Remove Element");
            System.out.println("[3] Print List");
            System.out.println("[4] Stop");
        
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add: ");
                    int element = scanner.nextInt();
                    myList.add(element);
                    System.out.println(element + " added to the list.");
                    System.out.println("--------------------------------");
                    break;
                
                case 2:
                    if (!myList.isEmpty()) {
                        System.out.print("Enter the index of the element to remove: ");
                        int index = scanner.nextInt();
                        
                        if (index >= 0 && index < myList.size()) {
                            int removedElement = myList.remove(index);
                            System.out.println("Element removed: " + removedElement);
                        } else {
                            System.out.println("Invalid index.");
                        }
                    } else {
                        System.out.println("List is empty. Cannot remove.");
                    }
                    System.out.println("--------------------------------");
                    break;
                
                case 3:
                    if (!myList.isEmpty()) {
                        System.out.print("List: ");
                        for (Integer item : myList) {
                            System.out.print(item + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("List is empty.");
                    }
                    System.out.println("--------------------------------");
                    break;
                
                case 4:
                    System.out.println("Program Stopped.");
                    return; // Exits the program by terminating the main method
                
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }
}

class LinkedList{  
    //Represents the node of list.  
    public class Node{  
        int data;  
        Node next;  
        public Node(int data) {  
            this.data = data;  
        }  
    }  
  
    //Declaring head and tail pointer as null.  
    public Node head = null;  
    public Node tail = null;  
  
    //This function will add the new node at the end of the list.  
    public void add(int data){  
        //Create new node  
        Node newNode = new Node(data);  
        //Checks if the list is empty.  
        if(head == null) {  
             //If list is empty, both head and tail would point to new node.  
            head = newNode;  
            tail = newNode;  
            newNode.next = head;  
        }  
        else {  
            //tail will point to new node.  
            tail.next = newNode;  
            //New node will become new tail.  
            tail = newNode;  
            //Since, it is circular linked list tail will point to head.  
            tail.next = head;  
        }  
    }  
  
    //Displays all the nodes in the list  
    public void display() {  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
        }  
        else {  
            System.out.println("Nodes of the circular linked list: ");  
             do{  
                //Prints each node by incrementing pointer.  
                System.out.print(" "+ current.data);  
                current = current.next;  
            }while(current != head);  
            System.out.println();  
        }  
    }  
  
    public static void main(String[] args) { 
        
        System.out.println("--------------------------------");
        System.out.println("           LINKED LISTS");
        System.out.println("--------------------------------");
        
		       //Ask data drom users using Scanner method
		       Scanner input = new Scanner(System.in);
        System.out.print("Enter data for 1st node: ");
        int data1 = input.nextInt();
		       System.out.print("Enter data for 2nd node: ");
        int data2 = input.nextInt();
        LinkedList list = new LinkedList();  
       	System.out.print("Enter data for 3rd node: ");
        int data3 = input.nextInt();
        System.out.print("Enter data for 4th node: ");
        int data4 = input.nextInt();
        System.out.print("Enter data for 5th node: ");
        int data5 = input.nextInt();
        System.out.print("Enter data for 6th node: ");
        int data6 = input.nextInt();
        System.out.print("Enter data for 7th node: ");
        int data7 = input.nextInt();
        System.out.print("Enter data for 8th node: ");
        int data8 = input.nextInt();
        System.out.print("Enter data for 9th node: ");
        int data9 = input.nextInt();
        
        //Adds data to the circular link list  
        list.add(data1);  
        list.add(data2);  
        list.add(data3); 
        list.add(data4);
        list.add(data5);
        list.add(data6);
        list.add(data7);
        list.add(data8);
        list.add(data9);
        
        System.out.println("--------------------------------");
        //Displays all the nodes present in the list  
        list.display();  
        
        int sum;
        sum = data1+data2+data3+data4+data5+data6+data7+data8+data9;
        System.out.println("The sum of all data is " + sum);
        System.out.println("Process Completed.");
        System.out.println("--------------------------------");
    }
}

class Node {
    char item;
    Node left, right;

    public Node(char key) { 
      item = key;
      left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
      root = null;
    }

    public static int countLeaf(Node node) {
      
      if (node == null) {
        return 0;
      }

      // if left and right of the node are null
      // it is a leaf node
      if (node.left == null && node.right == null) {
        return 1;
      } else {
        return countLeaf(node.left) + countLeaf(node.right);
      }
    }

    // method to add children to leaf nodes
    public static void addChildrenToLeaves(Node node) {

      if (node == null) {
        return;
      }

      // if it's a leaf node, add two children
      if (node.left == null && node.right == null) {
        node.left = new Node((char) (node.item + 32)); // Creating left child
        node.right = new Node((char) (node.item + 33)); // Creating right child
      } else {
      // Recursively check left and right nodes
        addChildrenToLeaves(node.left);
        addChildrenToLeaves(node.right);
      }
    }

    public static void main(String[] args) {
      
      BinaryTree tree = new BinaryTree();

      // create nodes of the tree with letters
      tree.root = new Node('P');
      tree.root.left = new Node('G');
      tree.root.right = new Node('W');

      // create child nodes of the left child ('G')
      tree.root.left.left = new Node('C');
      tree.root.left.right = new Node('K');
        
      // create child nodes of the left child ('C')
      tree.root.left.left.left = new Node('A');
      tree.root.left.left.right = new Node('E');
        
      // create child nodes of the left.right child ('K')
      tree.root.left.right.left = new Node('I');
      tree.root.left.right.right = new Node('M');

      // create child nodes of the right child ('W')
      tree.root.right.left = new Node('S');
      tree.root.right.right = new Node('Y');
        
      // create child nodes of the right.left child ('S')
      tree.root.right.left.left = new Node('Q');
      tree.root.right.left.right = new Node('U');
        
      // create child nodes of the right.right child ('Y')
      tree.root.right.right.left = new Node('X');
      tree.root.right.right.right = new Node('Z');

      // call method to count leaf nodes
      int leafNodes = countLeaf(tree.root);
      System.out.println("--------------------------------");
        System.out.println("         BINARY TREE ");
      System.out.println("Total Leaf Nodes = " + leafNodes);
      System.out.println("Process Completed.");
    }
}

  class Graph {
    // inner class to keep track of edges
    class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // number of vertices and edges
    int vertices, edges;

    // array to store all edges
    Edge[] edge;

    Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;

        // initialize the edge array
        edge = new Edge[edges];
        for (int i = 0; i < edges; i++) {
            // each element of the edge array is an object of Edge type
            edge[i] = new Edge(0, 0);
        }
    }

    public static void main(String[] args) {

        System.out.println("--------------------------------");
        System.out.println("             GRAPH");
        System.out.println("--------------------------------");
        
        
        // create an object of Graph class
        int noVertices = 10; // Updated to 10 vertices
        int noEdges = 34; // Adjusted the number of edges for 10 vertices
        Graph g = new Graph(noVertices, noEdges);

        g.edge[0].src = 1; // edge 1---2 
        g.edge[0].dest = 2;  
        
        g.edge[1].src = 1; // edge 1---8 
        g.edge[1].dest = 8;  
        
        g.edge[2].src = 2; // edge 2---1 
        g.edge[2].dest = 1;  
        
        g.edge[3].src = 2; // edge 2---3
        g.edge[3].dest = 3;  
 
        g.edge[4].src = 2; // edge 2---9 
        g.edge[4].dest = 9;  
        
        g.edge[5].src = 2; // edge 2---0
        g.edge[5].dest = 0;  
        
        g.edge[6].src = 3; // edge 3---2 
        g.edge[6].dest = 2;
 
        g.edge[7].src = 3; // edge 3---4 
        g.edge[7].dest = 4;  
        
        g.edge[8].src = 3; // edge 3---7 
        g.edge[8].dest = 7;
        
        g.edge[9].src = 4; // edge 4---3 
        g.edge[9].dest = 3;
        
        g.edge[10].src = 4; // edge 4---5 
        g.edge[10].dest = 5;
        
        g.edge[11].src = 4; // edge 4---9 
        g.edge[11].dest = 9;
        
        g.edge[12].src = 4; // edge 4---0 
        g.edge[12].dest = 0;
        
        g.edge[13].src = 5; // edge 5---4 
        g.edge[13].dest = 4;
        
        g.edge[14].src = 5; // edge 5---6 
        g.edge[14].dest = 6;
        
        g.edge[15].src = 6; // edge 6---5 
        g.edge[15].dest = 5;
        
        g.edge[16].src = 6; // edge 6---7 
        g.edge[16].dest = 7;
        
        g.edge[17].src = 6; // edge 6---9
        g.edge[17].dest = 9;
        
        g.edge[18].src = 6; // edge 6---0
        g.edge[18].dest = 0;
        
        g.edge[19].src = 7; // edge 7---3 
        g.edge[19].dest = 3;
        
        g.edge[20].src = 7; // edge 7---6 
        g.edge[20].dest = 6;
        
        g.edge[21].src = 7; // edge 7---8 
        g.edge[21].dest = 8;
        
        g.edge[22].src = 8; // edge 8---1 
        g.edge[22].dest = 1;
        
        g.edge[23].src = 8; // edge 8---7 
        g.edge[23].dest = 7;
        
        g.edge[24].src = 8; // edge 8---9 
        g.edge[24].dest = 9;
        
        g.edge[25].src = 8; // edge 8---0 
        g.edge[25].dest = 0;
        
        g.edge[26].src = 9; // edge 9---2 
        g.edge[26].dest = 2;
        
        g.edge[27].src = 9; // edge 9---4 
        g.edge[27].dest = 4;
        
        g.edge[28].src = 9; // edge 9---6 
        g.edge[28].dest = 6;
        
        g.edge[29].src = 9; // edge 9---8 
        g.edge[29].dest = 8;
        
        g.edge[30].src = 0; // edge 0---2 
        g.edge[30].dest = 2;
        
        g.edge[31].src = 0; // edge 0---4 
        g.edge[31].dest = 4;
        
        g.edge[32].src = 0; // edge 0---6 
        g.edge[32].dest = 6;
        
        g.edge[33].src = 0; // edge 0---8 
        g.edge[33].dest = 8;
        
        // print graph
        for (int i = 0; i < noEdges; i++) {
            System.out.println(g.edge[i].src + " - " + g.edge[i].dest);
        }
        
        System.out.println("Process Completed.");
    }
}


class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

class Trees {
    TreeNode root;

    public Trees() {
        root = null;
    }

    // Method to insert a new node with the given key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Method to perform an inorder traversal of the tree
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
       public static void main(String[] args) {
        Trees trees = new Trees();
        Scanner scanner = new Scanner(System.in);
         System.out.println("--------------------------------");
           System.out.println("             TREE");
        System.out.println("Enter values to insert into the binary tree (enter -1 to stop):");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value == -1) {
                    break;
                }
                trees.insert(value);
            } else {
                System.out.println("Invalid input. Please enter integers.");
                scanner.next(); // consume non-integer input
            }
        }
    
        // Performing inorder traversal
        System.out.println("Inorder Traversal:");
        trees.inorderTraversal(trees.root);

        
    }
}



