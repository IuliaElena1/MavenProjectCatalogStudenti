
package Catalog;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class TestPractic extends Test {

  public TestPractic(){}
  @OneToMany
  private List<RezultatPractic> rezultateP = new ArrayList();

  public TestPractic(String[] splits) {
    super(splits[0]);

  }

  @Override
  public String createTestToString(String line) {

    return this.getId();
  }

  @Override
  public Rezultat createResult(String[] splits) {
    double notaImplementare = Double.parseDouble(splits[2]);
    double notaFunctionalitate = Double.parseDouble(splits[3]);
    return new RezultatPractic(this, notaImplementare, notaFunctionalitate);

  }

}