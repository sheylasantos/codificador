import java.util.ArrayList;
import java.util.BitSet;

public class Node implements Comparable<Node>{
//    private Node left;
//    private Node right;
//    private char carac;
//    private int value;
//    private int countLeft;
//    private int countRight;

    private int letter;
    private int value;
    private char carac;
    protected int count;
    protected char countChar;
    private Node left = null;
    private Node right = null;
    private BitSet bits = new BitSet();
    private int tamanhoBits=0;

    public int compareTo(Node n) {
        return (this.value - n.getValue());
    }

    public Node(int letter,int value) {
        this.letter=letter;
        this.value = value;
        //this.countLeft=0;
        //this.countRight=0;
    }

    public Node(char carac,int value) {
        this.carac=carac;
        this.value = value;
        this.letter=(int)carac;
        //this.countLeft=0;
        //this.countRight=0;
    }

    public boolean isLeaf(){
        return this.left==null && this.right==null;
    }

    public void setCountChar(char countChar) {
        this.countChar = countChar;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public BitSet getBits() {
        return bits;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public char getCarac(){
        return carac;
    }

    public int getLetter() {
        return letter;
    }

    public void insert(Node node) {
        if (node.value < this.value && this.left==null) {
            if (this.left == null) {
                this.left = node;
                this.left.setCountChar('0');
                this.left.setCount(0);
                this.bits.set(tamanhoBits,false);
                this.tamanhoBits++;
            } else {
                this.left.insert(node);
            }
        } else if (node.value > this.value || this.left!=null) {
            if (this.right == null) {
                this.right = node;
                this.right.setCountChar('1');
                this.right.setCount(1);
                this.bits.set(tamanhoBits,true);
                this.tamanhoBits++;
            } else {
                this.right.insert(node);
            }
        }
    }

    public Node search(int key) {
        if (key == this.letter) {
            return this;
        }

        if (value < this.letter) {
            if (this.left != null) {
                this.setCount(0);
                return this.left.search(key);
            }
        }

        if (key > this.letter) {
            if (this.right != null) {
                this.setCount(1);
                return this.right.search(key);
            }
        }

        return null;
    }



    /*public boolean equals(Object obj) {
        if (obj.getClass()!=this.getClass()){
            return super.equals(obj);
        }
        return this.letter==((Node)obj).letter;
    }*/

    /*public void remove(int key) {
        Node n=this;
        if (n.left==null&&n.right==null){
            n=null;
            n.letter=0;
            //this=n;
        }
        else if(n.right!=null&&n.left!=null){
            Node tmp=n.left;
            while (tmp!=null){
                tmp=tmp.right;
            }
            n=tmp;
            //n.value=tmp.value;
        }else if (n.right!=null){
            n=n.right;
            //n.value=n.value;
        }else{
            n=n.left;
        }
    }*/

//    public int heightLeft(int count){
//        if (this==null){
//            return 0;
//        }
//
//        if (this.left != null) {
//            countLeft=count++;
//            return this.left.heightLeft(countLeft);
//        }
//
//        return 0;
//        //return false;
//    }
//    public int heightRight(int count){
//
//        if (this==null){
//            return 0;
//        }
//
//
//        /*if (this.left != null) {
//            countRight=count++;
//            return this.right.heightRight(countRight);
//        }*/
//        return 0;
//        //return false;
//    }
}
