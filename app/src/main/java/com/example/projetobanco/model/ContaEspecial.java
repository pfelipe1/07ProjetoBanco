package com.example.projetobanco.model;

public class ContaEspecial extends ContaBancaria {
private float limite;

    public ContaEspecial(String cliente, int numeroConta, float saldo, float limite) {
        super(cliente, numeroConta, saldo);
        this.limite = limite;
    }



    public boolean sacar(float valor) {
        if(valor <= saldo + limite) {
            saldo = saldo - valor;
            return true;
        } else {
            return false;
        }
    }


    public String getDadosConta() {
        return super.getDadosConta() + "\n Limite: " + limite;
    }
}
