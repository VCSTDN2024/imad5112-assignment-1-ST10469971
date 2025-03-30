package vcmsa.ci.mealplanner

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


     private lateinit var mealsuggestion: TextView
     private lateinit var suggestMealButton: Button
     private lateinit var resetbutton: Button
     private lateinit var timeofday: EditText
     private lateinit var exitBtn: Button

     @SuppressLint("MissingInflatedId")
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         enableEdgeToEdge()
         setContentView(R.layout.activity_main)

         mealsuggestion = findViewById(R.id.mealsuggestion)
         suggestMealButton = findViewById(R.id.suggestMealbtn)
         resetbutton = findViewById(R.id.btnReset)
         timeofday = findViewById(R.id.timeofday)
         exitBtn = findViewById(R.id.exitBtn)

                        // Set click listener for the suggest Meal button
         suggestMealButton.setOnClickListener {
             suggestMeal()
                        }

                        // Set click listener for the reset button
                        resetbutton.setOnClickListener {
                            resetInputAndSuggest()
                        }

                        // Set focus change listener for the time of day field
                        timeofday.setOnFocusChangeListener { _, hasFocus ->
                            if (!hasFocus) {
                                suggestMeal()
                            }
                        }
                    }

                    // Suggest a meal based on the time of day
                    private fun suggestMeal() {
                        val timeOfDayInput = timeofday.text.toString().trim()

                        val mealSuggestion = when (timeOfDayInput) {
                            "Morning" -> "Yogurt with muesli"
                            "Mid Morning" -> "Scrambled eggs with toasted bread and avocados"
                            "Afternoon" -> "Chicken and mayo sandwich"
                            "Tea-Time" -> "Ice cream"
                            "Dinner" -> "Spaghetti bolognese"
                            "After Dinner" -> "Malva pudding"
                            else -> {
                                mealsuggestion.text = "Invalid time of day! Please check spelling of time of day."
                                return
                            }
                        }
                        mealsuggestion.text = mealSuggestion
                    }

                    private fun resetInputAndSuggest() {
                        timeofday.text.clear()
                        mealsuggestion.text = ""
                    }
                }
