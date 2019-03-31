
package Catalog;

import javax.persistence.Entity;
import java.text.DecimalFormat;
@Entity
public abstract class Rezultat {


  protected final static DecimalFormat DF = new DecimalFormat("#.00");
  protected Test test;

  public Rezultat(){}
  public Rezultat(Test test) {
    super();
    this.test = test;
  }

  public abstract double getNota();

  public abstract String getResultAsString();

  @Override
  public String toString() {

    return "Rezultat " + test;
  }

  public Test getTest() {
    return test;
  }

  public abstract String getStringForHTML();

}
