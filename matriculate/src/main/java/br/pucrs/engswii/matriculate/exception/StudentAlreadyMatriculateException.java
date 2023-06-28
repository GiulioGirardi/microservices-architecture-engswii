package br.pucrs.engswii.matriculate.exception;

public class StudentAlreadyMatriculateException extends Exception {
    public StudentAlreadyMatriculateException() {
        super("Student already matriculate in this subject");
    }
}
