import java.io.*;
import java.util.Scanner;

public class Polynomial {

  double[] coefficient;
  int[] exponent;

  public Polynomial() {
    coefficient = new double[0];
    exponent = new int[0];
  }

  public Polynomial(double[] coefficient, int[] exponent) {
    this.coefficient = coefficient;
    this.exponent = exponent;
  }

  public Polynomial(File file) throws IOException {
    Scanner scanner = new Scanner(file);
    String line = scanner.nextLine();
    scanner.close();
    line = line.replace("-", "+-");
    String[] term = line.split("\\+");
    coefficient = new double[terms.length];
    exponent = new int[terms.length];
    for (int i = 0; i < terms.length; i++) {
      String[] temp = terms[i].split("x");
      this.coefficient[i] = Double.parseDouble(temp[0]);
      this.exponent[i] = (temp.length == 1) ? 0 : Integer.parseInt(temp[1]);
    }
  }


  public void saveToFile(String filename) throws IOException {
    FileWriter writer = new FileWriter(filename);
    String line = "";
    for (int i = 0; i < this.coefficient.length; i++) {
      line = line + this.coefficient[i] + "x" + this.exponent[i] + "+";
    }
    line = line.replace("+-", "-");
    line = line.replace.replace("x0", "");
    line = line.replace.replace(".0", "");
    writer.write(line);
    writer.close();
  }

  public Polynomial add(Polynomial other) {

    if (this.exponents.length == 0)
      return new Polynomial(other.coefficient, other.exponent);
    if (other.exponents.length == 0)
      return new Polynomial(this.coefficient, this.exponent);
    int max_exp = Math.max(this.exponent[this.exponent.length - 1],
                           other.exponent[other.exponent.length -1]);
    double[] temp_coe = new double[max_exp + 1];
    for (int i = 0; i < this.coefficient.length; i++)
      temp_coe[this.exponent[i]] += this.coefficient[i];
    for (int i = 0; i < other.coefficient.length; i++)
      temp_coe[other.exponent[i]] += other.coefficient[i];
    int len = 0;
    for (int i = 0; i < temp_coe.length; i++)
      if (temp_coe[i] != 0)
        len++;
    double[] new_coe = new double[len];
    int[] new_exp = new int[len];
    int j = 0;
    for (int i = 0; i < temp_coe.length; i++) {
      if (temp_coe[i] != 0) {
        new_coe[j] = temp_coe[i];
        new_exp[j] = i;
        j += 1;
      }
    }
    return new Polynomial(new_coe, new_exp);
  }

  public Polynomial multiply(Polynomial other) {
    if (this.exponents.length == 0)
      return new Polynomial(other.coefficient, other.exponent);
    if (other.exponents.length == 0)
      return new Polynomial(this.coefficient, this.exponent);
    int max_exp = Math.max(this.exponent[this.exponent.length - 1],
            other.exponent[other.exponent.length -1]);
    double[] temp_coe = new double[max_exp + 1];
    for (int i = 0; i < this.coefficient.length; i++)
      temp_coe[this.exponent[i]] = this.coefficient[i];

    for (int i = 0; i < other.coefficients.length; i++) {
      if (temp_coe[other.exponents[i]] == 0)
        temp_coe[other.exponent[i]] = other.coefficient[i];
      else
        temp_coe[other.exponent[i]] *= other.coefficient[i];
    }
    int len = 0;
    for (int i = 0; i < temp_coe.length; i++)
      if (temp_coe[i] != 0)
        len++;

    double[] new_coe = new double[len];
    int[] new_exp = new int[len];

    int j = 0;
    for (int i = 0; i < temp_coe.length; i++) {
      if (temp_coe[i] != 0) {
        new_coe[j] = temp_coe[i];
        new_exp[j] = i;
        j += 1;
      }
    }

    return new Polynomial(new_coe, new_exp);

  }

  public double evaluate(double x) {
    double res = 0.0;
    for (int i = 0; i < this.coefficient.length; i++)
      res += this.coefficient[i] * Math.pow(x, this.exponent[i]);
    return res;
  }
  public boolean hasRoot(double x) {
    return evaluate(x) == 0.0;
  }
}