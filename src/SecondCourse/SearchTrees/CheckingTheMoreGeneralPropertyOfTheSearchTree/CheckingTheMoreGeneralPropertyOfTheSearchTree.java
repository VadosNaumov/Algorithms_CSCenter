package SecondCourse.SearchTrees.CheckingTheMoreGeneralPropertyOfTheSearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class CheckingTheMoreGeneralPropertyOfTheSearchTree {

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
            BinaryTree.sum += k;
        }
        if (n != 0) {
            btr.inOrder();
            if (btr.check){
                System.out.println("CORRECT");
            } else {
                System.out.println("INCORRECT");
            }
        } else {
            System.out.println("CORRECT");
        }

    }

    private static class BinaryTree {

        private BeTrElement[] biTree;
        private int size;
        private static int sum = 0;     // сумма ключей
        public boolean check = true;    // проверка на дерево поиска
        public int k = Integer.MIN_VALUE;

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

        public BeTrElement getParentElement(int index) {
            Objects.checkIndex(biTree[index].getIndexParent(), size);
            return biTree[biTree[index].getIndexParent()];
        }

        public BeTrElement[] getBiTree() {
            return biTree;
        }

        public int inOrder(){
            return inOrder(0);
        }

        public int inOrder(int index) {
            if (!this.check) return -1;
            if (biTree[index].hasLeftElement()) {
                this.k = inOrder(biTree[index].getIndexLeft());
                if (this.k == biTree[index].getKey()) {
                    this.check = false;
                }
            }
            if (biTree[index].getKey() < this.k) {
                this.check = false;
            }
            this.k = biTree[index].getKey();
            if (biTree[index].hasRightElement()) {
                this.k = inOrder(biTree[index].getIndexRight());
            }
            return this.k;
        }

        private static class BeTrElement {

            private int key;            // ключ вершины
            private int indexParent;         // индекс родителя
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

            public int getIndexParent() {
                return indexParent;
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
