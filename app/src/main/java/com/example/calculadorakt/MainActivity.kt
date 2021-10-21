package com.example.calculadorakt

import android.os.Bundle
import android.view.Surface
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0
    private var igual: Int = 0
    private var tipo: Int = DECIMAL
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rotacion = windowManager.defaultDisplay.rotation;
        if (rotacion == Surface.ROTATION_0 || rotacion == Surface.ROTATION_180) {
            tipo = DECIMAL
            button1.setOnClickListener{numeroPulsado("1")}
            button0.setOnClickListener{numeroPulsado("0")}
            button2.setOnClickListener{numeroPulsado("2")}
            button3.setOnClickListener{numeroPulsado("3")}
            button4.setOnClickListener{numeroPulsado("4")}
            button5.setOnClickListener{numeroPulsado("5")}
            button6.setOnClickListener{numeroPulsado("6")}
            button7.setOnClickListener{numeroPulsado("7")}
            button8.setOnClickListener{numeroPulsado("8")}
            button9.setOnClickListener{numeroPulsado("9")}
            buttonpunto.setOnClickListener{numeroPulsado(".")}

            buttonsuma.setOnClickListener{operacionPulsada(SUMA)}
            buttonresta.setOnClickListener{operacionPulsada(RESTA)}
            buttonmultiplicacion.setOnClickListener{operacionPulsada(MULTIPLICACION)}
            buttondivision.setOnClickListener{operacionPulsada(DIVISION)}

            buttonborrar.setOnClickListener{
                num1=0.0
                num2=0.0
                resultado.text = "0"
                operacion = NOOPERACION
            }

            buttonigual.setOnClickListener {
                var result = when(operacion){
                    SUMA -> num1 + num2
                    RESTA -> num1 - num2
                    MULTIPLICACION -> num1 * num2
                    DIVISION -> num1 / num2
                    else -> 0
                }
                num1 = result as Double
                resultado.text = if("$result".endsWith(".0")){"$result".replace(".0","")}else{"%.2f".format(result)}
                igual = 1
            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        } else {
            if(tipo == DECIMAL){
                decimal()
            }else{
                if(tipo == BINARIO){
                    binario()
                }else{
                    hexadecimal()
                }
            }
            buttonbinario.setOnClickListener { binario() }
            buttondecimal.setOnClickListener { decimal() }
            buttonhexadecimal.setOnClickListener { hexadecimal() }

            buttonA.setOnClickListener { numeroPulsado("A") }
            buttonB.setOnClickListener { numeroPulsado("B") }
            buttonC.setOnClickListener { numeroPulsado("C") }
            buttonD.setOnClickListener { numeroPulsado("D") }
            buttonE.setOnClickListener { numeroPulsado("E") }
            buttonF.setOnClickListener { numeroPulsado("F") }

            button1.setOnClickListener{numeroPulsado("1")}
            button0.setOnClickListener{numeroPulsado("0")}
            button2.setOnClickListener{numeroPulsado("2")}
            button3.setOnClickListener{numeroPulsado("3")}
            button4.setOnClickListener{numeroPulsado("4")}
            button5.setOnClickListener{numeroPulsado("5")}
            button6.setOnClickListener{numeroPulsado("6")}
            button7.setOnClickListener{numeroPulsado("7")}
            button8.setOnClickListener{numeroPulsado("8")}
            button9.setOnClickListener{numeroPulsado("9")}
            buttonpunto.setOnClickListener{numeroPulsado(".")}

            buttonsuma.setOnClickListener{operacionPulsada(SUMA)}
            buttonresta.setOnClickListener{operacionPulsada(RESTA)}
            buttonmultiplicacion.setOnClickListener{operacionPulsada(MULTIPLICACION)}
            buttondivision.setOnClickListener{operacionPulsada(DIVISION)}

            buttonborrar.setOnClickListener{
                num1=0.0
                num2=0.0
                resultado.text = "0"
                operacion = NOOPERACION
            }

            buttonigual.setOnClickListener {
                var result = when(operacion){
                    SUMA -> num1 + num2
                    RESTA -> num1 - num2
                    MULTIPLICACION -> num1 * num2
                    DIVISION -> num1 / num2
                    NOOPERACION -> num1
                    else -> 0
                }
                num1 = result as Double
                if(tipo==BINARIO){
                    resultado.text = deci_to_bina(if("$result".endsWith(".0")){"$result".replace(".0","")}else{"%.2f".format(result)}.toInt())
                }else{
                    if(tipo==DECIMAL){
                        resultado.text = if("$result".endsWith(".0")){"$result".replace(".0","")}else{"%.2f".format(result)}
                    }else{
                        resultado.text = deci_to_hexa(if("$result".endsWith(".0")){"$result".replace(".0","")}else{"%.2f".format(result)}.toInt()).capitalize()
                    }
                }
                igual = 1
            }
        }

    }
    private fun binario(){
        num1 = 0.0
        num2 = 0.0
        resultado.text = "0"
        buttonA.setEnabled(false)
        buttonB.setEnabled(false)
        buttonC.setEnabled(false)
        buttonD.setEnabled(false)
        buttonE.setEnabled(false)
        buttonF.setEnabled(false)
        button9.setEnabled(false)
        button8.setEnabled(false)
        button7.setEnabled(false)
        button6.setEnabled(false)
        button5.setEnabled(false)
        button4.setEnabled(false)
        button3.setEnabled(false)
        button2.setEnabled(false)
        buttonpunto.setEnabled(false)
        tipo = BINARIO
    }
    private fun hexadecimal(){
        num1 = 0.0
        num2 = 0.0
        resultado.text = "0"
        buttonA.setEnabled(true)
        buttonB.setEnabled(true)
        buttonC.setEnabled(true)
        buttonD.setEnabled(true)
        buttonE.setEnabled(true)
        buttonF.setEnabled(true)
        button9.setEnabled(true)
        button8.setEnabled(true)
        button7.setEnabled(true)
        button6.setEnabled(true)
        button5.setEnabled(true)
        button4.setEnabled(true)
        button3.setEnabled(true)
        button2.setEnabled(true)
        buttonpunto.setEnabled(false)
        tipo = HEXADECIMAL
    }
    private fun decimal(){
        num1 = 0.0
        num2 = 0.0
        resultado.text = "0"
        buttonA.setEnabled(false)
        buttonB.setEnabled(false)
        buttonC.setEnabled(false)
        buttonD.setEnabled(false)
        buttonE.setEnabled(false)
        buttonF.setEnabled(false)
        button9.setEnabled(true)
        button8.setEnabled(true)
        button7.setEnabled(true)
        button6.setEnabled(true)
        button5.setEnabled(true)
        button4.setEnabled(true)
        button3.setEnabled(true)
        button2.setEnabled(true)
        buttonpunto.setEnabled(true)
        tipo = DECIMAL
    }
    private fun numeroPulsado(digito: String){
        if((resultado.text == "0" && digito!= ".")||igual == 1){
            resultado.text = "$digito"
            igual = 0
        }else{
            resultado.text= "${resultado.text}$digito"
        }
        if(operacion == NOOPERACION){
            if(tipo == BINARIO){
                num1 = bina_to_deci(resultado.text.toString()).toDouble()
            }else{
                if(tipo== DECIMAL){
                    num1 = resultado.text.toString().toDouble()
                }else{
                    num1 = hexa_to_deci(resultado.text.toString()).toDouble()
                }
            }

        }else{
            if(tipo == BINARIO){
                num2 = bina_to_deci(resultado.text.toString()).toDouble()
            }else{
                if(tipo== DECIMAL){
                    num2 = resultado.text.toString().toDouble()
                }else{
                    num2 = hexa_to_deci(resultado.text.toString()).toDouble()
                }
            }
        }
    }
    private fun operacionPulsada(operacion: Int){
        this.operacion = operacion
        resultado.text = "0"
    }
    private fun bina_to_deci(numero: String): Int {
        var decimal:Int = 0
        var posicion = 0
        for (x in numero.length - 1 downTo 0) {
            var digito: Short = 1
            if (numero.get(x) == '0') {
                digito = 0
            }
            val multiplicador = Math.pow(2.0, posicion.toDouble())
            decimal += digito * multiplicador.toInt()
            posicion++
        }
        return decimal
    }
    private fun deci_to_bina(numero: Int):String {
        val B: String = Integer.toBinaryString(numero)
        return B
    }
    private fun caracterHexadecimalADecimal(caracter: Char): Int {
        return when (caracter) {
            'A' -> 10
            'B' -> 11
            'C' -> 12
            'D' -> 13
            'E' -> 14
            'F' -> 15
            else -> caracter.toString().toInt()
        }
    }
    private fun hexa_to_deci(hexadecimal: String): Int {
        var decimal: Int = 0
        var potencia = 0
        for (x in hexadecimal.length - 1 downTo 0) {
            val valor: Int = caracterHexadecimalADecimal(hexadecimal[x])
            val elevado :Int =
                Math.pow(16.0, potencia.toDouble()).toInt() * valor
            decimal += elevado
            potencia++
        }
        return decimal
    }
    private fun deci_to_hexa(decimal: Int): String{
        val hexString: String = Integer.toHexString(decimal)
        return hexString
    }
    companion object{
        const val SUMA=1
        const val RESTA=2
        const val MULTIPLICACION=3
        const val DIVISION=4
        const val NOOPERACION = 0
        const val BINARIO = 10
        const val DECIMAL = 11
        const val HEXADECIMAL = 12
    }
}