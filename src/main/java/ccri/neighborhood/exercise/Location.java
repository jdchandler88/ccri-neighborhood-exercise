package ccri.neighborhood.exercise;

import java.util.Objects;

@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class Location {

    private int x;

    private int y;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return getX() == location.getX() &&
                getY() == location.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
