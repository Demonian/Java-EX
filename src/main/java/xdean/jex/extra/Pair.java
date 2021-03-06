package xdean.jex.extra;

import java.util.Objects;

/**
 * @author XDean
 *
 * @param <K>
 * @param <V>
 */
public class Pair<K, V> {
  private static final Pair<?, ?> EMPTY = new Pair<>(null, null);

  public static <K, V> Pair<K, V> of(K k, V v) {
    return new Pair<>(k, v);
  }

  @SuppressWarnings("unchecked")
  public static <K, V> Pair<K, V> empty() {
    return (Pair<K, V>) EMPTY;
  }

  private final K left;
  private final V right;

  public Pair(K k, V v) {
    this.left = k;
    this.right = v;
  }

  public K getLeft() {
    return left;
  }

  public V getRight() {
    return right;
  }

  public <L> Pair<L, V> left(L left) {
    return Pair.of(left, right);
  }

  public <R> Pair<K, R> right(R right) {
    return Pair.of(left, right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null) {
      return false;
    } else if (!(obj instanceof Pair)) {
      return false;
    }
    Pair<?, ?> other = (Pair<?, ?>) obj;
    return Objects.equals(left, other.left) && Objects.equals(right, other.right);
  }

  @Override
  public String toString() {
    return "Pair [left=" + left + ", right=" + right + "]";
  }
}
