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
		if (this.isEmpty()) {
			return false;
		} else if (this.key.equals(key)) {
			return true;
		} else {
			if (this.key.compareTo((K) key) > 0) {
				return left.containsKey(key);
			}
			return right.containsKey(key);
		}
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
			this.key = key;
			this.value = value;
			left = new BinarySearchTree<K, V>();
			right = new BinarySearchTree<K, V>();
			return null;
		} else {
			if (this.key.compareTo((K) key) > 0) {
				if (!left.isEmpty()) {
					left.put(key, value);
				} else {
					left = new BinarySearchTree<K, V>(key, value);
				}
			} else if (this.key.compareTo((K) key) < 0) {
				if (!right.isEmpty()) {
					right.put(key, value);
				} else {
					right = new BinarySearchTree<K, V>(key, value);
				}
			} else if (this.key.equals(key)) {
				V tmp = this.value;
				this.value = value;
				return tmp;
			}
		}
		return null;
	}

	@Override
	public V remove(Object key) {
		if (containsKey(key)) {
			if (!this.isEmpty()) {
				if (this.key.compareTo((K) key) > 0) {
					V tmp = left.value;
					left.remove(key);
					return tmp;
				} else if (this.key.compareTo((K) key) < 0) {
					V tmp = left.value;
					right.remove(key);
					return tmp;
				} else {
					if (right.isEmpty()) {
						if (!left.isEmpty()) {
							this.key = left.key;
							this.value = left.value;
							this.left = left.left;
							this.right = left.right;
						}
					} else {
						V tmp = this.value;
						K keyTmp = right.min();
						V valueTmp = remove(keyTmp);
						this.key = keyTmp;
						this.value = valueTmp;
						return tmp;
					}
				}
			}
		}
		return null;
	}

	public K min() {
		if (isEmpty()) {
			return null;
		}
		if (left == null && right == null) {
			return this.key;
		}
		return left.min();
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

	public String toString() {
		return subTree(this);
	}

	public String subTree(BinarySearchTree<K, V> bin) {
		String str = "";
		if (bin == null)
			return str;
		str += "(" + bin.key + "-" + bin.value;
		str += subTree(bin.left) + subTree(bin.right) + ")";
		return str;
	}
}
