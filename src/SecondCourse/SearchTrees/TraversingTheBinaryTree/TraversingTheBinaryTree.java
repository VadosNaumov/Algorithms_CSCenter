package SecondCourse.SearchTrees.TraversingTheBinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class TraversingTheBinaryTree {
    public static void main(String[] args) throws IOException {

        BufferedReader bfR = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfR.readLine());                  // число вершин
        BinaryTree btr = new BinaryTree(n);

        String[] line;
        for (int i = 0; i < n; i++) {
            line = bfR.readLine().split(" ");
            int k = Integer.parseInt(line[0]);
            int l = Integer.parseInt(line[1]);
            int r = Integer.parseInt(line[2]);
            btr.getBeTrElement(i).setKey(k);
            btr.getBeTrElement(i).setIndexLeft(l);
            btr.getBeTrElement(i).setIndexRight(r);
            if (l != -1) {
                btr.getLeftElement(i).setIndexParent(i);
            }
            if (r != -1) {
                btr.getRightElement(i).setIndexParent(i);
            }
        }

        System.out.println(btr.inOrder());
        System.out.println(btr.preOrder());
        System.out.println(btr.postOrder());
    }

    private static class BinaryTree {

        private BeTrElement[] biTree;
        private int size;

        public BinaryTree(int size) {
            this.size = size;
            this.biTree = new BeTrElement[size];
            for (int i = 0; i < size; i++) {
                biTree[i] = new BeTrElement(-1, -1,-1,-1);
            }
        }

        public BeTrElement getBeTrElement(int index) {
            Objects.checkIndex(index, size);
            return biTree[index];
        }

        public BeTrElement getLeftElement(int index) {
            Objects.checkIndex(biTree[index].getIndexLeft(), size);
            return biTree[biTree[index].getIndexLeft()];
        }

        public BeTrElement getRightElement(int index) {
            Objects.checkIndex(biTree[index].getIndexRight(), size);
            return biTree[biTree[index].getIndexRight()];
        }

        public String inOrder(){
            return inOrder(0);
        }

        public String inOrder(int index) {
            StringBuilder sb = new StringBuilder();
            if (biTree[index].hasLeftElement()) {
                sb.append(inOrder(biTree[index].getIndexLeft()));
            }
            sb.append(biTree[index].getKey()).append(" ");
            if (biTree[index].hasRightElement()) {
                sb.append(inOrder(biTree[index].getIndexRight()));
            }
            return sb.toString();
        }

        public String preOrder(){
            return preOrder(0);
        }

        public String preOrder(int index){
            StringBuilder sb = new StringBuilder();
            sb.append(biTree[index].getKey()).append(" ");
            if (biTree[index].hasLeftElement()) {
                sb.append(preOrder(biTree[index].getIndexLeft()));
            }
            if (biTree[index].hasRightElement()) {
                sb.append(preOrder(biTree[index].getIndexRight()));
            }
            return sb.toString();
        }

        public String postOrder(){
            return postOrder(0);
        }

        public String postOrder(int index){
            StringBuilder sb = new StringBuilder();
            if (biTree[index].hasLeftElement()) {
                sb.append(postOrder(biTree[index].getIndexLeft()));
            }
            if (biTree[index].hasRightElement()) {
                sb.append(postOrder(biTree[index].getIndexRight()));
            }
            sb.append(biTree[index].getKey()).append(" ");
            return sb.toString();
        }

        private static class BeTrElement {

            private int key;            // ключ вершины
            private int indexParent;    // индекс родителя
            private int indexLeft;      // индекс левого потомка
            private int indexRight;     // индекс правого потомка

            public BeTrElement(int key, int indexParent, int indexLeft, int indexRight) {
                this.key = key;
                this.indexParent = indexParent;
                this.indexLeft = indexLeft;
                this.indexRight = indexRight;
            }

            public int getKey() {
                return key;
            }

            public int getIndexLeft() {
                return indexLeft;
            }

            public int getIndexRight() {
                return indexRight;
            }

            public void setKey(int key) {
                this.key = key;
            }

            public void setIndexLeft(int indexLeft) {
                this.indexLeft = indexLeft;
            }

            public void setIndexRight(int indexRight) {
                this.indexRight = indexRight;
            }

            public void setIndexParent(int indexParent) {
                this.indexParent = indexParent;
            }

            public boolean hasLeftElement() {
                return this.indexLeft != -1;
            }

            public boolean hasRightElement() {
                return this.indexRight != -1;
            }
        }
    }
}
