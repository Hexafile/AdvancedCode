import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class BinarySearchTree<K extends Comparable<K>, V> implements Map<K, V> {

	BinarySearchTree<K, V> left;
	BinarySearchTree<K, V> right;
	K key;
	V value;

	public BinarySearchTree(K key, V value) {
		this.key = key;
		this.value = value;
		left = new BinarySearchTree<K, V>();
		right = new BinarySearchTree<K, V>();
	}

	public BinarySearchTree() {
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		return 1 + left.size() + right.size();
	}

	@Override
	public boolean isEmpty() {
		return key == null;
	}

	@Override
	public boolean containsKey(Object key) {
		return key.equals(search(key).key);
	}

	@Override
	public boolean containsValue(Object value) {
		if (!isEmpty()) {
			if (this.value.equals(value)) {
				return true;
			} else {
				boolean tmpleft = false, tmpright = false;
				if (!left.isEmpty()) {
					tmpleft = left.containsValue(value);
				}
				if (!right.isEmpty()) {
					tmpright = right.containsValue(value);
				}
				return tmpleft || tmpright;
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		if (this.isEmpty()) {
			this.key=key;
			this.value = value;
			left = new BinarySearchTree<K, V>();
			right = new BinarySearchTree<K, V>();
			return null;
		}
		if (this.key.compareTo((K) key) > 0) {
			if (!left.isEmpty()) {
				left.put(key, value);
			} else {
				left = new BinarySearchTree<K, V>(key, value);
				return value;
			}
		} else if (this.key.compareTo((K) key) < 0) {
			if (!right.isEmpty()) {
				right.put(key, value);
			} else {
				right = new BinarySearchTree<K, V>(key, value);
				return value;
			}
		} else if (this.key.equals(key)) {
			V tmp = this.value;
			this.value = value;
			return tmp;
		}
		return null;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		left = new BinarySearchTree<K, V>();
		right = new BinarySearchTree<K, V>();
		key = null;
		value = null;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public BinarySearchTree<K, V> search(Object Key) {
		if (this.key.compareTo((K) key) > 0) {
			if (!left.isEmpty()) {
				left.containsKey(key);
			}
		} else if (this.key.compareTo((K) key) < 0) {
			if (!right.isEmpty()) {
				right.containsKey(key);
			}
		} else if (this.key.equals(key)) {
			return this;
		}
		return null;
	}

}
