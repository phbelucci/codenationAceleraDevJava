package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private final Time time = new Time();
	private final Jogador jogador = new Jogador();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if(id == null || nome.isEmpty() || dataCriacao == null || corUniformePrincipal.isEmpty() || corUniformeSecundario.isEmpty()){
			throw new UnsupportedOperationException("Existem campos obrigatórios não preenchidos!");
		} else {
			if(time.getTimeById(id).equals(id)){
				throw new IdentificadorUtilizadoException("Você está tentando cadastrar um time com um id já existente! Favor informar outro id.");
			} else {
				time.setTimes(new Time(id,nome,dataCriacao,corUniformePrincipal,corUniformeSecundario));
			}
		}
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(id == null || idTime == null || nome == null	|| dataNascimento == null || nivelHabilidade == null || salario == null){
			throw new UnsupportedOperationException("Existem campos obrigatórios não preenchidos!");
		} else {
			if (nivelHabilidade < 0 || nivelHabilidade > 100){
				throw new UnsupportedOperationException("Nivel de habilidade esta fora dos valores aceitaveis (0 a 100).");
			} else {
				if (jogador.getJogadorById(id) != null){
					throw new IdentificadorUtilizadoException("Você está tentando cadastrar um jogador com um id já existente! Favor informar outro id.");
				} else {
					if(time.getTimeById(idTime) != null){
						jogador.setJogadores(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
					} else {
						throw new TimeNaoEncontradoException("O time informado não existe!");
					}
				}
			}
		}
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		if(idJogador == null){
			throw new CapitaoNaoInformadoException("O Id do capitão precisa ser informado");
		} else {
			if(jogador.getJogadores(idJogador) == null){
				throw new JogadorNaoEncontradoException("Jogador informado não existe.");
			} else {
				jogador.setCapitao(idJogador);
			}
		}
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		if(idTime == null){
			throw new UnsupportedOperationException("O Id do time precisa ser informado.");
		} else {
			if(time.getTimeById(idTime) == null){
				throw new TimeNaoEncontradoException("O time não foi encontrado!");
			} else {
				if(jogador.getCapitao(idTime) == null){
					throw new CapitaoNaoInformadoException("O Id do capitão precisa ser informado.");
				} else {
					return jogador.getCapitao(idTime);
				}
			}
		}
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		if(idJogador == null){
			throw new UnsupportedOperationException("O Id do jogador precisa ser informado!");
		} else {
			if (jogador.getNomeJogador(idJogador) == null){
				throw new JogadorNaoEncontradoException("O jogador com o id " + idJogador + " não foi encontrado!");
			} else {
				return jogador.getNomeJogador(idJogador);
			}
		}
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		if(idTime == null){
			throw new UnsupportedOperationException("O Id do time precisa ser informado!");
		} else {
			if(time.getTimeById(idTime) == null){
				throw new TimeNaoEncontradoException("O time não foi encontrado!");
			} else {
				return time.getNome(idTime);
			}
		}
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if(idTime == null){
			throw new UnsupportedOperationException("O Id do time precisa ser informado!");
		} else {
			if(time.getTimeById(idTime) == null){
				throw new TimeNaoEncontradoException("O time não foi encontrado!");
			} else {
				return jogador.getJogadores(idTime);
			}
		}
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if(idTime == null){
			throw new UnsupportedOperationException("O Id do time precisa ser informado!");
		} else {
			if(time.getTimeById(idTime) == null){
				throw new TimeNaoEncontradoException("O time não foi encontrado!");
			} else {
				return jogador.getMelhorJogador(jogador.jogadoresDoTimeObjeto(idTime));
			}
		}
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		if(idTime == null){
			throw new UnsupportedOperationException("O Id do time precisa ser informado!");
		} else {
			if(time.getTimeById(idTime) == null){
				throw new TimeNaoEncontradoException("O time não foi encontrado!");
			} else if (jogador.getJogadores(idTime) == null) {
				throw new JogadorNaoEncontradoException("O time não possui Jogadores!");
			} else {
				return jogador.getJogadorMaisVelho(jogador.jogadoresDoTimeObjeto(idTime));
			}
		}
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return time.getTimes();
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		if(idTime == null){
			throw new UnsupportedOperationException("O id do time deve ser preenchido.");
		} else {
			if(time.getTimeById(idTime) == null){
				throw new TimeNaoEncontradoException("O time não foi encontrado!");
			} else {
				return jogador.getJogadorMaiorSalario(jogador.jogadoresDoTimeObjeto(idTime));
			}
		}
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if(idJogador == null){
			throw new UnsupportedOperationException("Id deve ser preenchido.");
		} else {
			if(jogador.getJogadores(idJogador).isEmpty()){
				throw new JogadorNaoEncontradoException("Jogador não existe.");
			} else {
				return jogador.getSalario(idJogador);
			}
		}
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		if(top == null){
			throw new UnsupportedOperationException("O tamanho da ranking precisa ser informado.");
		} else {
			if(jogador.existemJogares()){
				throw new JogadorNaoEncontradoException("Não existem jogadores cadastrados.");
			} else {
				return jogador.topJogadores(top);
			}
		}
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		if(timeDaCasa == null || timeDeFora == null){
			throw new UnsupportedOperationException("Campos precisam ser preenchidos.");
		} else {
			Time timeCasa = time.getTimeObjeto(timeDaCasa);
			Time timeFora = time.getTimeObjeto(timeDaCasa);

			if(timeCasa.getCorUniformePrincipal(timeDaCasa).equals(timeFora.getCorUniformePrincipal(timeDaCasa))){
				return timeFora.getCorUniformeSecundario(timeDeFora);
			}
			return timeFora.getCorUniformePrincipal(timeDeFora);
		}
	}
}
