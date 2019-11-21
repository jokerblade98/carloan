package com.example.carloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<View>(R.id.calculate)
        btn.setOnClickListener(){

            //Convert car price to double
            val priceNum = priceNum.text.toString()
            val carPriceAmount:Double = priceNum.toDouble()

            //Convert down payment amount to double
            val editText7 = editText7.text.toString()
            val downPaymentAmount:Double = editText7.toDouble()

            //Convert interest rate to double
            val InterestRate = InterestRate.text.toString()
            val interestRateAmount = InterestRate.toDouble()

            //Convert Input to double
            val LoanPeriod = LoanPeriod.text.toString()
            val loanPeriodAmount = LoanPeriod.toDouble()

            //Calculate car loan amount
            val carLoanAmount = carPriceAmount-downPaymentAmount

            //Calculate interest
            val interestAmount = carLoanAmount*interestRateAmount*loanPeriodAmount

            //Calculate monthly repayment
            val monthlyRepaymentAmount = (carLoanAmount+interestAmount)/loanPeriodAmount/12

            //Display amount of car loan
            loanOutput.text = "RM %.2f".format(carLoanAmount)
            interestOuput.text = "RM %.2f".format(interestAmount)
            monthlyPaymentOutput.text = "RM %.2f".format(monthlyRepaymentAmount)
        }
    }
}
