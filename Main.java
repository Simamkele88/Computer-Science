public class Main {
    public static void main(String[] args) {
        // Create the binary tree
        BinaryTree<String> tree = new BinaryTree<>();
        
        // Add root node A
        Position<String> root = tree.addRoot("A");
        
        // Add children B and C to A
        Position<String> b = tree.insertLeft(root, "B");
        Position<String> c = tree.insertRight(root, "C");
        
        // Add children D and E to B
        Position<String> d = tree.insertLeft(b, "D");
        Position<String> e = tree.insertRight(b, "E");
        
        // Add children F and G to C
        Position<String> f = tree.insertLeft(c, "F");
        Position<String> g = tree.insertRight(c, "G");
        
        // Add children H and I to G
        Position<String> h = tree.insertLeft(g, "H");
        Position<String> i = tree.insertRight(g, "I");
        
        // Visualize the tree structure
        System.out.println("Tree Structure:");
        printTree(tree, root, 0);
        
        // Print traversal results
        System.out.println("\nIn-order traversal:");
        for (String element : tree) {
            System.out.print(element + " ");
        }
        
        // Print some tree properties
        System.out.println("\n\nTree Properties:");
        System.out.println("Size: " + tree.size());
        System.out.println("Height: " + tree.height(root));
        System.out.println("Depth of G: " + tree.depth(g));
        System.out.println("Is D external? " + tree.isExternal(d));
    }
    
    // Helper method to print tree structure visually
    private static void printTree(BinaryTree<String> tree, Position<String> p, int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("    ");
        }
        
        System.out.println(indent + p.getElement());
        
        try {
            Position<String> left = tree.left(p);
            printTree(tree, left, depth + 1);
        } catch (IllegalArgumentException e) {
            // No left child
        }
        
        try {
            Position<String> right = tree.right(p);
            printTree(tree, right, depth + 1);
        } catch (IllegalArgumentException e) {
            // No right child
        }
    }
}