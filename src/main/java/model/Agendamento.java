/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pfsta
 */
public class Agendamento {
    private String nomeServidor;
    private String dataHora;

    public Agendamento(String nomeServidor, String dataHora) {
        this.nomeServidor = nomeServidor;
        this.dataHora = dataHora;
    }

    public Agendamento() {
    }

    public String getNomeServidor() {
        return nomeServidor;
    }

    public void setNomeServidor(String nomeServidor) {
        this.nomeServidor = nomeServidor;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
    
    
}
