public class FurnitureShop {
    private int size;
    private Furniture[] goods;

    FurnitureShop(){
        size = 0;
        goods = new Furniture[size];
    }

    public void setSize(int size) {
        this.size = size;
        goods = copy();
    }

    public int getSize() {
        return size;
    }

    public void add(Furniture furniture){
        size++;
        goods = copy();
        goods[size-1] = furniture;
    }

    public void deleteLast(){
        size--;
        goods = copyExcept(size);
    }

    public void deleteFirst(){
        size--;
        goods = copyExcept(0);
    }

    public void deletePosition(int pos){
        size--;
        goods = copyExcept(pos-1);
    }

    public void display(int pos){
        System.out.println(goods[pos-1] + "\n");
    }

    public void displayAll(){
        for (Furniture i : goods)
            System.out.println(i + "\n");
    }

    private Furniture[] copy(){
        Furniture[] t = new Furniture[size];
        for (int i = 0; i < goods.length; i++)
            t[i] = goods[i];
        return t;
    }

    private Furniture[] copyExcept(int pos){
        Furniture[] t = new Furniture[size];
        for (int i = 0, k = 0; i < goods.length ; i++, k++)
            if (i != pos)
                t[k] = goods[i];
            else
                k--;
        return t;
    }
}
