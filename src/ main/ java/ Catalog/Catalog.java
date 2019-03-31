 

package Catalog;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Catalog {

    @OneToMany
  private List<Student> studenti = new ArrayList<>();
  private List<Test> teste = new ArrayList<>();
  private List<Rezultat> rezultate = new ArrayList<>();


  public Catalog(List<Student> studenti, List<Test> teste, List<Rezultat> rezultate) {
    this.studenti = studenti;
    this.teste = teste;
    this.rezultate = rezultate;
  }

  public Catalog () {}



  public static void main(String[] args) throws IOException {
    Catalog catalog = new Catalog();
    catalog.readFile();
    catalog.generateHtml();
  }

  public void readFile() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt"))); //citeste tot fisierul

    String studentiLine = br.readLine();
    readLinieStudenti(studentiLine); //citeste prima linie din fisier pt studenti

    String testLine = br.readLine(); //citeste a doua linie de teste
    readLineTeste(testLine);

    while (true) {
      String resultLine = br.readLine();
      if (resultLine == null) {
        break;
      }

      readLineStudentResult(resultLine);
    }
    br.close();

  }

  // Ghita, G1, 6
  public  void readLineStudentResult(String resultLine) {
    String[] splits = resultLine.split(",");
    String stundentNume = splits[0].trim();
    String testNume = splits[1].trim();

    Student student = getStudentByName(stundentNume);
    Test test = getTestById(testNume);
    Rezultat rezultat = test.createResult(splits);

    student.addResult(rezultat);

  }

  public Test getTestById(String resultLine) {

    for (Test test : teste) {
      if (test.getId().equals(resultLine)) {
        return test;
      }
    }

    return null;
  }

  private Student getStudentByName(String name) { //verifici daca studentul primit ca parametru este egal cu studentul din Array

    for (Student student : studenti) {
      if (student.getName().equals(name)) {
        return student;
      }
    }
    return null;

  }

  public void readLinieStudenti(String studentiLine) {
    String[] splits = studentiLine.split(","); //splituim linia dupa virgula
    for (String element : splits) { //parcurgem linia de studenti splituite dupa virgula
      Student student = new Student(element.trim());

      studenti.add(student);

    }

  }

  public void readLineTeste(String testeLine) {
    TestFactory testFactory = new TestFactory();
    String[] splits = testeLine.split(",");

    for (String element : splits) {
      teste.add(testFactory.createTest(element.trim()));
    }
  }

  public void listStud() {
    System.out.println(studenti);
  }

  public void generateHtml() throws FileNotFoundException {
    System.out.println(studenti);

    PrintWriter pw = new PrintWriter(new File("studenti.html"));

    pw.println("<TABLE border='1'");

    pw.println("<TR>");
    pw.println("<TH>" + "" + "</TH>");

    for (Test test : teste) {
      pw.println("<TH>" + test + "</TH>");
    }

    pw.println("<TH>Media</TH>");

    pw.println("</TR>");

    for (Student student : studenti) {
      pw.println("<TR>");
      pw.println("<TD>" + student.getName() + "</TD>");

      for (Test test : teste) {
        Rezultat result = student.getResulByTest(test);

        pw.println("<TD>" + (result != null ? result.getStringForHTML() : "--") + "</TD>");
      }

    }

    pw.println("</TABLE>");

    pw.close();
  }

}
