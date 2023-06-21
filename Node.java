package laboratorio;

public class Node<T extends Comparable<T>> {

    private T information;
    private Node leftNodeTree;
    private Node rightNodeTree;

    public T getInformation() {
        return information;
    }

    public void setInformation(T information) {
        this.information = information;
    }

    public Node getLeftNode() {
        return leftNodeTree;
    }

    public void setLeftNode(Node leftNodeTree) {
        this.leftNodeTree = leftNodeTree;
    }

    public Node getRightNode() {
        return rightNodeTree;
    }

    public void setRightNode(Node rightNodeTree) {
        this.rightNodeTree = rightNodeTree;
    }

    public Node(T information) {
        this.information = information;
        this.leftNodeTree = null;
        this.rightNodeTree = null;
    }

}
