import java.util.NoSuchElementException;

public class CircularQueue {
    private int front, rear;
    private int size;
    private Object[] arr;
    
    public CircularQueue()
    {
        arr = new Object[4];
        size = 0;
        front = rear = 0;
    }

    public void enQueue(Object obj)
    {
        if ((rear + 1) % arr.length == front)
        {
            resize(arr.length * 2);
        }
    
        rear = (rear + 1) % arr.length;
        arr[rear] = obj;
        size++;
    }

    public Object deQueue()
    {
        if (size == 0)
        {
            throw new NoSuchElementException();
        }

        front = (front + 1) % arr.length;
        Object res = arr[front];
        arr[front] = null;
        size--;
        if ((size > 0) && (size == arr.length / 4)) 
        {
            resize(arr.length / 2);
        }
        return res;
    }

    public void resize(int newSize)
    {
        Object[] newArr = new Object[newSize];
        for (int i = 1, j = front + 1; i <= size; i++, j++)
            newArr[i] = arr[j % arr.length];
        front = 0; rear = size;
        arr = newArr;
    }

    public Object[] getArr() 
    {
        return arr;
    }

    public Object peek() {return arr[(front + 1) % arr.length];}

    public int getSize() 
    {
        return size;
    }
}
