package poke.domain.valueobjects;

import java.util.Objects;

public class UserId {
  private String userId;

  public UserId(String userId) {
    this.userId = userId;
  }

  public String getUserId() {
    return userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserId userId1 = (UserId) o;
    return Objects.equals(userId, userId1.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId);
  }
}
