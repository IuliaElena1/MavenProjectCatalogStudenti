
package Catalog;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class TestGrila extends Test {

  @OneToMany
  private double nrIntrebariDinTest;

  public TestGrila(){}
  public TestGrila(String[] splits) {
    super(splits[0]);
    nrIntrebariDinTest = Integer.parseInt(splits[1]);

  }

  public double getNrIntrebariDinTest() {
    return nrIntrebariDinTest;
  }

  @Override
  public String createTestToString(String line) {

    return super.getId() + "(" + this.nrIntrebariDinTest + ")";
  }

  @Override
  public Rezultat createResult(String[] splits) {
    return new RezultatGrila(this, Double.parseDouble(splits[2])); //this ia tot obiectul nu doar nr de intrebari sau id-ul

  }
}