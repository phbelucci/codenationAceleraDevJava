package br.com.codenation.calculadora;

import static org.junit.Assert.assertNotNull;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.stream.DoubleStream;

public class CalculadoraSalarioTest {

	@Test
	public void salarioLiquidoIsNotNull() {
		assertNotNull(new CalculadoraSalario().calcularSalarioLiquido(1000.0));
	}

}