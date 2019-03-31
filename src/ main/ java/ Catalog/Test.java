

package Catalog;

import javax.persistence.Entity;

@Entity
public abstract class Test {


  private String id;

  public Test(){}
  public Test(String id) {

    this.id = id;
  }

  public String getId() {
    return id;
  }

  public abstract String createTestToString(String line);

  public abstract Rezultat createResult(String[] splits);

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Test other = (Test) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Test id:" + id;
  }

}
