/*
 * Copyright (c) 2019 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package Catalog;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestFactory {

  public TestFactory(){}
   @Id
  public Test createTest(String text) { //contine doar G1(11) SAU P2 sau G2(12)
    text = text.trim();

    if (text.charAt(0) == 'G') {

      return new TestGrila(text.split("[()]"));
    } else {
      if (text.charAt(0) == 'P') {
        return new TestPractic(text.split("[()]"));

      }
    }

    return null;

  }
}
