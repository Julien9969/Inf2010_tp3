package Node;

public class BinaryNode<T> {

    public BinaryNode<T> left = null;    // Pointer to the node on the left which should contain a value below this.value
    public BinaryNode<T> right = null;   // Pointer to the node on the right which should contain a value above this.value
    public int height = 0;
    public T value;

    public BinaryNode(T value) {
        this.value = value;
    }

    public BinaryNode(T value, int height) {
        this.value = value;
        this.height = height;
    }
    public Integer getValue(){
        return (Integer) this.value;
    }

    public BinaryNode<T> getNode(){
        return this;
    }

    public int height( BinaryNode<T> t) {
        return t == null ? -1: t.height;
    }

}
