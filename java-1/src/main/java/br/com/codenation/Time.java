package br.com.codenation;

import java.time.LocalDate;
import java.util.*;

public class Time {

    private List<Time> times = new ArrayList<>();
    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;

    public Time(){}

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public void setTimes(Time novoTime){
        times.add(novoTime);
    }

    public Time getTimeObjeto(Long idTime){
        for(Time time : times){
            if(time.id.equals(idTime)){
                return time;
            }
        }
        return null;
    }

    public Long getTimeById(Long idTimeSearched){
        for (Time time : times) {
            if (time.id.equals(idTimeSearched)) {
                return time.id;
            }
        }
        return null;
    }

    public String getNome(Long idTime) {
        for (Time time : times) {
            if (time.id.equals(idTime)) {
                return time.nome;
            }
        }
        return null;
    }

    public List<Long> getTimes(){
        List<Long> timesInLongArray = new ArrayList<>();
        for(Time time : times){
            timesInLongArray.add(time.id);
        }
        timesInLongArray.sort(null);
        return timesInLongArray;
    }

    public String getCorUniformePrincipal(Long idTime) {
        return corUniformePrincipal;
    }

    public String getCorUniformeSecundario(Long idTime) {
        return corUniformeSecundario;
    }
}
