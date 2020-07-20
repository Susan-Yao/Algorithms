package lianbiao;

public class reverse {

    // 单链表 single linked list
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 反转单链表
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
//            反转步骤
//            1.记录下后面的部分 next
//            2.当前的.next指向前面 pre
//            3.将pre后移一个
//            4.将next后移一个
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        // 此时，head = null（最后一个点的next）；pre = 最后一个节点；next = null（最后一个点的next）

        return pre;
    }

    // 打印单链表
    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    // 双链表
    public static class DoubleNode {
        public int value;
        public DoubleNode last; // 上一个
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    // 反转双链表
    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
//        反转步骤
//        1.记录下后面的部分 next
//        2.当前的.next指向前面 pre
//        3.当前的.last指向后面 next
//        4.将pre后移一个
//        5.将next后移一个
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 打印双链表
    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        // 按.next的顺序打印一遍
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        // 按.last的顺序打印一遍
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // 单链表
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);

        // 双链表
        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseList(head2));
    }
}
