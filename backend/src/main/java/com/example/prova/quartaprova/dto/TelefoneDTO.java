package com.example.prova.quartaprova.dto;

import com.example.prova.quartaprova.model.Telefone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneDTO {

    private String numero;

    public static Telefone toEntity(TelefoneDTO telefoneDTO) {
        Telefone telefone = new Telefone();
        telefone.setTelefone(telefoneDTO.getNumero());

        return telefone;
    }

    public static TelefoneDTO toDTO(Telefone telefone) {
        TelefoneDTO telefoneDTO = new TelefoneDTO();
        telefone.setTelefone(telefone.getTelefone());

        return telefoneDTO;
    }

}