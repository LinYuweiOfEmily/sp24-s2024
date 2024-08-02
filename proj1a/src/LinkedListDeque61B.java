import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    private IntNode sentinel;
    private IntNode last;

    private int size;
    public class IntNode{
        public T first;
        public IntNode next;
        public IntNode before;
        public IntNode(T f,IntNode b,IntNode n){
            first = f;
            next = n;
            before = b;
        }

        public T getRecursive(int index){
            if(index==0){
                return this.first;
            }
            return this.next.getRecursive(index-1);
        }


    }

    public LinkedListDeque61B() {
        sentinel = new IntNode(null,null,null);
        last = sentinel;
    }

    @Override
    public void addFirst(T x) {
        IntNode n = new IntNode(x,sentinel,null);
        if(sentinel.next==null){
            sentinel.before = n;
            last = n;
            n.next = sentinel;
        }else {
            sentinel.next.before = n;
            n.next = sentinel.next;
        }
        sentinel.next = n;
        this.size++;
    }

    @Override
    public void addLast(T x) {
        IntNode n = new IntNode(x,last,sentinel);
        last.next = n;
        last = n;
        sentinel.before = last;
        this.size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        IntNode p = sentinel;
        while (p.next!=sentinel){
            p = p.next;
            returnList.add(p.first);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.next == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if(size==0){
            return null;
        }
        IntNode n = sentinel.next;
        if(size==1){
            last = sentinel;
            sentinel.next = null;
            sentinel.before = null;
        }else {
            sentinel.next = n.next;
            n.next.before = sentinel;
        }
        size--;
        T f = n.first;
        n = null;
        return f;
    }

    @Override
    public T removeLast() {
        if(size==0){
            return null;
        }
        IntNode n = last;
        if(size==1){
            last = sentinel;
            sentinel.next = null;
            sentinel.before = null;
        }else{
            last = n.before;
            last.next = sentinel;
            sentinel.before = last;
        }
        size--;
        T f = n.first;
        n = null;
        return f;
    }

    @Override
    public T get(int index) {
        if(index<0||index>=size){
            return null;
        }
        int count = -1;
        IntNode p = sentinel;
        while (count<index){
            p = p.next;
            count++;
        }
        return p.first;
    }

    @Override
    public T getRecursive(int index) {
        if (index<0||index>=size){
            return null;
        }
        return sentinel.getRecursive(index+1);
    }

}
