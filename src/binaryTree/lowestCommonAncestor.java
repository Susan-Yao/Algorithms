package binaryTree;

public class lowestCommonAncestor {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info{
        public boolean findo1;
        public boolean findo2;
        public Node findans;

        public Info (boolean f1, boolean f2, Node f){
            findo1 = f1;
            findo2 = f2;
            findans = f;
        }
    }

    public static Info process(Node x, Node o1, Node o2){
        if (x == null){
            return new Info(false, false,null);
        }
        Info leftInfo = process(x.left, o1, o2);
        Info rightInfo = process(x.right, o1, o2);

        // 左树找到了低共（o1, o2都在左树）
        if(leftInfo.findans != null){
            return new Info (true, true, leftInfo.findans);
        }
        // 右树找到了低共（o1, o2都在右树）
        if(rightInfo.findans != null){
            return new Info (true, true, rightInfo.findans);
        }

        // 左右都没有发现低共 - x为低共（o1, o2在左 右；o1, o2在右 左）
        if(leftInfo.findo1 && rightInfo.findo2){
            return new Info (true, true, x);
        }
        if(leftInfo.findo2 && rightInfo.findo1){
            return new Info (true, true, x);
        }

        // 左右都没有发现低共 - x为低共 （在子树中找到了o1或o2，另一个是x）
        // 左右都没有发现低共 - x不为低共 = 无低共 （在子树中找到了o1或o2，另一个不是x）
        boolean f1 = x==o1;
        boolean f2 = x==o2;
        if(leftInfo.findo1 || rightInfo.findo1){
            if(f2){
                return new Info (true, true,x);
            }
            else{
                return new Info (true, false,null);
            }
        }
        if(leftInfo.findo2 || rightInfo.findo2){
            if(f1){
                return new Info (true, true,x);
            }
            else{
                return new Info (false, true,null);
            }
        }

        // 左右子树都没有发现o1或o2
        return new Info(f1,f2,null);
    }

    public static Node lowestAncestor(Node head, Node o1, Node o2){
        Info info = process (head, o1, o2);
        return info.findans;
    }






    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.left = new Node(8);
        printTree(head);
        System.out.println("===============");

        Node o1 = head.left.right;
        Node o2 = head.right.left;
//        Node o1 = head;
//        Node o2 = head;

        System.out.println("o1 : " + o1.value);
        System.out.println("o2 : " + o2.value);
        System.out.println("ancestor : " + lowestAncestor(head, o1, o2).value);
        System.out.println("===============");

    }



}
