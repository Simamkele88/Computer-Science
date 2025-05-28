import tree.Tree;
import position.Position;

public class Main {
    public static void main(String[] args) {
        Tree<String> orgChart = new Tree<>();
        Position<String> ceo = orgChart.addRoot("CEO");
        Position<String> cto = orgChart.addChild(ceo, "CTO");
        Position<String> cfo = orgChart.addChild(ceo, "CFO");
        Position<String> devManager = orgChart.addChild(cto, "Dev Manager");
        orgChart.addChild(devManager, "Developer");

        System.out.println("Preorder Traversal:");
        for (Position<String> pos : orgChart.preorder()) {
            System.out.println(pos.getElement());
        }

        System.out.println("Height of tree: " + orgChart.height(ceo));
        System.out.println("Depth of CFO: " + orgChart.depth(cfo));
    }
}
