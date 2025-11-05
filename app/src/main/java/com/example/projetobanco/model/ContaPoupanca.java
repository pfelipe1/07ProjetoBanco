package com.example.projetobanco.model;

public class ContaPoupanca extends  ContaBancaria{
    private int diaRendimento;
    private double taxa = 0.05;
    public ContaPoupanca(String cliente, int numeroConta, float saldo, int diaRendimento) {
        super(cliente, numeroConta, saldo);
        this.diaRendimento = diaRendimento;
    }

    public void calcularNovoSaldo() {
        saldo =  (float)(saldo + (saldo * taxa));
    }

    public String getDadosConta() {
        return super.getDadosConta() + "\n Dia Rendimento: " + diaRendimento;
    }
}

