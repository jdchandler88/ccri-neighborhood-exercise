package ccri.neighborhood.exercise;

import java.util.Objects;

/**
 * Representation of a location within a neighborhood with (X,Y) coordinates.
 */
@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class Location {

  @SuppressWarnings("checkstyle:MemberName")
  private final int x;

  @SuppressWarnings("checkstyle:MemberName")
  private final int y;

  /**
   * Creates location with specified coordinates.
   * @param x horizontal component of location
   * @param y vertical component of location
   */
  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Location)) {
      return false;
    }
    Location location = (Location) o;
    return getX() == location.getX()
        && getY() == location.getY();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getX(), getY());
  }

}
