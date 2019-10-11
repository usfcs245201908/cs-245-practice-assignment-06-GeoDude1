import java.util.*;
public class ArrayStack<T> implements Stack<T>
{
	private T[] array = (T[]) new Object[10];
	private int first = -1;

	public void push(T item)
		{
			if(array.length - 1 == first) 
			{
				grow_array();
			}
			array[++first] = item; 
		}
	public T pop()
	{
		return array[first--]; 
	}
	public T peek()
	{
		return array[first]; 
	}
	public boolean empty(){
		if (first == -1){
			return true;
		}
		else
		{
			return false;
		}
	}
	private void grow_array()
	{
		T[] newarray = Arrays.copyOf(array, array.length*2); 
		array = newarray;
	}
}