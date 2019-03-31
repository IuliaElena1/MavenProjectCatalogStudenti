/*
 * Copyright (c) 2019 SSI Schaefer Noell GmbH
 *
 * $Header: /data/cvs/Scolarizare/csilistru/isi_test9/src/com/ssn/ssijs/isi/Catalog/Student.java,v 1.2 2019/02/28 08:56:43 csilistru Exp $
 */

package Catalog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Student {


  @Id
  private String nume;

  @OneToMany
  private List<Rezultat> rezultate = new ArrayList<>();

  public Student(){}
  public Student(String nume) {
    this.nume = nume;

  }

  public Student(String nume, Rezultat test) {
    this.nume = nume;
    this.rezultate = getRezultate();
  }

  public String getName() {
    return nume;
  }

  public List<Rezultat> getRezultate() {
    return rezultate;
  }

  @Override
  public String toString() {
    return nume + rezultate;
  }

  public void addResult(Rezultat resultLine) {
    rezultate.add(resultLine);

  }

  public Rezultat getResulByTest(Test test) {
    for (Rezultat rezultat : rezultate) {
      if (rezultat.getTest().equals(test)) {
        return rezultat;
      }
    }

    return null;

  }

}
