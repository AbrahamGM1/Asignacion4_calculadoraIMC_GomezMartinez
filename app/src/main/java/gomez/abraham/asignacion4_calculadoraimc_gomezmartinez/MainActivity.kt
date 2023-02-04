package gomez.abraham.asignacion4_calculadoraimc_gomezmartinez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Evento buttonClick o clickListener
        val calcularIMC: Button = findViewById<Button>(R.id.btnCalcular)
        val height: EditText = findViewById<EditText>(R.id.height)
        val weight: EditText = findViewById<EditText>(R.id.weight)
        val imc: TextView = findViewById<TextView>(R.id.imc)
        val range: TextView = findViewById<TextView>(R.id.range)

        var total: Float? = null
        var estatura: Float? = null
        var peso: Float? = null


        calcularIMC.setOnClickListener{
            estatura = height.text.toString().toFloat()
            peso = weight.text.toString().toFloat()
            total = peso!! / (estatura!!*estatura!!)
            imc.setText(total.toString())
            range.setText("Bajo peso")
            if (total!! < 18.5f){
                range.setText("Bajo peso")
                range.setBackgroundResource(R.color.colorGreenish)
            }
            else if(total!! >= 18.5f&& total!!<=24.9f){
                range.setText("Normal")
                range.setBackgroundResource(R.color.colorGreen)
            }
            else if(total!! >=25f && total!!<=29.9f){
                range.setBackgroundResource(R.color.colorYellow)
                range.setText("Sobrepeso")
            }
            else if(total!! >= 30f && total!!<=34.9f){
                range.setText("Obesidad grado 1")
                range.setBackgroundResource(R.color.colorOrange)
            }
            else if(total!! >= 35f && total!!<=39.9f){
                range.setText("Obesidad grado 2")
                range.setBackgroundResource(R.color.colorRed)
            }
            else if(total!! >=40){
                range.setText("Obesidad grado 3")
                range.setBackgroundResource(R.color.colorBrown)
            }
        }
    }

    //Funciones
}