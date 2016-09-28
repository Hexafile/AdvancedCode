
public interface BidirectionnalMap<K1, K2> {
	public abstract K2 getFromPrimary(K1 k);

	public abstract K1 getFromSecondary(K2 k);

	public abstract void put(K1 k1, K2 k2);

	public abstract boolean isEmpty();

	public abstract void clear();

	public abstract void removeFromPrimary(K1 k1);
}
