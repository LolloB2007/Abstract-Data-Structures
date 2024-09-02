/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstract_data_structures;

/**
 * implementation of a binary tree abstract data structure class 
 * Only works for ints 
 * An identifier-based tree interface might come in the future
 * @author lorenzobarbagelata
 */

public class BinaryTree {
    
    class Node
    {
        
        int value;
        Node left;
        Node right;
        
        public Node(int value)
        {
            this.value = value;
        }
        
    }
    
    Node root;
    int length;
    
    public BinaryTree()
    {
        root = null;
    }
    
    private BinaryTree(Node root)
    {
        this.root = root;
        length++;
    }
    
    public void insert(int value)
    {
        if(root==null){root = new Node(value); length++; return;}
        
        if(value>root.value&&root.right==null)
        {
            length++;
            root.right = new Node(value);
        }
        
        else if(value>root.value)
        {
            insert(root.right, value);
        }
        
        else if(value<root.value&&root.left==null)
        {
            length++;
            root.left = new Node(value);
        }
        
        else
        {
            insert(root.left, value);
        }
    }
    
    private void insert(Node node, int val)
    {
        
        if(val>node.value&&node.right==null)
        {
            length++;
            node.right = new Node(val);
        }
        
        else if(val>node.value)
        {
            insert(node.right, val);
        }
        
        else if(val<node.value&&node.left==null)
        {
            length++;
            node.left = new Node(val);
        }
        
        else
        {
            insert(node.left, val);
        }
    }
    
    public String toString()
    {
        if(root==null){return "null";}
        
        String temp = toString(root.left) + " " + root.value + " " + toString(root.right);
        
        int size = temp.length();
        
        temp = temp.substring(1, size-1);
        
        return temp;
    }
    
    private String toString(Node node)
    {
        if(node == null){return "";}
        
        return toString(node.left) + " " + node.value + " " + toString(node.right);
    }
    
    public boolean contains(int val)
    {
        if(root.value==val){return true;}
        
        return contains(val, root.left) || contains(val, root.right);
    }
    
    private boolean contains(int toFind, Node toSearch)
    {
        if(toSearch.value==toFind){return true;}
        
        if(toSearch.value!=toFind && toSearch.left==null 
        && toSearch.right==null) {return false;}
        
        if(toSearch.value!=toFind && toSearch.left==null)
        {return contains(toFind, toSearch.right);}
        
        if(toSearch.value!=toFind && toSearch.right==null)
        {return contains(toFind, toSearch.left);}
        
        return contains(toFind, toSearch.left) || contains(toFind, toSearch.right);
        
    }
    
    private BinaryTree makeSubTree(Node newRoot)
    {
        BinaryTree temp = new BinaryTree(newRoot);
        return temp;
    }
    
    public void remove(int val) 
    {
    root = remove(root, val);
    }

    private Node remove(Node node, int val) 
    {
    if (node == null) {return null;}

    if (val < node.value) 
    {
        node.left = remove(node.left, val);
    } 
    else if (val > node.value) 
    {
        node.right = remove(node.right, val);
    } 
    else 
    {
        if (node.left == null)
        {
            length--;
            return node.right;
        }
        
        else if (node.right == null) 
        {
            length--;
            return node.left;
        } 
        else
        {
            Node minLargerNode = findMin(node.right); 
            node.value = minLargerNode.value;
            node.right = remove(node.right, minLargerNode.value); 
        }
    }
    
    return node;
    }

    private Node findMin(Node node)
    {
        while (node.left != null) 
        {
        node = node.left;
        }
        
    return node;
    }

}
