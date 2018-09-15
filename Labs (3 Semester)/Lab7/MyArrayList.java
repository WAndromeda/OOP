import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

public class MyArrayList <E> extends AbstractList implements List {
    private E[] array;
    private int size;
    private int memory;

    MyArrayList(){
        array = (E[]) new Object[0];
        size = 0;
        memory = 0;
    }

    MyArrayList(Collection<? extends E> c){
        size = c.size();
        memory = size;
        array = (E[]) new Object[size];
    }

    MyArrayList (int initialCapacity){
        memory = initialCapacity;
        array = (E[]) new Object[memory];
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public E[] toArray() {
        return array;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E remove(int index) {
        E object = (E) new Object();
        memory--;
        E[] anotherArray = (E[]) new Object[memory];
        for (int i = 0, k =0; i < size; i++)
            if (i != index){
                anotherArray[k] = array[i];
                k++;
            }
            else
                object = array[i];
        array = anotherArray;
        size--;
        return object;
    }

    public boolean add(Object e) {
        if (size < Integer.MAX_VALUE) {
            size++;
            if (size > memory)
                memory *= 2;
            E[] anotherArray = (E[]) new Object[memory];
            for (int i = 0; i < size-1; i++)
                anotherArray[i] = array[i];
            anotherArray[size-1] = (E) e;
            array = anotherArray;
            return true;
        }else
            return false;
    }

    @Override
    public Object set(int index, Object element) {
        E e = array[index];
        E[] anotherArray = (E[]) new Object[memory];
        for (int i = 0; i < size; i++)
            if (i == index)
                anotherArray[i] = (E) element;
            else
                anotherArray[i] = array[i];
        array = anotherArray;
        return e;
    }

    @Override
    public void clear() {
        super.clear();
        array = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return ( size > 0 ? false : true);
    }

    @Override
    public String toString() {
        String str = new String("[");
        for (int i = 0; i < size; i++) {
            str += array[i];
            if (i != size-1)
                str += ", ";
        }
        str += "]";
        return str;
    }
}