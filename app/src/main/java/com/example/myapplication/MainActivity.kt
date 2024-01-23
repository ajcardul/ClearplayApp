package com.example.myapplication

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.ComponentActivity
import java.util.Stack

class MainActivity : ComponentActivity() {
    private var squareView: View? = null
    val PieceTracker: BooleanArray = BooleanArray(12)
    var stack: Stack<Int> = Stack()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton = findViewById<Button>(R.id.startButton)
        val optionsButton = findViewById<Button>(R.id.optionsButton)
        val topButton = findViewById<Button>(R.id.topButton)
        val botButton = findViewById<Button>(R.id.botButton)
        val baseButton = findViewById<Button>(R.id.baseButton)
        val resetButton = findViewById<Button>(R.id.reset)
        val mainMenuButton = findViewById<Button>(R.id.mainMenu)
        val slideShowButton = findViewById<Button>(R.id.slideShowButton)
        val importButton = findViewById<Button>(R.id.importButton)
        val imageView = findViewById<ImageView>(R.id.imageView)
        var mediaPlayer1 = MediaPlayer.create(this , R.raw.pieceone)
        var mediaPlayer2 = MediaPlayer.create(this , R.raw.piecetwo)
        window.decorView.apply{
            systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    )
        }
        //initial setting
        topButton.visibility = View.INVISIBLE
        topButton.setBackgroundColor(Color.TRANSPARENT)
        topButton.setTextColor(Color.TRANSPARENT)
        botButton.visibility = View.INVISIBLE
        botButton.setBackgroundColor(Color.TRANSPARENT)
        botButton.setTextColor(Color.TRANSPARENT)
        resetButton.visibility = View.INVISIBLE
        mainMenuButton.visibility = View.INVISIBLE
        baseButton.visibility = View.VISIBLE
        baseButton.setBackgroundColor(Color.TRANSPARENT)
        baseButton.setTextColor(Color.TRANSPARENT)


        startButton.setOnClickListener {
            startButton.visibility = View.INVISIBLE
            baseButton.visibility = View.INVISIBLE
            optionsButton.visibility = View.INVISIBLE
            slideShowButton.visibility = View.INVISIBLE
            importButton.visibility = View.INVISIBLE
            imageView.visibility = View.INVISIBLE
            topButton.visibility = View.VISIBLE
            botButton.visibility = View.VISIBLE
            resetButton.visibility = View.VISIBLE
            mainMenuButton.visibility = View.VISIBLE

            findViewById<RelativeLayout>(R.id.container).setBackgroundColor(0xFFFFFFFF.toInt())

        }
        mainMenuButton.setOnClickListener {
            startButton.visibility = View.VISIBLE
            baseButton.visibility = View.VISIBLE
            optionsButton.visibility = View.VISIBLE
            slideShowButton.visibility = View.VISIBLE
            importButton.visibility = View.VISIBLE
            imageView.visibility = View.VISIBLE
            topButton.visibility = View.INVISIBLE
            botButton.visibility = View.INVISIBLE
            resetButton.visibility = View.INVISIBLE
            mainMenuButton.visibility = View.INVISIBLE

            findViewById<RelativeLayout>(R.id.container).setBackgroundColor(0xFF085747.toInt())

        }
        topButton.setOnClickListener {
            //topButton.setBackgroundColor(Color.GREEN)
            placePiece(0)
            if (checkCompletion()) {
                mediaPlayer1.start()
            }
        }
        botButton.setOnClickListener {
            //botButton.setBackgroundColor(Color.YELLOW)
            placePiece(1)
            if (checkCompletion()) {
                mediaPlayer2.start()
            }
        }
        resetButton.setOnClickListener {
            if(!stack.isEmpty()){
                var poppedPiece = stack.pop()
                removePiece(poppedPiece);
            }
            /* ORIGINAL RESET CODE
            topButton.setBackgroundColor(Color.TRANSPARENT)
            botButton.setBackgroundColor(Color.TRANSPARENT)
            for(i in 0 until 2) {
                PieceTracker[i] = false
            }
            */
        }
    }
    fun checkCompletion(): Boolean {
        for(i in 0 until 2) {
            if (!PieceTracker[i]) {
                return false
            }
        }
        return true
    }
    fun placePiece(x: Int): Boolean {
        if(PieceTracker[x])
            return true
        PieceTracker[x] = true
        when(x){
            0 -> findViewById<Button>(R.id.topButton).setBackgroundColor(Color.GREEN)
            1 -> findViewById<Button>(R.id.botButton).setBackgroundColor(Color.YELLOW)
        }
        stack.push(x)
        return true
    }
    fun removePiece(x: Int): Boolean {
        PieceTracker[x] = false

        when(x){
            0 -> findViewById<Button>(R.id.topButton).setBackgroundColor(Color.TRANSPARENT)
            1 -> findViewById<Button>(R.id.botButton).setBackgroundColor(Color.TRANSPARENT)
        }
        return true
    }
}