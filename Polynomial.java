public class Polynomial {
	private double[] coefficient;
	public Polynomial () {
		coefficient = new double[0];
	}
	public Polynomial(double[] coefficient) {
		this.coefficient = coefficient;
	}
	public Polynomial add(Polynomial other) {
		double[] c;
		int a = this.coefficient.length;
		int b = other.coefficient.length;
		if (a>b)
			c = new double[a];
		else
			c = new double[b];
		return new Polynomial(c);
	}
	public double evaluate (double x) {
		double val = 0.0;
		int i=0;
		while (i<this.coefficient.length) {
			val = val+this.coefficient[i]*Math.pow(x,i);
			i++;	
		}
		return val;
	}
	public boolean hasRoot(double x) {
		return evaluate(x)==0.0;
	}
}