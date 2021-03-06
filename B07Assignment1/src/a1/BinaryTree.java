package a1;

import java.util.ArrayList;
import java.util.LinkedList;
// **********************************************************
// Assignment1:
// Student1:
// UTORID user_name: liuhai6
// UT Student #: 1004258000
// Author: Hai Ning Liu
//
// Student2:
// UTORID user_name: lambran3
// UT Student #: 1003383484
// Author: Brandon Lam
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************

/*
 * the provided starter code may contain warnings of raw type. This is OK, 
 * because we have'nt yet learned generics. After having learnt generics, 
 * we will revisit this code, and remove the warnings out.
 */
public class BinaryTree {

  private Node root;

  /*
   * DO NOT MODIFY THIS METHOD WE HAVE ALREADY COMPLETED THIS METHOD FOR YOU.
   * adds data inside a binary tree level by level starting 
   * from left to right.
   */
  public void addData(int d) {
    Node toAdd = new Node(d);
    if (root == null) {
      root = toAdd;
    } else {
      LinkedList ll = new LinkedList();
      ll.add(root);
      while (!(ll.isEmpty())) {
        Node currentNode = (Node) ll.poll();
        if (currentNode.getLeftNode() == null) {
          currentNode.setLeftNode(toAdd);
          break;
        } else if (currentNode.getRightNode() == null) {
          currentNode.setRightNode(toAdd);
          break;
        } else {
          /*
           * remember, the queue is FIFO, and due to this we add first the 
           * left node followed by the right node.
           */
          ll.add(currentNode.getLeftNode());
          ll.add(currentNode.getRightNode());
        }
      }
    }
  }

  public String toString() {
    /*
     * Do not use recursion for this method
     */

    // if root is empty, return empty representation
    if (root == null) {
      return "";
    } else {
      String resultString = "";
      LinkedList ll = new LinkedList();
      ll.add(root);

      while (!(ll.isEmpty())) {
        // get a reference when removing the head element of ll
        Node currentNode = (Node) ll.poll();
        // after removing the node, update the string representation
        resultString = resultString + String.valueOf(
        		currentNode.getData()) + " ";

        /*
         * add left and right child of the current node to ll, if they exist
         */
        if (currentNode.getLeftNode() != null) {
          ll.add(currentNode.getLeftNode());

          if (currentNode.getRightNode() != null) {
            ll.add(currentNode.getRightNode());
          }
        }

      }
      /*
       * after finished with ll, return the string 
       * result minus the white space at the end
       */
      return resultString.substring(0, resultString.length() - 1);
    }
  }


  public ArrayList toList() {
    // make a list to represent the tree
    ArrayList inorder_list = new ArrayList();

    /*
     * begin traversal from root in addSubTree() and add data results to list
     */
    addSubTree(root, inorder_list);

    return inorder_list;

  }


  private void addSubTree(Node temp, ArrayList values) {
    if (temp == null) {
      return;
    }

    /*
     * we check null condition at the above if statement already, 
     * so temp can't be null when it reaches here
     */

    // recusively traverse to the left child nodes of the tree
    addSubTree(temp.getLeftNode(), values);
    // add data
    values.add(temp.getData());
    // recusively traverse right child nodes of the tree
    addSubTree(temp.getRightNode(), values);
  }


  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    
    bt.addData(4);
    bt.addData(5);
    bt.addData(2);
    bt.addData(23);
    bt.addData(48);
    bt.addData(80);
    bt.addData(34);
    
    System.out.println(bt); 
    System.out.println();


    for (Object d : bt.toList()) {
      System.out.println((int) d);
    }
    /*
     * the above loop will print the following: 4 2 5 1 6 3 7
     */
  }
}
