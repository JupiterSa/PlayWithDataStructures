public class Array<E> {

    //创建一个数组
    private E[] data;
    //数组有多少个有效的元素
    private int size;

    //构造函数,传入数组的容量capacity来构造Array
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    //默认构造函数，当用户不知道(不传入capacity时调用)数组容量时，用无参构造函数创建一个10的数组
    public Array() {
        this(10); //这个参数的语义时capacity，时IDEA提供的
    }

    //用户传入静态数组，然后生成Array类
    public Array(E[] args) {
        data = args;
        size = args.length;
    }

    //获取数组有多少个元素
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapactiy() {
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    //向数组最后位置添加一个元素,在添加之前，要看数组是否还有空余位置
    public void addLast(E e) {
        add(size,e);
    }

    //向数组头添加元素
    public void addFirst (E e) {
        add(0,e);
    }

    //在第index个位置添加一个新元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            //index>size 代表不是紧密地在最后添加，会有跳过的地方
            throw new IllegalArgumentException("AddElement failed. Require index < 0 || index > size.");//先抛个异常，以后再处理
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        //index之后的元素依次向后挪动，然后将e放到poz处，size增加1
        //要被处理i的开始位置是index结束位置是size-1
        for (int i = size - 1; i >=index; i --) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    //查询
    //获取index索引位置的元素
    public E get (int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("AddElement failed. Require index < 0 || index >= size.");//先抛个异常，以后再处理
        } else {
            return data[index];
        }
    }

    public E getLast() {
        return get(size-1);
    }

    public E getFirst() {
        return get(0);
    }

    //修改
    //获取index索引位置的元素更新
    public void set (int index,E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("AddElement failed. Require index < 0 || index >= size.");//先抛个异常，以后再处理
        } else {
            data[index] = e;
        }
    }

    //查找是否包含某个元素
    public boolean contains (E e) {
        for (int i = 0; i < size; i ++) {
            if (data[i] == e) {
                return true;
             }
        }
        return false;
    }

    //查找某个元素的索引
    public int find (E e) {
        for (int i = 0; i < size; i ++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    //删除索引为index的某个元素,并且返回该元素的值
    public E remove (int index) {
        E ret = data[index];
        if (index < 0 || index > size) {
            //index>size 代表不是紧密地在最后添加，会有跳过的地方
            throw new IllegalArgumentException("AddElement failed. Require index < 0 || index > size.");//先抛个异常，以后再处理
        }
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        //index之后的元素依次向前挪动，size减1
        //要被处理i的开始位置是size-1结束位置是index
        for (int i = index; i < size -1 ; i ++) {
            data[i] = data[i + 1];
        }
        size --;
        return ret;
    }

    public E removeFirst (int index) {
        return remove(0);
    }

    public E removeLast () {
        return remove(size - 1);
    }

    //从数组中删除第一个元素e(e存在的情况下)
    public boolean removeElement (E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    //从数组中删除所有元素e
    public void removeAllElement (E e) {
        for (int i = 0; i < size; i ++) {
            if (data[i] == e) {
                remove(i);
            }
        }
    }
    //查找某个元素e的所有索引
    public void findAll (E e) {
        StringBuilder ret;
        for (int i = 0; i < size; i ++) {
            if (data[i] == e) {
                remove(i);
            }
        }
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d \n",size,data.length));//先打印数组有多少个内容和总容量
        res.append('[');//然后追究第一个左边的【
        for (int i = 0; i < size; i ++) {//从第一个打印，打印到index=size-1（即最后一个内容）
            res.append(data[i]);
            if(i != size -1) {//如果不是最后一个内容，则后面加的，逗号
                res.append(", ");
            }
        }
        res.append(']');//如果是最后一个则追加 】
        return res.toString();
    }

}
