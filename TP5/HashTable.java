
public interface HashTable {
	public int put(String key, int value);

	public int get(String key);

	public boolean remove(String key);

	public boolean contains(String key);

	public int size();
}