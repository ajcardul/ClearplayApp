package com.example.myapplication

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private var squareView: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myButton = findViewById<Button>(R.id.button)
        val myButton2 = findViewById<Button>(R.id.button2)
        val myButton3 = findViewById<Button>(R.id.button3)
        val myButton4 = findViewById<Button>(R.id.button4)
        val myButton5 = findViewById<Button>(R.id.button5)
        val resetButton = findViewById<Button>(R.id.reset)
        val mainMenuButton = findViewById<Button>(R.id.mainMenu)
        val slideShowButton = findViewById<Button>(R.id.slideShowButton)
        val importButton = findViewById<Button>(R.id.importButton)
        val imageView = findViewById<ImageView>(R.id.imageView)
        var mediaPlayer1 = MediaPlayer.create(this, R.raw.pieceone)
        var mediaPlayer2 = MediaPlayer.create(this, R.raw.piecetwo)


        myButton3.visibility = View.INVISIBLE
        myButton3.setBackgroundColor(Color.TRANSPARENT)
        myButton3.setTextColor(Color.TRANSPARENT)
        myButton4.visibility = View.INVISIBLE
        myButton4.setBackgroundColor(Color.TRANSPARENT)
        myButton4.setTextColor(Color.TRANSPARENT)
        resetButton.visibility = View.INVISIBLE
        mainMenuButton.visibility = View.INVISIBLE
        myButton5.visibility = View.VISIBLE
        myButton5.setBackgroundColor(Color.TRANSPARENT)
        myButton5.setTextColor(Color.TRANSPARENT)


        myButton.setOnClickListener {
            myButton.visibility = View.INVISIBLE
            myButton5.visibility = View.INVISIBLE
            myButton2.visibility = View.INVISIBLE
            slideShowButton.visibility = View.INVISIBLE
            importButton.visibility = View.INVISIBLE
            imageView.visibility = View.INVISIBLE
            myButton3.visibility = View.VISIBLE
            myButton4.visibility = View.VISIBLE
            resetButton.visibility = View.VISIBLE
            mainMenuButton.visibility = View.VISIBLE

            findViewById<RelativeLayout>(R.id.container).setBackgroundColor(0xFFFFFFFF.toInt())

        }
        mainMenuButton.setOnClickListener {
            myButton.visibility = View.VISIBLE
            myButton5.visibility = View.VISIBLE
            myButton2.visibility = View.VISIBLE
            slideShowButton.visibility = View.VISIBLE
            importButton.visibility = View.VISIBLE
            imageView.visibility = View.VISIBLE
            myButton3.visibility = View.INVISIBLE
            myButton4.visibility = View.INVISIBLE
            resetButton.visibility = View.INVISIBLE
            mainMenuButton.visibility = View.INVISIBLE

            findViewById<RelativeLayout>(R.id.container).setBackgroundColor(0xFF085747.toInt())

        }
        myButton3.setOnClickListener {
            mediaPlayer1.start()
            myButton3.setBackgroundColor(Color.GREEN)

        }
        myButton4.setOnClickListener {
            mediaPlayer2.start()
            myButton4.setBackgroundColor(Color.YELLOW)

        }
        resetButton.setOnClickListener {
            myButton3.setBackgroundColor(Color.TRANSPARENT)
            myButton4.setBackgroundColor(Color.TRANSPARENT)

        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val container = findViewById<RelativeLayout>(R.id.container)
        val x = event.x
        val y = event.y
        var mediaPlayer1 = MediaPlayer.create(this, R.raw.goomba)

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                // Create a green square when touch is pressed
                squareView = View(this)
                squareView?.setBackgroundColor(Color.GREEN)
                val squareSize = 100 // Adjust the square size as needed
                val params = ViewGroup.LayoutParams(squareSize, squareSize)
                squareView?.layoutParams = params
                squareView?.x = x - squareSize / 2
                squareView?.y = y - squareSize / 2
                container.addView(squareView)
                //mediaPlayer1.start()
            }
            MotionEvent.ACTION_MOVE -> {
                // Move the green square with the cursor during touch
                if (squareView != null) {
                    squareView?.x = x - squareView?.width!! / 2
                    squareView?.y = y - squareView?.height!! / 2
                }
            }
            MotionEvent.ACTION_UP -> {
                // Remove the green square when touch is released
                if (squareView != null) {
                    container.removeView(squareView)
                }
            }
        }

        return true
    }
}
