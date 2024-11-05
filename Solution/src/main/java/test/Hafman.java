package test;

import java.util.ArrayList;
import java.util.Stack;

public class Hafman {
    private int freq; //频率
    private char ch; //字符
    private String code; //编码
    private Hafman left;
    private Hafman right;

    public Hafman(){
        this.freq = 0;
        this.ch = 0;
    }
    public Hafman(int freq) {
        this.code = "";
        this.freq = freq;
    }
    public Hafman(int freq, char ch) {
        this.freq = freq;
        this.ch = ch;
    }


    public static void  Sort(ArrayList<Hafman> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).freq > list.get(j).freq) {
                    Hafman temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    public static String deCode(Hafman root, String code) {
        Hafman node = root;
        String result = "";
        for (int i = 0; i < code.length(); i++) {
            if(code.charAt(i)=='0'){
                node = node.left;
            }else{
                node = node.right;
            }
            if(node.ch>'a'&&node.ch<='z'){
                result += node.ch;
                node = root;
            }
            if(i==code.length()-1&&node!=root&&node.ch==0){
                result = "INVALID";
            }
        }
        if(result.length()==0){
            result = "INVALID";
        }
        return result;
    }
    public static void main(String[] args) {
        char [] chars = {'c', 'b', 'a', 'x', 'y', 'y', 'z','z'};

        // 1.统计词频率
        ArrayList<Hafman> list = new ArrayList<>(); //创建一个动态数组，存储输入节点
        for (char aChar : chars) { //遍历输入字符串的每个字符
            int i=0;
            for (i = 0; i < list.size(); i++) { //看数组中是否有该字符，如果有，频率+1
                if(list.get(i).ch==aChar){
                    list.get(i).freq++;
                    break;
                }
            }
            if(i== list.size()){ //列表没有，新加一个节点，频率设置为1
                list.add(new Hafman(1,aChar));
            }
        }

        // 备份列表，list要排序，构建树，所以备份list2,list2存放指针，指向list的元素
        ArrayList<Hafman> list2 = new ArrayList<>();
        for (Hafman hafman : list) {
            list2.add(hafman);
        }

        // 2.对list排序
        Sort(list);

        // 3.构建哈夫曼树
        while(list.size()>1){
            Hafman left = list.remove(0);
            Hafman right = list.remove(0);
            Hafman parent = new Hafman(left.freq+right.freq);
            parent.left = left;
            parent.right = right;
            list.add(parent);
            Sort(list);
        }
        Hafman root = list.get(0);

        // 4.递归遍历哈夫曼树，为每个字符编码
        Stack<Hafman> stack = new Stack<>();
        root.code = "";
        stack.push(root);
        while(!stack.isEmpty()){
            Hafman node = stack.pop();
            if(node.left!=null){
                node.left.code = node.code+"0";
                stack.push(node.left);
            }
            if(node.right!=null){
                node.right.code = node.code+"1";
                stack.push(node.right);
            }
        }

        // 5.输出编码结果
        for (Hafman hafman : list2) {
            System.out.println(hafman.ch+" "+hafman.code);
        }

        // 假设有一个编码
        System.out.println(deCode(root, "0100"));
        System.out.println(deCode(root, "011"));

    }
}
