package br.com.senai.autoescolas164.domain.agenda.validacao;

import br.com.senai.autoescolas164.domain.agenda.DadosAgendamento;
import br.com.senai.autoescolas164.domain.agenda.ValidacaoException;

public interface ValidadorAgendamento {
    void validar(DadosAgendamento dados);
}
