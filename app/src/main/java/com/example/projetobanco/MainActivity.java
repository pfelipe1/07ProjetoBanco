    /*
     *@author: Felipe Pires de Araujo
     */

    /*
    Felipe Pires de Araujo
    1110482412004
    */

package com.example.projetobanco;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;

import com.example.projetobanco.model.ContaBancaria;
import com.example.projetobanco.model.ContaEspecial;
import com.example.projetobanco.model.ContaPoupanca;


public class MainActivity extends AppCompatActivity {

    private RadioButton rbPoupanca, rbEspecial;
    private EditText edCliente, edNumeroConta, edSaldo, edPesquisarNumConta, edNumContaOp, edValor, edContaRendimento;
    private Button btnIncluir, btnMostrar, btnDepositar, btnSacar, btnAtualizarRendimento;
    private TextView tvRes;

    private ContaBancaria conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        rbPoupanca = findViewById(R.id.rbPoupanca);
        edContaRendimento = findViewById(R.id.edContaRendimento);
        rbEspecial = findViewById(R.id.rbEspecial);
        edCliente = findViewById(R.id.edCliente);
        edNumeroConta = findViewById(R.id.edNumeroConta);
        btnIncluir = findViewById(R.id.btnIncluir);
        btnMostrar = findViewById(R.id.btnMostrar);
        btnDepositar = findViewById(R.id.btnDepositar);
        btnSacar = findViewById(R.id.btnSacar);
        edSaldo = findViewById(R.id.edSaldo);
        edValor = findViewById(R.id.edValor);
        edNumContaOp = findViewById(R.id.edNumContaOp);
        btnAtualizarRendimento = findViewById(R.id.btnAtualizarRendimento);
        edPesquisarNumConta = findViewById(R.id.edPesquisarConta);
        tvRes = findViewById(R.id.tvRes);

        btnIncluir.setOnClickListener(op -> IncluirConta());
        btnDepositar.setOnClickListener(op -> depositarValor());
        btnSacar.setOnClickListener(op -> sacarValor());
        btnMostrar.setOnClickListener(op -> mostrarDados());
        btnAtualizarRendimento.setOnClickListener(op -> atualizarSaldo());
    }

   public void IncluirConta() {
        String cliente = edCliente.getText().toString();
        int numero = Integer.parseInt(edNumeroConta.getText().toString());
        float saldo = Float.parseFloat(edSaldo.getText().toString());
        if(rbPoupanca.isChecked()){
            conta = new ContaPoupanca(cliente, numero, saldo, 1);
            tvRes.setText(R.string.contaCriada);
        } else if (rbEspecial.isChecked()) {
            conta = new ContaEspecial(cliente, numero, saldo, 1500);
            tvRes.setText(R.string.contaCriada);
        } else {
            tvRes.setText(R.string.erroSelectCOnta);
        }
   }

   public void depositarValor() {
       int numero = Integer.parseInt(edNumContaOp.getText().toString());
       float valor = Float.parseFloat(edValor.getText().toString());
       if(conta != null && conta.getNumeroConta() == numero) {
           conta.depositar(valor);
            }
       }

    public void sacarValor() {
        int numero = Integer.parseInt(edNumContaOp.getText().toString());
        float valor = Float.parseFloat(edValor.getText().toString());
        if(conta != null && conta.getNumeroConta() == numero) {
            conta.sacar(valor);
        }
    }

    public void mostrarDados() {
        int numero = Integer.parseInt(edPesquisarNumConta.getText().toString());
        if(conta != null && conta.getNumeroConta() == numero) {
            tvRes.setText(conta.getDadosConta());
        }
    }

    public void atualizarSaldo() {
        int numero = Integer.parseInt(edContaRendimento.getText().toString());
        if(conta != null && conta.getNumeroConta() == numero) {
            ((ContaPoupanca) conta).calcularNovoSaldo();
            tvRes.setText(R.string.atualizarValor);
        } else
        {
            tvRes.setText(R.string.erro);
        }
    }
}



