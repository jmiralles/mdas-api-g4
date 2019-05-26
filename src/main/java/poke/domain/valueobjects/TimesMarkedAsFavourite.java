package poke.domain.valueobjects;

import java.util.Objects;

public class TimesMarkedAsFavourite {
  private Integer timesMarkesAsFavourite;

  public TimesMarkedAsFavourite(Integer timesMarkesAsFavourite) {
    this.timesMarkesAsFavourite = timesMarkesAsFavourite;
  }

  public Integer getTimesMarkesAsFavourite() {
    return timesMarkesAsFavourite;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimesMarkedAsFavourite that = (TimesMarkedAsFavourite) o;
    return timesMarkesAsFavourite.equals(that.timesMarkesAsFavourite);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timesMarkesAsFavourite);
  }
}
