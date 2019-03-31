/*
 * Copyright (c) 2019 SSI Schaefer Noell GmbH
 *
 * $Header: /data/cvs/Scolarizare/csilistru/isi_test9/src/com/ssn/ssijs/isi/Catalog/RezultatPractic.java,v 1.1 2019/02/28 08:56:43 csilistru Exp $
 */

package Catalog;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class RezultatPractic extends Rezultat {

    @OneToMany
  private double notaImplementare;
  private double notaFunctionalitate;

  public  RezultatPractic(){}

  public RezultatPractic(Test test, double notaImplementare, double notaFunctionalitate) {
    super(test);
    this.notaImplementare = notaImplementare;
    this.notaFunctionalitate = notaFunctionalitate;
  }

  @Override
  public double getNota() {

    return (notaImplementare + notaFunctionalitate) / 2;
  }

  public double getNotaImplementare() {
    return notaImplementare;
  }

  public double getNotaFunctionalitate() {
    return notaFunctionalitate;
  }

  @Override
  public String getResultAsString() {
    return getNota() + " (" + notaImplementare + "-" + notaFunctionalitate + ")";

  }

  @Override
  public String getStringForHTML() {

    return DF.format(getNota());
  }

}
