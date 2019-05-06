package com.example.tonton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static class ViewHolder {
        private Button plusButton;
        private Button minusButton;
        private Button updateButton;

        private TextView contText;
        private TextView totalText;
        private TextView atualText;

        private EditText inputEdit;
    }

    private ViewHolder viewHolder = new ViewHolder();
    private int cont = 0;
    private double actualValue = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.viewHolder.plusButton = this.findViewById(R.id.plus_button);
        this.viewHolder.minusButton = this.findViewById(R.id.minus_button);
        this.viewHolder.updateButton = this.findViewById(R.id.update_button);

        this.viewHolder.contText = this.findViewById(R.id.cont_text);
        this.viewHolder.totalText = this.findViewById(R.id.total_text);
        this.viewHolder.atualText = this.findViewById(R.id.atual_value);

        this.viewHolder.inputEdit = this.findViewById(R.id.input_edit);
    }

    private void updateViews() {
        this.viewHolder.contText.setText(String.valueOf(this.cont));

        this.viewHolder.atualText.setText(getString(R.string.atual_value) + " " + this.actualValue);
        this.viewHolder.totalText.setText(getString(R.string.total_value) + " " + this.actualValue * this.cont);
    }

    public void updateButton_click(View view) {
        try {
            double val = Double.parseDouble(this.viewHolder.inputEdit.getText().toString());
            this.actualValue = val;
            this.updateViews();
        } catch (Exception e) {
            Toast.makeText(view.getContext(), "Digite um valor", Toast.LENGTH_LONG).show();
        }
    }

    public void plusButton_click(View view) {
        this.cont++;
        this.updateViews();
    }

    public void minusButton_click(View view) {
        if (this.cont <= 0) {
            Toast.makeText(view.getContext(), "Valor nao pode ser menor que 0", Toast.LENGTH_LONG).show();
        } else {
            this.cont--;
            this.updateViews();
        }
    }



}
