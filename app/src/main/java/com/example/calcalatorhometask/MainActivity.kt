package com.example.calcalatorhometask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.calcalatorhometask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var lastNum = 0.0
    private var isDone = false
    private lateinit var lastCall: Button
    private var ac = 0.0
    private var isAlreadyClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            lastCall = buttonPlus
            button1.setOnClickListener {
                clearForNewInput()
                output.text = output.text.toString() + '1'
            }
            button2.setOnClickListener {
                clearForNewInput()
                output.text = output.text.toString() + '2'
            }
            button3.setOnClickListener {
                clearForNewInput()
                output.text = output.text.toString() + '3'
            }
            button4.setOnClickListener {
                clearForNewInput()
                output.text = output.text.toString() + '4'
            }
            button5.setOnClickListener {
                clearForNewInput()
                output.text = output.text.toString() + '5'
            }
            button6.setOnClickListener {
                clearForNewInput()
                output.text = output.text.toString() + '6'
            }
            button7.setOnClickListener {
                clearForNewInput()
                output.text = output.text.toString() + '7'
            }
            button8.setOnClickListener {
                clearForNewInput()
                output.text = output.text.toString() + '8'
            }
            button9.setOnClickListener {
                clearForNewInput()
                output.text = output.text.toString() + '9'
            }
            button0.setOnClickListener {
                clearForNewInput()
                if (output.text != "0" && output.text != "-0") {
                    output.text = output.text.toString() + '0'
                }
            }
            buttonCut.setOnClickListener {
                if (output.text.length > 1) {
                    output.text =
                        output.text.toString().substring(0, output.text.toString().length - 1)
                } else {
                    if (output.text.length == 1) {
                        output.text = ""
                    }
                }
            }
            buttonEqual.setOnClickListener {
                if (output.text.isEmpty()) output.text = "0.0"
                when (lastCall) {
                    buttonPlus -> {
                        lastNum += output.text.toString().toDouble()
                        output.text = clearResult(lastNum)
                    }

                    buttonMinus -> {
                        lastNum -= output.text.toString().toDouble()
                        output.text = clearResult(lastNum)
                    }

                    buttonMult -> {
                        lastNum *= output.text.toString().toDouble()
                        output.text = clearResult(lastNum)
                    }

                    buttonDivision -> {
                        lastNum /= output.text.toString().toDouble()
                        output.text = clearResult(lastNum)
                    }
                    else -> {
                        output.text = clearResult(lastNum)
                    }
                }
                ac = lastNum
                lastNum = 0.0
                isDone = true
                isAlreadyClicked = false
            }
            buttonPlus.setOnClickListener {
                if (!output.text.isEmpty()) {
                    lastCall = buttonPlus
                    lastNum += output.text.toString().toDouble()
                    output.text = ""
                }


            }
            buttonMinus.setOnClickListener {
                clearForNewInput()
                if (output.text.isNotEmpty()) {
                    lastCall = buttonMinus
                    if (isAlreadyClicked) {
                        lastNum -= output.text.toString().toDouble()
                    } else {
                        lastNum = output.text.toString().toDouble()
                        isAlreadyClicked = true
                    }
                    output.text = ""
                } else {
                    output.text = output.text.toString() + '-'
                }

            }
            buttonMult.setOnClickListener {
                if (output.text.isNotEmpty()) {
                    lastCall = buttonMult
                    if (isAlreadyClicked) {
                        lastNum *= output.text.toString().toDouble()
                    } else {
                        lastNum = output.text.toString().toDouble()
                        isAlreadyClicked = true
                    }
                    output.text = ""
                }

            }
            buttonDivision.setOnClickListener {
                if (output.text.isNotEmpty()) {
                    lastCall = buttonDivision
                    if (isAlreadyClicked) {
                        lastNum /= output.text.toString().toDouble()
                    } else {
                        lastNum = output.text.toString().toDouble()
                        isAlreadyClicked = true
                    }
                    output.text = ""
                }

            }
            buttonComa.setOnClickListener {
                clearForNewInput()
                if ("." !in output.text.toString()) {
                    if (output.text.isEmpty() || (output.text == "-")) {
                        output.text = output.text.toString() + "0"
                    }
                    output.text = output.text.toString() + '.'
                }

            }
            buttonClear.setOnClickListener {
                output.text = ""
                isDone = true
                isAlreadyClicked = false
                lastNum = 0.0
            }
            buttonAc.setOnClickListener {
                output.text = clearResult(ac)
            }

        }
    }

    private fun clearForNewInput() {
        if (isDone) {
            binding.output.text = ""
            isDone = false
        }
    }

    private fun clearResult(result: Double): String {
        if ((result % 1.0) == 0.0) {
            return result.toString().substringBefore('.')
        } else {
            return result.toString()
        }

    }

}