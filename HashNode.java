
public class HashNode {

	private String key;
	private String value;
	private HashNode next;
	
	public HashNode(String key) {
		this.setKey(key);
		this.setValue(null);
		this.setNext(null);
	}
	
	public HashNode(String key, String value) {
		this.setKey(key);
		this.setValue(value);
		this.setNext(null);
	}
	
	public HashNode(String key, HashNode next) {
		this.setKey(key);
		this.setValue(null);
		this.setNext(next);
	}
	
	public HashNode(String key, String value, HashNode next) {
		this.setKey(key);
		this.setValue(value);
		this.setNext(next);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public HashNode getNext() {
		return next;
	}

	public void setNext(HashNode next) {
		this.next = next;
	}
	
}
