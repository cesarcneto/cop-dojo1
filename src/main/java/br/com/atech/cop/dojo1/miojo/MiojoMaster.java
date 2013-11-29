package br.com.atech.cop.dojo1.miojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sérgio Francisco Pina (sms.spina@gmail.com)
 */
public class MiojoMaster {

	List<Integer> listaMenor = new ArrayList<Integer>();
	List<Integer> listaMaior = new ArrayList<Integer>();

	public int cozinhar(final int miojo, final int tempoAmpulhetaA, final int tempoAmpulhetaB) {
		return cozinhar(miojo, tempoAmpulhetaA, tempoAmpulhetaB, 0);
	}

	private int cozinhar(final int tempoDeCozimentoIdeal, final int tempoAmpulhetaA, final int tempoAmpulhetaB, final int tempoTotal) {
		final int menor = menor(tempoAmpulhetaA, tempoAmpulhetaB);
		final int diferenca = diferenca(tempoAmpulhetaA, tempoAmpulhetaB);

		if (tempoAmpulhetaA == tempoDeCozimentoIdeal || tempoAmpulhetaB == tempoDeCozimentoIdeal) {
			return tempoTotal + tempoDeCozimentoIdeal;
		} else if (tempoAmpulhetaA == tempoAmpulhetaB) {
			// Nao da para cozinhar.
			return 0;
		} else if (verificaPar(tempoAmpulhetaA, tempoAmpulhetaB)) {
			// Nao da para cozinhar.
			return 0;
		} else {
			return cozinhar(tempoDeCozimentoIdeal, menor, diferenca, tempoTotal + menor);
		}

	}

	private int diferenca(final int numA, final int numB) {
		return numA - numB > 0 ? numA - numB : numB - numA;
	}

	private int maior(final int numA, final int numB) {
		return numA > numB ? numA : numB;
	}

	private int menor(final int numA, final int numB) {
		return numA < numB ? numA : numB;
	}

	private boolean verificaPar(final int ampulhetaA, final int ampulhetaB) {
		final Integer menor = menor(ampulhetaA, ampulhetaB);
		final Integer maior = maior(ampulhetaA, ampulhetaB);

		for (int i = 0; i < listaMenor.size(); i++) {
			if (listaMenor.get(i).equals(menor) && listaMaior.get(i).equals(maior)) {
				return true;
			}
		}

		listaMenor.add(menor);
		listaMaior.add(maior);

		return false;
	}

}
