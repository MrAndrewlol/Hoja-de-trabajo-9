/*
 * The Author of this arbolbinario @Andre Jo
 */



public class arbolbinario{
    
    //Creates el arbol with their respectives nodes
    class Treenode{
        String value;
        Treenode left;
        Treenode right;

        Treenode(String value) {
            this.value = value;
            right = null;
            left = null;
        }

    }

    protected Treenode root; //root as objecto of Treenode

    /**
     * @param value
     * Adds a string to the tree
     */
    public void add(String value) {
        root = addRecursive(root, value);
    }

    
    /** 
     * @param current
     * @param value
     * @return Node
     * Recursive function para agregar al tree
     */
    protected Treenode addRecursive (Treenode current, String value) {
        if (current == null) {
            return new Treenode(value);
        }
        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

     /**
     * @param value
     * @return boolean
     * Función que comprueba si el árbol contiene el valor deseado
     */
    public boolean containsNode(String value) {
        return containsNodeRecursive(root, value);
    }

    /**
     * @param current
     * @param value
     * @return boolean
     * Recursive true or false if doesnt contain @value
     */
    protected boolean containsNodeRecursive(Treenode current, String value) {
        String[] words = null; 

        if (current == null) {
            return false;
        }

        if (current != null){
            words = current.value.split(",");
        }

        if (value.equalsIgnoreCase(words[0])){
            return true;
        }

        return value.compareTo(current.value) < 0
        ? containsNodeRecursive(current.left, value)
        : containsNodeRecursive(current.right, value);
    }

     /**
     * @param value
     * @return String
     * Gets the value from the tree node
     */
    public String getNode(String value) {
        return getNodeRecursive(root, value);
    }
   

    /**
     * @param current
     * @param value
     * @return String
     * Recursive for get Node()
     */
    protected String getNodeRecursive(Treenode current, String value) {
        String[] words = null; 

        if (current == null) {
            return "*"+value+"*";
        }

        if (current != null){
            words = current.value.split(",");
        }

        if (value.equalsIgnoreCase(words[0])){
            return current.value;
        }

        return value.compareTo(current.value) < 0
        ? getNodeRecursive(current.left, value)
        : getNodeRecursive(current.right, value);
    }

   

    /**
     * @param value
     * Deletes the key from the treenode
     */
    public void deleteKey(String value) {
        root = delete_Recursive(root, value);
    }

    /**
     * @param root
     * @param value
     * @return Node
     * Recursive to delete
     */
    Treenode delete_Recursive(Treenode root, String value) {
        
        if (root == null) 
            return root;

        if (value.compareTo(root.value) == -1)
            root.left = delete_Recursive(root.left, value);
        else if (value.compareTo(root.value) == 1)
            root.right = delete_Recursive(root.right, value);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.value = minValue(root.right);

            root.right = delete_Recursive(root.right, root.value);
        }
        return root;
    }

    public String minValue (Treenode root) {
        String minVal = root.value;

        while (root.left != null) {
            minVal = root.left.value;
            root = root.left;
        }
        return minVal;
    } 

    /**
     * order values by sorting inOrder
     */
    public void inorder() {
        inorder_Recursive(root);
    }

    /**
     * @param root
     * Recursive for sorting inOrder
     */
    public void inorder_Recursive(Treenode root) {
        if (root != null){
            inorder_Recursive(root.left);
            System.out.println(root.value + " ");
            inorder_Recursive(root.right);
        }
    }
}