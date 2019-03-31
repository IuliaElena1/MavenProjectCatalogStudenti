/*
 * Copyright (c) 2019 SSI Schaefer Noell GmbH
 *
 * $Header: /data/cvs/Scolarizare/csilistru/isi_test9/src/com/ssn/ssijs/isi/Catalog/RezultatGrila.java,v 1.1 2019/02/28 08:56:43 csilistru Exp $
 */

package Catalog;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class RezultatGrila extends Rezultat {

  @OneToMany
  private double nrRaspunsuriCorecte;

  public RezultatGrila(double v){}

  public RezultatGrila(Test testG, double nrRaspunsuriCorecte) {
    super(testG);

    this.nrRaspunsuriCorecte = nrRaspunsuriCorecte;

  }

  @Override
  public double getNota() {

    return nrRaspunsuriCorecte / ((TestGrila) test).getNrIntrebariDinTest() * 10;
  }

  @Override
  public String getResultAsString() {

    return "" + this.getNota();
  }

  @Override
  public String toString() {
    return "Raspunsuri corecte : " + nrRaspunsuriCorecte;
  }

  @Override
  public String getStringForHTML() {

    return DF.format(getNota());
  }

}
