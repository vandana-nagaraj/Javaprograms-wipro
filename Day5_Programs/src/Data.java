

// T is a generic type of class you are defining 
public class Data<T> {
	
	private T item;
	
	

	public T getItem() {
		return item;
	}



	public void setItem(T item) {
		this.item = item;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data d1 = new Data();
		d1.setItem("Hello");
		System.out.println(d1.getItem());
		d1.setItem(123);
		System.out.println(d1.getItem());
		
		Data<String> d2 = new Data();
		d2.setItem("shfkdhf");
	//	d2.setItem(343);
	}

}
