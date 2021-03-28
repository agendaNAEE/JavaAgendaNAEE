/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerais;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author pfsta
 */
public class Resposta {
    private int cod;
    private Object informacao;

    public Resposta(int cod, Object informacao) {
        this.cod = cod;
        this.informacao = informacao;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Object getInformacao() {
        return informacao;
    }

    public void setInformacao(Object informacao) {
        this.informacao = informacao;
    }
    
    public String toString(){
        ObjectMapper mascara = new ObjectMapper();
      
        try{
            return mascara.writeValueAsString(this);
        }catch(JsonProcessingException ex){
                return "{\"cod\":500, \"informacao\":\"erro no JSON\"}";
        }
    }
}
