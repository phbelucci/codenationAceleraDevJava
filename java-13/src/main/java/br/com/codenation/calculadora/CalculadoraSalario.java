package br.com.codenation.calculadora;


public class CalculadoraSalario {

	double SALARIO_MINIMO = 1039.00;
	public long calcularSalarioLiquido(double salarioBase) {

		if(salarioBase <= SALARIO_MINIMO){
			return 0;
		} else {
			return Math.round(calcularInss(salarioBase));
		}

	}

	private double calcularInss(double salarioBase) {
		if(salarioBase <= 1500.00){
			salarioBase *= 0.92;
			return salarioBase;
		} else if (salarioBase >= 1500.01 && salarioBase <= 4000.00){
			salarioBase *= 0.91;
			if(salarioBase > 3000.00){
				return CalcularIrrf(salarioBase);
			} else {
				return salarioBase;
			}
		} else {
			salarioBase *= 0.89;
			return CalcularIrrf(salarioBase);
		}
	}
	private double CalcularIrrf(double salarioInss){
		if(salarioInss >= 3000.01 && salarioInss <= 5999.99){
			salarioInss *= 0.925;
			return salarioInss;
		} else {
			salarioInss *= 0.85;
			return salarioInss;
		}
	}


}