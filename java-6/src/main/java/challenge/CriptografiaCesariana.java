package challenge;

import jdk.jfr.events.ExceptionThrownEvent;

import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String converterTexto(String texto, String opcao, int chave) {

        if(texto.isEmpty()){
            throw new IllegalArgumentException();
        } else if (texto.trim().equals("")){
            throw new NullPointerException();
        } else {
            String textoLower = texto.toLowerCase();
            int charInt = 0;
            String novoTexto = "";
            for (int i = 0; i < textoLower.length(); i++) {
                charInt = textoLower.charAt(i); // pega o valor na tabela asc
                if (charInt >= 97 && charInt <= 122) {
                    if (opcao.equals("Cripto")){
                        charInt += chave;
                    } else {
                        charInt -= chave;
                    }
                    if (charInt > 122 && opcao.equals("Cripto")){
                        charInt -= 26;
                        novoTexto += (char) charInt;
                    } else if (charInt < 97 && opcao.equals("Descripto")) {
                        charInt += 26;
                        novoTexto += (char) charInt;
                    } else {
                        novoTexto += (char) charInt;
                    }

                } else {
                        novoTexto += (char) charInt;
                }
            }
            return novoTexto;
        }

    }

    @Override
    public String criptografar(String texto) {
        return  converterTexto(texto.toLowerCase(), "Cripto", 3);
    }

    @Override
    public String descriptografar(String texto) {
        return  converterTexto(texto.toLowerCase(), "Descripto", 3);
    }
}


