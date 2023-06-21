package laboratorio;

public class FamilyTree<T extends Comparable<T>> {

    private Node rootNode = null;

    public boolean isEmpty() {
        return rootNode == null;
    }

    public FamilyTree(T info) {
        this.rootNode = new Node(info);
    }

    public void addPerson(T info, T newPerson, Kinship kinship) {

        Node node = getNode(info);

        if (node == null) {
            System.out.println("Pessoa não encontrada.");
        } else {
            if (kinship == Kinship.FATHER) {
                node.setLeftNode(new Node(newPerson));
            } else {
                node.setRightNode(new Node(newPerson));
            }
        }

    }

    private Node getNode(T value, Node subRoot) {
        if (subRoot == null) {
            return null;
        }

        if (compare(value, subRoot.getInformation()) == NodeCompare.EQUALS) {
            return subRoot;
        }

        Node left = getNode(value, subRoot.getLeftNode());
        if (left != null) {
            return left;
        }

        Node right = getNode(value, subRoot.getRightNode());
        if (right != null) {
            return right;
        }

        return null;
    }

    public Node getNode(T value) {
        return getNode(value, rootNode);
    }

    private NodeCompare compare(T nodeA, Comparable nodeB) {
        if (nodeA.compareTo((T) nodeB) > 0) {
            return NodeCompare.BIGGER;
        }

        if (nodeA.compareTo((T) nodeB) < 0) {
            return NodeCompare.SMALLER;
        }

        return NodeCompare.EQUALS;
    }

    public void calculateDegreeOfKinship(T person1, T person2) {
        Node nodePerson1  = getNode(person1, rootNode);
        Node nodePerson2 = getNode(person2, rootNode);

        if (person1 == null || person2 == null) {
            System.out.println("Pessoas não encontradas na árvore genealógica.");
        }

        int degree = calculateDegreeRecursive(nodePerson1, nodePerson2, 0);

        System.out.println("O grau de parentesco é: " + degree);
    }

    private int calculateDegreeRecursive(Node currentPerson, Node targetPerson, int currentDegree) {
        if (currentPerson == targetPerson) {
            return currentDegree;
        }

        int degree = -1;

        if (currentPerson.getLeftNode() != null) {
            degree = calculateDegreeRecursive(currentPerson.getLeftNode(), targetPerson, currentDegree + 1);
        }

        if (degree == -1 && currentPerson.getRightNode() != null) {
            degree = calculateDegreeRecursive(currentPerson.getRightNode(), targetPerson, currentDegree + 1);
        }

        return degree;
    }


    public void printTreeVisual() {
        printTreeVisualRecursive(rootNode, "");
    }

    private void printTreeVisualRecursive(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + "└── " + node.getInformation());

        String branchPrefix = indent + (indent.isEmpty() ? "    " : "│   ");

        printTreeVisualRecursive(node.getLeftNode(), branchPrefix + "├── PAI: ");
        printTreeVisualRecursive(node.getRightNode(), branchPrefix + "└── MÃE: ");
    }

}
