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
    //var SPData:  IntArray = IntArray(12)
    var SPData: IntArray = intArrayOf(0, 1, 1, 2, 0, 1, 1, 2, 0, 0, 2, 2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton = findViewById<Button>(R.id.startButton)
        val optionsButton = findViewById<Button>(R.id.optionsButton)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val button10 = findViewById<Button>(R.id.button10)
        val button11 = findViewById<Button>(R.id.button11)
        val button12 = findViewById<Button>(R.id.button12)
        val baseButton = findViewById<Button>(R.id.baseButton)
        val resetButton = findViewById<Button>(R.id.reset)
        val temp = findViewById<Button>(R.id.temp)
        val temp2 = findViewById<Button>(R.id.temp2)
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
        button1.visibility = View.INVISIBLE
        button1.setBackgroundColor(Color.TRANSPARENT)
        button1.setTextColor(Color.TRANSPARENT)
        button2.visibility = View.INVISIBLE
        button2.setBackgroundColor(Color.TRANSPARENT)
        button2.setTextColor(Color.TRANSPARENT)
        button3.visibility = View.INVISIBLE
        button3.setBackgroundColor(Color.TRANSPARENT)
        button3.setTextColor(Color.TRANSPARENT)
        button4.visibility = View.INVISIBLE
        button4.setBackgroundColor(Color.TRANSPARENT)
        button4.setTextColor(Color.TRANSPARENT)
        button5.visibility = View.INVISIBLE
        button5.setBackgroundColor(Color.TRANSPARENT)
        button5.setTextColor(Color.TRANSPARENT)
        button6.visibility = View.INVISIBLE
        button6.setBackgroundColor(Color.TRANSPARENT)
        button6.setTextColor(Color.TRANSPARENT)
        button7.visibility = View.INVISIBLE
        button7.setBackgroundColor(Color.TRANSPARENT)
        button7.setTextColor(Color.TRANSPARENT)
        button8.visibility = View.INVISIBLE
        button8.setBackgroundColor(Color.TRANSPARENT)
        button8.setTextColor(Color.TRANSPARENT)
        button9.visibility = View.INVISIBLE
        button9.setBackgroundColor(Color.TRANSPARENT)
        button9.setTextColor(Color.TRANSPARENT)
        button10.visibility = View.INVISIBLE
        button10.setBackgroundColor(Color.TRANSPARENT)
        button10.setTextColor(Color.TRANSPARENT)
        button11.visibility = View.INVISIBLE
        button11.setBackgroundColor(Color.TRANSPARENT)
        button11.setTextColor(Color.TRANSPARENT)
        button12.visibility = View.INVISIBLE
        button12.setBackgroundColor(Color.TRANSPARENT)
        button12.setTextColor(Color.TRANSPARENT)
        resetButton.visibility = View.INVISIBLE
        mainMenuButton.visibility = View.INVISIBLE
        temp.visibility = View.INVISIBLE
        temp2.visibility = View.INVISIBLE

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
            button1.visibility = View.VISIBLE
            button2.visibility = View.VISIBLE
            button3.visibility = View.VISIBLE
            button4.visibility = View.VISIBLE
            button5.visibility = View.VISIBLE
            button6.visibility = View.VISIBLE
            button7.visibility = View.VISIBLE
            button8.visibility = View.VISIBLE
            button9.visibility = View.VISIBLE
            button10.visibility = View.VISIBLE
            button11.visibility = View.VISIBLE
            button12.visibility = View.VISIBLE
            resetButton.visibility = View.VISIBLE
            mainMenuButton.visibility = View.VISIBLE
            temp.visibility = View.VISIBLE
            temp2.visibility = View.VISIBLE

            findViewById<RelativeLayout>(R.id.container).setBackgroundColor(0xFFFFFFFF.toInt())

        }
        mainMenuButton.setOnClickListener {
            startButton.visibility = View.VISIBLE
            baseButton.visibility = View.VISIBLE
            optionsButton.visibility = View.VISIBLE
            slideShowButton.visibility = View.VISIBLE
            importButton.visibility = View.VISIBLE
            imageView.visibility = View.VISIBLE
            button1.visibility = View.INVISIBLE
            button2.visibility = View.INVISIBLE
            button3.visibility = View.INVISIBLE
            button4.visibility = View.INVISIBLE
            button5.visibility = View.INVISIBLE
            button6.visibility = View.INVISIBLE
            button7.visibility = View.INVISIBLE
            button8.visibility = View.INVISIBLE
            button9.visibility = View.INVISIBLE
            button10.visibility = View.INVISIBLE
            button11.visibility = View.INVISIBLE
            button12.visibility = View.INVISIBLE
            resetButton.visibility = View.INVISIBLE
            mainMenuButton.visibility = View.INVISIBLE
            temp.visibility = View.INVISIBLE
            temp2.visibility = View.INVISIBLE
            findViewById<RelativeLayout>(R.id.container).setBackgroundColor(0xFF085747.toInt())

        }
        button1.setOnClickListener {
            //topButton.setBackgroundColor(Color.GREEN)
            placePiece(0)
            if (SPChecker(0)) {
                mediaPlayer1.start()
            }
        }
        button2.setOnClickListener {
            //botButton.setBackgroundColor(Color.YELLOW)
            placePiece(1)
            if (SPChecker(1)) {
                //mediaPlayer1.start()
            }
        }
        button3.setOnClickListener {
            placePiece(2)
            if (SPChecker(2)) {
                //mediaPlayer1.start()
            }
        }

        button4.setOnClickListener {
            placePiece(3)
            if (SPChecker(3)) {
                mediaPlayer2.start()
            }
        }

        button5.setOnClickListener {
            placePiece(4)
            if (SPChecker(4)) {
                mediaPlayer1.start()
            }
        }

        button6.setOnClickListener {
            placePiece(5)
            if (SPChecker(5)) {
                //mediaPlayer1.start()
            }
        }

        button7.setOnClickListener {
            placePiece(6)
            if (SPChecker(6)) {
                //mediaPlayer1.start()
            }
        }

        button8.setOnClickListener {
            placePiece(7)
            if (SPChecker(7)) {
                mediaPlayer2.start()
            }
        }

        button9.setOnClickListener {
            placePiece(8)
            if (SPChecker(8)) {
                mediaPlayer1.start()
            }
        }

        button10.setOnClickListener {
            placePiece(9)
            if (SPChecker(9)) {
                mediaPlayer1.start()
            }
        }

        button11.setOnClickListener {
            placePiece(10)
            if (SPChecker(10)) {
                mediaPlayer2.start()
            }
        }
        button12.setOnClickListener {
            placePiece(11)
            if (SPChecker(11)) {
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
        for(i in 0 until 12) {
            if (!PieceTracker[i]) {
                return false
            }
        }
        return true
    }

    fun SPChecker(num: Int): Boolean {
        var SPNum: Int = SPData[num]
        for(i in 0 until 12) {
            if (SPData[i] == SPNum) {
                if (!PieceTracker[i]) {
                    return false
                }
            }
        }
        return true
    }
    fun placePiece(x: Int): Boolean {
        if(PieceTracker[x])
            return true
        PieceTracker[x] = true
        when (x) {
            0 -> findViewById<Button>(R.id.button1).setBackgroundColor(Color.GREEN)
            1 -> findViewById<Button>(R.id.button2).setBackgroundColor(Color.YELLOW)
            2 -> findViewById<Button>(R.id.button3).setBackgroundColor(Color.RED)
            3 -> findViewById<Button>(R.id.button4).setBackgroundColor(Color.BLUE)
            4 -> findViewById<Button>(R.id.button5).setBackgroundColor(Color.CYAN)
            5 -> findViewById<Button>(R.id.button6).setBackgroundColor(Color.MAGENTA)
            6 -> findViewById<Button>(R.id.button7).setBackgroundColor(Color.DKGRAY)
            7 -> findViewById<Button>(R.id.button8).setBackgroundColor(Color.LTGRAY)
            8 -> findViewById<Button>(R.id.button9).setBackgroundColor(Color.BLACK)
            9 -> findViewById<Button>(R.id.button10).setBackgroundColor(Color.GREEN)
            10 -> findViewById<Button>(R.id.button11).setBackgroundColor(Color.GRAY)
            11 -> findViewById<Button>(R.id.button12).setBackgroundColor(Color.YELLOW)
        }
        stack.push(x)
        return true
    }
    fun removePiece(x: Int): Boolean {
        PieceTracker[x] = false

        when (x) {
            0 -> findViewById<Button>(R.id.button1).setBackgroundColor(Color.TRANSPARENT)
            1 -> findViewById<Button>(R.id.button2).setBackgroundColor(Color.TRANSPARENT)
            2 -> findViewById<Button>(R.id.button3).setBackgroundColor(Color.TRANSPARENT)
            3 -> findViewById<Button>(R.id.button4).setBackgroundColor(Color.TRANSPARENT)
            4 -> findViewById<Button>(R.id.button5).setBackgroundColor(Color.TRANSPARENT)
            5 -> findViewById<Button>(R.id.button6).setBackgroundColor(Color.TRANSPARENT)
            6 -> findViewById<Button>(R.id.button7).setBackgroundColor(Color.TRANSPARENT)
            7 -> findViewById<Button>(R.id.button8).setBackgroundColor(Color.TRANSPARENT)
            8 -> findViewById<Button>(R.id.button9).setBackgroundColor(Color.TRANSPARENT)
            9 -> findViewById<Button>(R.id.button10).setBackgroundColor(Color.TRANSPARENT)
            10 -> findViewById<Button>(R.id.button11).setBackgroundColor(Color.TRANSPARENT)
            11 -> findViewById<Button>(R.id.button12).setBackgroundColor(Color.TRANSPARENT)
        }

        return true
    }
}