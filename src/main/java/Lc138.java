public class Lc138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node preHead = new Node(0);
        preHead.next = head;
        while (head != null) {
            Node copy = new Node(head.val);
            Node headNext = head.next;
            head.next = copy;
            copy.next = headNext;
            head = headNext;
        }
        head = preHead.next;
        while (head != null) {
            Node headCopy = head.next;
            Node headRandom = head.random;
            if (headRandom == null) {
                headCopy.random = null;
            } else {
                headCopy.random = headRandom.next;
            }
            head = head.next.next;
        }

        head = preHead.next;
        Node res = head.next;
        while (head.next.next != null) {
            Node headCopy = head.next;
            Node nextHead = head.next.next;
            headCopy.next = nextHead.next;
            head.next = nextHead;
            head = nextHead;
        }
        head.next = null;
        return res;
    }
}
