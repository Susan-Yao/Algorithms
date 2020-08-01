package list;

public class intersection {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 主函数
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1); // 判断第一个链表有没有环 （有环：返回第一个入环节点；无环：返回null）
        Node loop2 = getLoopNode(head2); // 判断第二个链表有没有环 （有环：返回第一个入环节点；无环：返回null）
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    // 7.1 判断一个单链表 有没有环 （有环：返回第一个入环节点；无环：返回null）- 快慢指针
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; // n1 -> slow S
        Node n2 = head.next.next; // n2 -> fast F
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) { // 若快指针遇到了null
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; // n2 -> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    // 7.2 无环链表的相交问题 - 面试
    // 如果两个链表都无环，返回第一个相交节点，如果不想交，返回null
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null; // 最后一个节点不同 - 不想交
        }
        // n  :  链表1长度减去链表2长度的值 - diff
        if(n > 0){ // (n>0 1长；否则 2长) 谁长，谁的头变成cur1; 另一个的头变成cur2
            cur1 = head1;
            cur2 = head2;
        }
        else{
            cur1 = head2;
            cur2 = head1;
        }
        n = Math.abs(n);
        while (n != 0) { // 让长的cur1 先走n步
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    // 7.3 两个有环单链表，怎么找到第一个相交的节点
    //（四个参数：两个环的head，两个环的第一个入环节点（见7.1））
    // 两个有环链表，返回第一个相交节点，如果不想交返回null
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) { // 第一个入环节点相同 - 上Y下O型 - 同7.2
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            if(n > 0){ // (n>0 1长；否则 2长) 谁长，谁的头变成cur1; 另一个的头变成cur2
                cur1 = head1;
                cur2 = head2;
            }
            else{
                cur1 = head2;
                cur2 = head1;
            }
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else { // 第一个入环节点不同
            cur1 = loop1.next; // 让其中一个 第一个入环节点 继续走
            while (cur1 != loop1) { // 在环上转一圈
                if (cur1 == loop2) {  // 若能遇到另一个 第一个入环节点 - 牛角型
                    return loop1; // 返回loop1或loop2 都对
                }
                cur1 = cur1.next;
            }
            return null; // 若不能遇到另一个 第一个入环节点 - 不相交
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
