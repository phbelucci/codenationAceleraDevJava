package br.com.codenation.desafioexe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DesafioApplicationSubmitTest {

	@Test
	public void fibonacciTemTamanho15() {
		assertEquals(15, DesafioApplication.fibonacci().size());
	}

	@Test
	public void fibonacciSequenciaCorreta() {
		List<Integer> expected = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377);
		assertEquals(expected, DesafioApplication.fibonacci());
	}

	@Test
	public void isFibonacci377() {
		assertTrue(DesafioApplication.isFibonacci(377));
	}

	@Test
	public void isFibonacci13() {
		assertTrue(DesafioApplication.isFibonacci(13));
	}

	@Test
	public void isNotFibonacci12() {
		assertFalse(DesafioApplication.isFibonacci(12));
	}

	@Test
	public void isNotFibonacci355() {
		assertFalse(DesafioApplication.isFibonacci(355));
	}

}
