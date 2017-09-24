package algorithm;

/**
 * Created by naco_siren on 9/24/17.
 */
public class CircularCache<T> {

    public static void main(String... args) throws Exception{
        CircularCache<Integer> cache = new CircularCache<>(5);

        cache.add(1);
        cache.add(2);
        cache.add(3);
        cache.add(4);
        cache.add(5);
        try {
            cache.add(6);
        } catch (Exception e) {
            System.out.println("Exception caught as expected: " + e.getMessage());
        }
        // [1, 2, 3, 4, 5]

        Integer i1 = cache.get();
        Integer i2 = cache.get();
        Integer i3 = cache.get();
        // [4, 5]

        cache.add(7);
        cache.add(8);
        // [4, 5, 7, 8]

        Integer i4 = cache.get();
        Integer i5 = cache.get();
        // [7, 8]

        cache.add(9);
        cache.add(10);
        // [7, 8, 9, 10]

        return;
    }


    private int _capacity;
    private T[] _buffer;

    private int _size;
    private int _head;
    private int _tail;

    public CircularCache(int capacity){
        this._capacity = capacity;
        this._buffer = (T[]) new Object[capacity];

        this._size = 0;
        this._head = 0;
        this._tail = 0;
    }

    public void add(T value) throws Exception {
        if (_size < _capacity) {
            _buffer[_tail] = value;
            _size++;

            /* Adjust tail */
            _tail++;
            if (_tail == _capacity)
                _tail -= _capacity;
        } else {
            throw new Exception("Buffer overflow!");
        }
    }

    public T get() {
        T retval = _buffer[_head];

        /* Adjust head pointer */
        _head++;
        if (_head == _capacity)
            _head -= _capacity;

        _size--;

        return retval;
    }
}
