/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ctingo
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> {

    private BinaryTreeNode<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(E root) {
        this.root = new BinaryTreeNode<>(root);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public E getRoot() {
        return this.root.getContent();
    }

    public BinaryTreeNode<E> getRootNode() {
        return this.root;
    }

    public boolean isLeaf() {
        return this.root.getLeft() == null
                && this.root.getRight() == null;
    }

    public List<E> preOrderTraversal() {
        List<E> results = new LinkedList<>();
        if (this.isEmpty()) {
            return results;
        }
        results.add(this.root.getContent());
        if (root.getLeft() != null) {
            List<E> leftTraversal = root.getLeft().preOrderTraversal();
            results.addAll(leftTraversal);
        }
        if (root.getRight() != null) {
            List<E> rightTraversal = root.getRight().preOrderTraversal();
            results.addAll(rightTraversal);
        }
        return results;
    }

    public List<E> inOrderTraversal() {
        List<E> results = new LinkedList<>();
        if (this.isEmpty()) {
            return results;
        }
        if (root.getLeft() != null) {
            List<E> leftTraversal = root.getLeft().inOrderTraversal();
            results.addAll(leftTraversal);
        }
        results.add(this.root.getContent());
        if (root.getRight() != null) {
            List<E> rightTraversal = root.getRight().inOrderTraversal();
            results.addAll(rightTraversal);
        }
        return results;
    }

    public void setLeft(BinaryTree<E> t) {
        this.root.setLeft(t);
    }

    public void setRight(BinaryTree<E> t) {
        this.root.setRight(t);
    }

    public BinaryTree<E> getLeft() {
        return this.root.getLeft();
    }

    public BinaryTree<E> getRight() {
        return this.root.getRight();
    }

    public int countNodesRecursive() {
        if (this.isEmpty()) {
            return 0;
        }
        if (this.isLeaf()) {
            return 1;
        }
        int totalLeft = 0;
        if (this.getLeft() != null) {
            totalLeft = this.getLeft().countNodesRecursive();
        }
        int totalRight = 0;
        if (this.getRight() != null) {
            totalRight = this.getRight().countNodesRecursive();
        }
        return 1 + totalLeft + totalRight;
    }

    public int countNodesIterative() {
        int nNodes = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        if (!this.isEmpty()) {
            s.push(this);
        }
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            nNodes++;
            if (tree.getLeft() != null) {
                s.push(tree.getLeft());
            }
            if (tree.getRight() != null) {
                s.push(tree.getRight());
            }
        }
        return nNodes;
    }

    public int countLeavesRecursive() {
        if (this.isEmpty()) {
            return 0;
        }
        if (this.isLeaf()) {
            return 1;
        }
        int leavesLeft = 0;
        int leavesRight = 0;
        if (this.getLeft() != null) {
            leavesLeft = this.getLeft().countLeavesRecursive();
        }
        if (this.getRight() != null) {
            leavesRight = this.getRight().countLeavesRecursive();
        }
        return leavesLeft + leavesRight;
    }

    public int countLeavesIterative() {
        int totalLeaves = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        if (!this.isEmpty()) {
            s.push(this);
        }
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            if (tree.isLeaf()) {
                totalLeaves++;
            } else {
                if (tree.getLeft() != null) {
                    s.push(tree.getLeft());
                }
                if (tree.getRight() != null) {
                    s.push(tree.getRight());
                }
            }
        }
        return totalLeaves;
    }

    public int countInternalNodesIterative() { // cuenta los nodos internos, los que no son hojas
        int totalLeaves = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        if (!this.isEmpty()) {
            s.push(this);
        }
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            if (!tree.isLeaf()) {
                totalLeaves++;
                if (tree.getLeft() != null) {
                    s.push(tree.getLeft());
                }
                if (tree.getRight() != null) {
                    s.push(tree.getRight());
                }
            }
        }
        return totalLeaves;
    }
    
    // ==================================================================

    //Tarea TDA Árbol Binario 
    
    //countDescendants metodo Recursivo
    public int countDescendantsRecursive() {
        int count = 0;
        if (this.isEmpty() || this.isLeaf()) {
            return 0;
        }
        count++;
        int left = 0;
        if (this.getLeft() != null) {
            left = this.getLeft().countDescendantsRecursive() + 1;
        }
        int right = 0;
        if (this.getRight() != null) {
            right = this.getRight().countDescendantsRecursive() + 1;
        }

        return left + right + count - 1;
    }
    //countDescendants metodo Iterative
    public int countDescendantsIterative() {
        int count = 0;
        Stack<BinaryTree<E>> remember = new Stack<>();
        if (!this.isEmpty()) {
            remember.push(this);
        }
        while (!remember.isEmpty()) {
            BinaryTree<E> t = remember.pop();
            count++;
            if (t.getLeft() != null) {
                remember.push(t.getLeft());
            }
            if (t.getRight() != null) {
                remember.push(t.getRight());
            }
        }
        return count - 1;
    }

    // ==================================================================
    
    //findParent metodo recursivo
    
    /*
    Para las comparaciones se usará el == ya que se colocará el nodo de la manera:
    tree.getLeft()/getRight().getLeft()/getRight(). (...) .getRootNode();
     */
    public BinaryTreeNode<E> findParentRecursive(BinaryTreeNode<E> node) {

        if (this.isEmpty() || this.getRootNode() == node) {
            // si está vacío o si el nodo colocado hace referencia a la rama, retorna nulo
            return null;
        }

        // Si el nodo del arbol izquierdo/derecho es igual al nodo que se busca el padre
        // Retorno la raíz
        if (this.getLeft() != null) {
            if (this.getLeft().getRootNode() == node) {
                return this.getRootNode();
            }
        }
        if (this.getRight() != null) {
            if (this.getRight().getRootNode() == node) {
                return this.getRootNode();
            }
        }

        // Buscar recursivamente en el subárbol izquierdo
        BinaryTreeNode<E> leftParent = this.getLeft().findParentRecursive(node);
        if (leftParent != null) {
            return leftParent; // El nodo dado está en el subárbol izquierdo
        }

        // Buscar recursivamente en el subárbol derecho
        BinaryTreeNode<E> rightParent = this.getRight().findParentRecursive(node);
        if (rightParent != null) {
            return rightParent; // El nodo dado está en el subárbol derecho
        }
        return null; // si ya no se encuentra el padre es nulo
    }

    //findParent metodo iterativo
    public BinaryTreeNode<E> findParentIterative(BinaryTreeNode<E> node) {
        Stack<BinaryTree<E>> remember = new Stack<>();
        if (this.isEmpty() || this.getRootNode() == node) {
            return null;
        } else {
            remember.push(this);
            while (!remember.isEmpty()) {
                BinaryTree<E> t = remember.pop();
                if (t.getLeft() != null) {
                    BinaryTreeNode<E> left = t.getLeft().getRootNode();
                    if (left == node) {
                        return t.getRootNode();
                    } else {
                        remember.push(t.getLeft());
                    }
                }
                if (t.getRight() != null) {
                    BinaryTreeNode<E> right = t.getRight().getRootNode();
                    if (right == node) {
                        return t.getRootNode();
                    } else {
                        remember.push(t.getRight());
                    }
                }
            }
        }
        return null;
    }

    // ==================================================================
    
    //countLevelsRecursive metodo recursivo
    public int countLevelsRecursive() {
        if (this.isEmpty()) {
            return 0;
        }
        if (this.isLeaf()) {
            return 1;
        }
        int left = 0;
        int right = 0;

        if (this.getLeft() != null) {
            left = this.getLeft().countLevelsRecursive();
        }
        if (this.getRight() != null) {
            right = this.getRight().countLevelsRecursive();
        }

        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }
    //countLevelsRecursive metodo Iterativo
    public int countLevelsIterative() {
        int levels = 0;
        Stack<BinaryTree<E>> remember = new Stack<>();
        if (this.isEmpty()) {
            return levels; // si esta vacio retorna 0
        } else {
            remember.push(this); // caso contrario se añade la raiz principal
            while (!remember.isEmpty()) {
                BinaryTree<E> current = remember.pop();

                if (current.getLeft() != null || current.getRight() != null) {
                    levels++;
                    if (current.getLeft() != null) {
                        remember.push(current.getLeft());
                    }
                    if (current.getRight() != null) {
                        remember.push(current.getRight());
                    }
                }
            }
        }
        return levels;
    }

    // ==================================================================
    
    //isLefty metodo Recursivo
    public boolean isLeftyRecursive() {
        if (this.isEmpty()) {
            return true;
        }

        if (this.getLeft() == null && this.getRight() == null) {
            return true;
        }

        if (this.getLeft() != null) {
            if (!this.getLeft().isLeftyRecursive()) {
                return false;
            }
        } else {
            return false;
        }

        if (this.getRight() != null) {
            if (!this.getRight().isLeftyRecursive()) {
                return false;
            }
        }

        return this.getLeft().countDescendantsRecursive() > this.getRight().countDescendantsRecursive() / 2;
    }
    
    //isLefty metodo Iterativo
    public boolean isLeftyIterative() {
        Stack<BinaryTree<E>> remember = new Stack<>();
        remember.push(this);

        boolean isLefty = true;
        BinaryTree<E> current = this;

        while (!remember.isEmpty()) {
            current = remember.pop();

            if (current.getRight() != null) {
                if (current.getLeft() != null && current.getLeft().countDescendantsIterative() > current.getRight().countDescendantsIterative()) {
                    return false;
                }
                remember.push(current.getRight());
            }
        }
        return isLefty;
    }

    // ==================================================================
    
    //isIdentical metodo recursivo
    public boolean isIdenticalRecursive(BinaryTree<E> otherTree) {
        if (this.isEmpty() && otherTree.isEmpty()) {
            return true;
        } else if (this.isEmpty() || otherTree.isEmpty()) {
            return false;
        } else {
            return this.root == otherTree.root
                    && (this.getLeft() == null && otherTree.getLeft() == null
                    || this.getLeft().isIdenticalRecursive(otherTree.getLeft()))
                    && (this.getRight() == null && otherTree.getRight() == null
                    || this.getRight().isIdenticalRecursive(otherTree.getRight()));
        }
    }
    
    
    //isIdentical metodo iterativo
    public boolean isIdenticalIterative(BinaryTree<E> otherTree) {
        if (this.isEmpty() && otherTree.isEmpty()) {
            return true;
        } else if (this.isEmpty() || otherTree.isEmpty()) {
            return false;
        }

        Stack<BinaryTree<E>> thisStack = new Stack<>();
        Stack<BinaryTree<E>> otherStack = new Stack<>();
        thisStack.push(this);
        otherStack.push(otherTree);

        while (!thisStack.isEmpty() && !otherStack.isEmpty()) {
            BinaryTree<E> thisNode = thisStack.pop();
            BinaryTree<E> otherNode = otherStack.pop();

            if (thisNode == null && otherNode == null) {
                continue;
            } else if (thisNode == null || otherNode == null) {
                return false;
            }

            if (thisNode != otherNode) {
                return false;
            }

            if (thisNode.getLeft() != null && otherNode.getLeft() != null) {
                thisStack.push(thisNode.getLeft());
                otherStack.push(otherNode.getLeft());
            } else if (thisNode.getLeft() != null || otherNode.getLeft() != null) {
                return false;
            }

            if (thisNode.getRight() != null && otherNode.getRight() != null) {
                thisStack.push(thisNode.getRight());
                otherStack.push(otherNode.getRight());
            } else if (thisNode.getRight() != null || otherNode.getRight() != null) {
                return false;
            }
        }

        return thisStack.isEmpty() && otherStack.isEmpty();
    }

    // ==================================================================
    
    //largestValueOfEachLvevl metodo Recursivo
    public void largestValueOfEachLevelRecursive(Comparator<E> comparator) {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
            return;
        }
        int height = countLevelsRecursive();
        for (int i = 1; i <= height; i++) {
            List<E> valuesAtLevel = new ArrayList<>();
            findValuesAtLevel(root, i, valuesAtLevel);

            if (!valuesAtLevel.isEmpty()) {
                E maxValue = Collections.max(valuesAtLevel, comparator);
                System.out.print(maxValue + " ");
            }
        }
        System.out.println("");
    }
    
    private void findValuesAtLevel(BinaryTreeNode<E> node, int level, List<E> values) {
        if (node == null) {
            return;
        }

        if (level == 1) {
            // Estamos en el nivel deseado
            values.add(node.getContent());
        } else {
            // Descendemos al siguiente nivel
            if (node.getLeft() != null) {
                findValuesAtLevel(node.getLeft().getRootNode(), level - 1, values);
            }
            if (node.getRight() != null) {
                findValuesAtLevel(node.getRight().getRootNode(), level - 1, values);
            }
        }
    }
    
    //largestValueOfEachLevel metodo Iterativo 
    public void largestValueOfEachLevelIterative(Comparator<E> comparator) {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Queue<BinaryTreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<E> valuesAtLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                BinaryTreeNode<E> currentNode = queue.poll();
                valuesAtLevel.add(currentNode.getContent());

                if (currentNode.getLeft() != null) {
                    queue.offer(currentNode.getLeft().getRootNode());
                }
                if (currentNode.getRight() != null) {
                    queue.offer(currentNode.getRight().getRootNode());
                }
            }

            E maxValue = Collections.max(valuesAtLevel, comparator);
            System.out.print(maxValue + " ");
        }

        System.out.println("");
    }

    // ==================================================================
    
    // countNodesWithOnlyChild metodo Recursiva 
    public int countNodesWithOnlyChildRecursive() {
        int count = 0;
        if (this.isEmpty() || this.isLeaf()) {
            return count;
        }
        if (this.getLeft() != null ^ this.getRight() != null) {
            count++;
        }
        if (this.getLeft() != null) {
            count += this.getLeft().countNodesWithOnlyChildRecursive();
        }
        if (this.getRight() != null) {
            count += this.getRight().countNodesWithOnlyChildRecursive();
        }

        return count;
    }

    //countNodesWithOnlyChild metodo Iterativo
    public int countNodesWithOnlyChildIterative() {
        int count = 0;
        Stack<BinaryTree<E>> remember = new Stack<>();
        if (this.isEmpty() || this.isLeaf()) {
            return count;
        }
        remember.push(this);
        while (!remember.isEmpty()) {
            BinaryTree<E> t = remember.pop();
            if (t.getLeft() != null ^ t.getRight() != null) {
                count++;
            }
            if (t.getLeft() != null) {
                remember.push(t.getLeft());
            }
            if (t.getRight() != null) {
                remember.push(t.getRight());
            }

        }

        return count;
    }

    // ==================================================================
    
    //isHeightBalanced metodo Recursivo
    
    public boolean isHeightBalancedRecursive() {
        if (this.isEmpty()) {
            return true;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if (this.getLeft() != null) {
            leftHeight = this.getLeft().getHeight();
        }
        if (this.getRight() != null) {
            rightHeight = this.getRight().getHeight();
        }

        return Math.abs(leftHeight - rightHeight) <= 1
                && (this.getLeft() == null || this.getLeft().isHeightBalancedRecursive())
                && (this.getRight() == null || this.getRight().isHeightBalancedRecursive());
    }

    public int getHeight() {
        if (this.isEmpty()) {
            return 0;
        }

        int leftHeight = 0;
        if (this.getLeft() != null) {
            leftHeight = this.getLeft().getHeight();
        }

        int rightHeight = 0;
        if (this.getRight() != null) {
            rightHeight = this.getRight().getHeight();
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    //isHeighBalanced metodo Recursivo 

    public boolean isHeightBalancedIterative() {
        if (this.isEmpty()) {
            return true;
        }

        Stack<BinaryTreeNode<E>> stack = new Stack<>();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            BinaryTreeNode<E> node = stack.pop();

            int leftHeight = 0;
            if (node.getLeft() != null) {
                leftHeight = node.getLeft().getHeight();
            }

            int rightHeight = 0;
            if (node.getRight() != null) {
                rightHeight = node.getRight().getHeight();
            }

            int heightDiff = Math.abs(leftHeight - rightHeight);
            if (heightDiff > 1) {
                return false;
            }

            if (node.getLeft() != null) {
                stack.push(node.getLeft().getRootNode());
            }
            if (node.getRight() != null) {
                stack.push(node.getRight().getRootNode());
            }
        }

        return true;
    }

}
