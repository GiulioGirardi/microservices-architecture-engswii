package br.pucrs.engswii.matriculate.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatriculateDTO {
    Long id;
    Long registrationStudent;
    String subjectCode;
    Long subjectClass;
}
