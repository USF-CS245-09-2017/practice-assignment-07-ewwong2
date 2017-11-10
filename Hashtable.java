
public class Hashtable {
	
	private HashNode[] arr;
	private int elements;
	
	public Hashtable() {
		arr = new HashNode[200000];
		elements = 0;
	}
	
	public void put(String key, String val) {
		// find the bucket that key belongs to
		int bucket = Math.abs(key.hashCode())%arr.length;
		HashNode temp = arr[bucket];
		// set the bucket to be a new hash node 
		// with key and val that points to the next
		// node of the linked list in the bucket
		arr[bucket] = new HashNode(key, val, temp);
		// increment elements
		elements++;
	}

	public Object get(String key) {
		// find bucket that key belongs to
		int bucket = Math.abs(key.hashCode())%arr.length;
		HashNode temp = arr[bucket];
		// iterate through linked list 
		while (temp!=null) {
			// if temp's key is equal to key
			if (temp.getKey().equals(key)) {
				// return the value of temp
				return temp.getValue();
			}
			// if not found, iterate to next node in
			// linked list
			temp = temp.getNext();
		}
		return null;
	}

	public String remove(String key) {
		// find bucket that key belongs to
		int bucket = Math.abs(key.hashCode())%arr.length;
		// dummy head
		HashNode temp = new HashNode(null,null,arr[bucket]);
		if (temp.getNext()==null) {
			// if bucket is empty
			throw new IndexOutOfBoundsException("Key not found in table");
		} else if (temp.getNext().getKey().equals(key)) {
			// if key is first node is bucket
			String val = temp.getNext().getValue();
			// shift bucket to next node
			arr[bucket] = temp.getNext().getNext();
			// decrement elements
			elements--;
			// return value of removed element
			return val;
		} else {
			// if not first and not empty
			// iterate through linked list
			while (temp.getNext()!=null) {
				// if the next node's key is equal to key
				if (temp.getNext().getKey().equals(key)) {
					String val = temp.getNext().getValue();
					// set temp to the next next node
					// (skip temp.getNext())
					temp.setNext(temp.getNext().getNext());
					// decrement elements
					elements--;
					// return value of removed element
					return val;
				}
				// iterate to next node in linked list
				temp = temp.getNext();
			}
		}
		// if key was not found in the bucket
		throw new IndexOutOfBoundsException("Key not found in table");
	}

	public boolean containsKey(String key) {
		// find the bucket that key belongs to
		int bucket = Math.abs(key.hashCode())%arr.length;
		HashNode temp = arr[bucket];
		// iterate through linked list
		while (temp!=null) {
			// if temp.getKey() is equal to key
			if (temp.getKey().equals(key)) {
				return true;
			}
			// iterate to next node
			temp = temp.getNext();
		}
		// if key was not found in bucket
		return false;
	}

	public int getElements() {
		return elements;
	}
	
}
