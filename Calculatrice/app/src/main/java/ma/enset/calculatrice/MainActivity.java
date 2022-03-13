package ma.enset.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //déclaration des buttons
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bplus,bmoins,betoile,bdiv,bc,begal,bpoint,bnigative;
    EditText res;
    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0 = (Button) findViewById(R.id.button0);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);

        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        bplus = (Button) findViewById(R.id.buttonPlus);
        bmoins = (Button) findViewById(R.id.buttonMains);
        betoile = (Button) findViewById(R.id.buttonProdui);
        bdiv = (Button) findViewById(R.id.buttonDivis);
        bc = (Button) findViewById(R.id.buttonC);
        begal = (Button) findViewById(R.id.buttonEgal);
        bpoint = (Button) findViewById(R.id.buttonPoint);
        bnigative = (Button) findViewById(R.id.buttonPositiveNegative);

        res = (EditText) findViewById(R.id.EditText01);
        // opération d'addition
        bplus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }
        });

        //opération Mopins
        bmoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }
        });

        //opération multiplication
        betoile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                etoileClick();
            }
        });

        // opération de division
        bdiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }
        });

        begal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });

        bpoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
            }
        });


        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });
        bnigative.setOnClickListener(new View.OnClickListener() {
            public  void onClick(View v){ nigativeClick(); }
        });

    }


    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton 0,1,2,3,4,5,6,7,8,9
    public void chiffreClick(String str) {
        if(update){
            update = false;
        }else{
            if(!res.getText().equals("0"))
                str = res.getText() + str;
        }
        res.setText(str);



    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton +
    public void plusClick(){

        if(clicOperateur){
            calcul();
            res.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(res.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }



    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton -
    public void moinsClick(){
        if(clicOperateur){
            calcul();
            res.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(res.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton *
    public void etoileClick(){
        if(clicOperateur){
            calcul();
            res.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(res.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton /
    public void divClick(){
        if(clicOperateur){
            calcul();
            res.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(res.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }


    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton =
    public void egalClick(){
        calcul();
        update = true;
        clicOperateur = false;
    }

    //voici la méthode qui est  exécutée lorsque l'on clique sur le bouton C
    public void resetClick(){
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        res.setText("");
    }
    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton -/+
    public  void nigativeClick(){
        calcul();
        update = true;
        operateur = "-/+";
    }

    //Voici la méthode qui fait le calcul qui a été demandé par l'utilisateur
    private void calcul(){
        if(operateur.equals("+")){
            chiffre1 = chiffre1 + Double.valueOf(res.getText().toString()).doubleValue();
            res.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("-")){
            chiffre1 = chiffre1 - Double.valueOf(res.getText().toString()).doubleValue();
            res.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("*")){
            chiffre1 = chiffre1 * Double.valueOf(res.getText().toString()).doubleValue();
            res.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 / Double.valueOf(res.getText().toString()).doubleValue();
                res.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                res.setText("0");
            }
        }
        if(operateur.equals("-/+")){
            chiffre1 = -chiffre1;
            res.setText((String.valueOf(chiffre1)));
        }
    }

}