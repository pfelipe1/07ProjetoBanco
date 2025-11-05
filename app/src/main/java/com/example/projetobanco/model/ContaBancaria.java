    /*
     *@author: Felipe Pires de Araujo
     */

package com.example.projetobanco.model;

public class ContaBancaria {
    private String cliente;
    private int numeroConta;
    protected float saldo;

    public ContaBancaria(String cliente, int numeroConta, float saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public boolean sacar(float valor) {
        if(valor <= saldo) {
            saldo = saldo - valor;
            return true;
        } else {
        return false;
        }
    }

    public boolean depositar(float valor) {
        if(valor > 0) {
            saldo = saldo + valor;
            return true;
        } else {
            return false;
        }
    }

    public float getSaldo() {
        return saldo;
    }

    public float getNumeroConta() {
        return numeroConta;
    }

    public String getDadosConta() {
        return "Cliente :" + cliente + "\n Conta: " + numeroConta + "\n Saldo: " + saldo ;
    }



}


