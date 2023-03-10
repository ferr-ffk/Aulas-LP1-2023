package codigosFederal;

public class MaximoDivisorComum {
	public static int maximoDivisorComumRec(int a, int b) {
		if (b == 0)
			return a;
		else
			return maximoDivisorComumRec(b, a % b);
	}

	public static int maximoDivisorComumIte(int m, int n) {
		int _m = m;
		int _n = n;
		int _r = 0;
		do {
			_r = _m % _n;
			_m = _n;
			_n = _r;
		} while (_n != 0);
		return _m;
	}

	public static void main(String[] args) {
		int numero1 = maximoDivisorComumRec(20, 6);
		System.out.println(numero1);
		int numero2 = maximoDivisorComumIte(20, 6);
		System.out.println(numero2);
	}
}
