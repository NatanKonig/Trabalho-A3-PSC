package com.psc;

import com.psc.view.frmprincipal.FrmPrincipal;

/**
 * Classe principal da aplicação.
 *
 * <p>Responsável por iniciar a aplicação e exibir a janela principal {@link FrmPrincipal}.</p>
 *
 * <p>Este é o ponto de entrada da aplicação Java Swing.</p>
 *
 * @author NatanKonig
 * @version 1.0
 */
public class Main {

    /**
     * Método principal que inicializa a aplicação.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
    }
}
