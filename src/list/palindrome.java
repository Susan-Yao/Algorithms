package list;

import java.util.Stack;

public class palindrome {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // need n extra space - 笔试
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>(); // 额外空间 - 栈
        Node cur = head;
        while (cur != null) {
            stack.push(cur); // 都加入栈
            cur = cur.next;
        }
        while (head != null) {
            // 遍历链表，看和从栈中拿出来的是否一样
            if (head.value != stack.pop().value) {  // 若不一样，非回文
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // need O(1) extra space - 面试
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head; // 慢指针
        Node n2 = head; // 快指针
        while (n2.next != null && n2.next.next != null) { // find mid node 若有一个走完
            n1 = n1.next; // n1 -> mid
            n2 = n2.next.next; // n2 -> end
        }
        n2 = n1.next; // n2 -> 右半边第一个点
        n1.next = null; // mid.next -> null
        Node n3 = null;
        while (n2 != null) { // 反转右半边
            n3 = n2.next; // n3 -> save next node
            n2.next = n1; // next of right node convert （普通反转 n1为null，但这里n1为中点）
            n1 = n2; // n1 move
            n2 = n3; // n2 move
        }
        // 此时，n1是整个链表的最后一个节点
        n3 = n1; // n3 -> save last node
        n2 = head;// n2 -> left first node
        boolean res = true; // 是否为回文结构
        while (n1 != null && n2 != null) { // check palindrome （n2为头，从头开始遍历；n1为尾，从尾开始遍历）
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next; // left to mid
            n2 = n2.next; // right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // recover list 将右半边反回去
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.println(isPalindrome2(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");
    }
}
