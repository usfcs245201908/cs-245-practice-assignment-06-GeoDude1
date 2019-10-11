import java.util.*;
public class ArrayQueue<T> implements Queue<T>
{
	T[] array = (T[]) new Object[10];
	int first = 0;
	int last = 0;
	public T dequeue()
	{
		T item = array[first];
		first = (first+1) % array.length; 
		return item;
	}
	public void enqueue(T item)
		{
		if((last+1) % array.length == first) 
			{
				grow_array();
			}
				array[last++] = item;
				last = last % array.length;
		}
		public boolean empty()
		{
			return (first == last);
		}
	private void grow_array()
	{
		T[] newarray = (T[]) new Object[array.length*2];
		if(last > first)
		{
			System.arraycopy(array, first, newarray, 0, array.length-first);
		}
		else 
		{
			System.arraycopy(array, first, newarray, first, array.length-first);
			System.arraycopy(array, 0, newarray, array.length - first, last);
		}
		first = 0; 
		last = array.length-1; 
		array = newarray;
	}
}