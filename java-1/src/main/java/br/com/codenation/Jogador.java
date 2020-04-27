package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Jogador {

    private List<Jogador> jogadores = new ArrayList<>();
    public List<Jogador> maioresjogadores = new ArrayList<>();
    private Long id;
    private Long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;
    private Boolean capitao;

    public Jogador(){ }

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.id = id;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;

    }

//    public static void main(String[] args) {
//        Jogador j = new Jogador(12345L,12L,"Paulo",LocalDate.of(1987,1,1),89,new BigDecimal(1200));
//        Jogador h = new Jogador(12346L,12L,"Paula",LocalDate.of(1955,1,1),65,new BigDecimal(1500));
//        Jogador i = new Jogador(12347L,12L,"Paulo Roberto",LocalDate.of(1948,1,1),99,new BigDecimal(2000));
//        Jogador n = new Jogador(12348L,12L,"Paulo A",LocalDate.of(1999,1,1),78,new BigDecimal(12000));
//        Jogador o = new Jogador(12349L,12L,"Paulo B",LocalDate.of(2005,1,2),45,new BigDecimal(120078));
//        j.setJogadores(j);
//        j.setJogadores(h);
//        j.setJogadores(i);
//        j.setJogadores(n);
//        j.setJogadores(o);
//
//        j.topJogadores(5);
//    }

    public LocalDate getDataNascimento(Long idJogador){
        for(Jogador jogador : jogadores){
            if(jogador.id.equals(idJogador)){
                return jogador.dataNascimento;
            }
        }
        return null;
    }

    public Integer getNivelHabilidade(Long idJogador){
        for(Jogador jogador: jogadores){
            if(jogador.id.equals(idJogador)){
                return jogador.nivelHabilidade;
            }
        }
        return null;
    }


    public String getNomeJogador(Long idJogadorSearched){
        for (Jogador jogador : jogadores){
            if(jogador.id.equals(idJogadorSearched)){
                System.out.println(jogador.nome);
                return jogador.nome;
            }
        }
        return null;
    }

    public void setJogadores(Jogador novoJogador) {
        jogadores.add(novoJogador);
    }

    public Long getJogadorById(Long idJogadorSearched){
        for (Jogador jogador : jogadores) {
            if (jogador.id.equals(idJogadorSearched)) {
                return jogador.id;
            }
        }
        return null;
    }

    public void setCapitao(Long idJogador) {
        Long timeDoJogador = getTimeByIdJogador(idJogador);
        for(Jogador jogador : jogadoresDoTimeObjeto(timeDoJogador)){
            if(jogador.id.equals(idJogador)){
                jogador.capitao = true;
            } else {
                jogador.capitao = false;
            }
        }
    }

    public Long getCapitao(Long idTimeCapitao){
        for(Jogador jogador : jogadoresDoTimeObjeto(idTimeCapitao)){
            if(jogador.capitao){
                return jogador.id;
            }
        }
        return null;
    }

    public List<Long> getJogadores(Long idTimeSearched){
        List<Long> jogadoresTime = new ArrayList<>();
        for(Jogador jogador: jogadoresDoTimeObjeto(idTimeSearched)){
            if(jogador.idTime.equals(idTimeSearched)) {
                jogadoresTime.add(jogador.id);
            }
        }
        return jogadoresTime;
    }

    public List<Jogador> jogadoresDoTimeObjeto(Long idTime){
        List<Jogador> jogadoresPortime = new ArrayList<>();
        for(Jogador jogador : jogadores){
            if(jogador.idTime.equals(idTime)){
                jogadoresPortime.add(jogador);
            }
        }
        return jogadoresPortime;
    }

    public Boolean existemJogares(){
        return !jogadores.isEmpty();
    }

    public Long getJogadorMaiorSalario(List<Jogador> jogadoresDoTime){
        Long jogadorMaiorSalario = null;
        BigDecimal maiorSalario = new BigDecimal(0);
        for (Jogador jogador : jogadoresDoTime){
            if(jogador.salario.compareTo(maiorSalario) > 0){
                jogadorMaiorSalario = jogador.id;
                maiorSalario = jogador.salario;
            }
        }
        return jogadorMaiorSalario;
    }

    public Long getMelhorJogador(List<Jogador> jogadoresDoTime){
        Long melhorJogador = null;
        int maiorNibelHabilidade = 0;
        for (Jogador jogador : jogadoresDoTime){
            if(jogador.nivelHabilidade > maiorNibelHabilidade){
                melhorJogador = jogador.id;
                maiorNibelHabilidade = jogador.nivelHabilidade;
            }
        }
        return melhorJogador;
    }


    public Long getJogadorMaisVelho(List<Jogador> jogadoresDoTime){
        Long jogadorMaisVelho = null;
        LocalDate menorDataNascimento = LocalDate.now();
        for (Jogador jogador : jogadoresDoTime){
            if(jogador.dataNascimento.isEqual(menorDataNascimento)){
                jogadorMaisVelho = jogador.id;
                menorDataNascimento = jogador.dataNascimento;
            } else if (jogador.dataNascimento.isBefore(menorDataNascimento)){
                jogadorMaisVelho = jogador.id;
                menorDataNascimento = jogador.dataNascimento;
            }
        }
        return jogadorMaisVelho;
    }

    public Long getTimeByIdJogador(Long idJogador){
        for (Jogador jogador : jogadores) {
            if (jogador.idTime.equals(idJogador)){
                return jogador.idTime;
            }
        }
        return null;
    }

    public BigDecimal getSalario(Long idJogador) {
        return salario;
    }

    public List<Long> topJogadores(int maxSizeList){
        Map<Long, Integer> topJogadoresMap = new HashMap<>();
        jogadores.forEach(jogador -> topJogadoresMap.put(jogador.id, jogador.nivelHabilidade));
        Map<Long, Integer> topJogadoresFinalOrdenado = topJogadoresMap.entrySet()
                .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        List<Long> topJogadoresId = new ArrayList<>();
        AtomicInteger controle = new AtomicInteger();
        topJogadoresFinalOrdenado.forEach((key, value) -> {
             if(controle.get() < maxSizeList){
                 topJogadoresId.add(key);
                 controle.getAndIncrement();
             }
        });
        return topJogadoresId;
    }
}
