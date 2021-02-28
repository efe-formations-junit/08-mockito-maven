package fr.formation.test.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.formation.test.Operation;
import fr.formation.test.OperationImpl;
import fr.formation.test.exception.OperationException;

@ExtendWith(MockitoExtension.class)
public class TestMockito {

	@Mock
	Operation op;

	@Test
	public void testMockAnnotation() {
		System.out.println(op);
	}

	@Test
	public void testCreationMock1() {
		Operation op = mock(Operation.class);

		System.out.println(op);
	}

	@Test
	public void testCreationMock2() {
		Operation op = mock(Operation.class, "Operation de test");

		System.out.println(op);
	}

	@Test
	public void testMockOperationDefault() {
		Operation op = mock(Operation.class);

		assertEquals(0.0, op.addition(4, 5), () -> "Numérique : 0");
		assertEquals(0.0, op.division(0, 0), () -> "Numérique : 0");
	}


	@Test
	public void testStubbing1() {
		Mockito.when(op.addition(4, 5)).thenReturn(9.0);
		assertEquals(9, op.addition(4, 5));
	}


	@Test
	public void testStubbing2() {
		Mockito.when(op.division(0, 0)).thenThrow(OperationException.class);
		assertThrows(OperationException.class, ()->op.division(0, 0));
	}


	@Test
	public void testStubbing3() {
		Mockito.when(op.division(anyDouble(), eq(0.0))).thenThrow(OperationException.class);
		assertThrows(OperationException.class, ()->op.division(0.0, 0.0));
		assertThrows(OperationException.class, ()->op.division(1450.0, 0.0));
		assertThrows(OperationException.class, ()->op.division(-845.0, 0.0));
	}


	@Test
	public void testStubbing4() {
		Mockito.when(op.getRandomInt()).thenReturn(8,  6, -1, 89, 12);
		assertEquals(8, op.getRandomInt());
		assertEquals(6, op.getRandomInt());
		assertEquals(-1, op.getRandomInt());
		assertEquals(89, op.getRandomInt());
		assertEquals(12, op.getRandomInt());
	}

	@Test
	public void testVerify1() {
		Mockito.when(op.getRandomInt()).thenReturn(8);
		assertEquals(8, op.getRandomInt());
		
			// vérifie que la méthode getRandomInt() a été appelée une et une seule fois
		verify(op).getRandomInt();
	}

	@Test
	public void testVerify2() {
		Mockito.when(op.getRandomInt()).thenReturn(8);
		assertEquals(8, op.getRandomInt());
		assertEquals(8, op.getRandomInt());
		
			// vérifie que la méthode getRandomInt() a été appelée exactement 2 fois
		verify(op, Mockito.times(2)).getRandomInt();
	}

	@Test
	public void testVerify3() {
			// vérifie que la méthode getRandomInt() n'a jamais été appelée
		verify(op, Mockito.never()).getRandomInt();
	}


	@Test
	public void testVerify4() {
		Mockito.when(op.getRandomInt()).thenReturn(8,  6, -1, 89, 12);
		assertEquals(8, op.getRandomInt());
		assertEquals(6, op.getRandomInt());
		assertEquals(-1, op.getRandomInt());
		assertEquals(89, op.getRandomInt());
		assertEquals(12, op.getRandomInt());

		// vérifie que la méthode getRandomInt() a été appelée entre 3 et 10 fois
		verify(op, Mockito.atLeast(3)).getRandomInt();
		verify(op, Mockito.atMost(10)).getRandomInt();

		// vérifie que la méthode getRandomInt() a été appelée au moins 1 fois et auplus 1 fois
		op.getRandomIntList(5);
		verify(op, Mockito.atLeastOnce()).getRandomIntList(5);
		verify(op, Mockito.atMostOnce()).getRandomIntList(5);
	}


	@Test
	public void testSpy1() {
			Operation op = new OperationImpl();
			
			Operation spy = spy(op);
			spy.getRandomIntList(5);
			
			verify(spy, times(5)).getRandomInt();
	}

	
}
