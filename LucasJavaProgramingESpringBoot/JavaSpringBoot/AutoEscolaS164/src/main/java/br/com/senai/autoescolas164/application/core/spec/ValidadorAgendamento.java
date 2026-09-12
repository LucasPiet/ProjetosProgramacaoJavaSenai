package br.com.senai.autoescolas164.application.core.spec;

import br.com.senai.autoescolas164.adapter.in.controller.request.instrucao.DadosAgendamento;

public interface ValidadorAgendamento {
    void validar(DadosAgendamento dados);
}
