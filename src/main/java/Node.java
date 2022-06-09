class Node {
    int val;
    Node next;
    Node random;
    Node parent;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
        this.parent = null;
    }
}