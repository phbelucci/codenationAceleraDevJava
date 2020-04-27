package challenge;

public interface Criptografia {

    String criptografar(String texto);

    String descriptografar(String texto);

    String converterTexto(String texto, String opcao, int chave);
}
