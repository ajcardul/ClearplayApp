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
import android.content.res.AssetFileDescriptor
import java.io.File
import android.net.Uri
import android.graphics.drawable.Drawable

class MainActivity : ComponentActivity() {
    private var squareView: View? = null
    val PieceTracker: BooleanArray = BooleanArray(12)
    var stack: Stack<Int> = Stack()
    var SPData:  IntArray = IntArray(12)

    private var mediaPlayer: MediaPlayer? = null
    private var isAudioFile1: Boolean = true

    var pNum: Int = 0
    var numPieces: Int = 0
    var numSPs: Int = 0

    //val puzzleBase = findViewById<ImageView>(R.id.puzzleBase)

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
        val resetButton = findViewById<Button>(R.id.reset)
        val temp = findViewById<Button>(R.id.temp)
        val temp2 = findViewById<Button>(R.id.temp2)
        val mainMenuButton = findViewById<Button>(R.id.mainMenu)
        val slideShowButton = findViewById<Button>(R.id.slideShowButton)
        val importButton = findViewById<Button>(R.id.importButton)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val puzzleBase = findViewById<ImageView>(R.id.puzzleBase)
        val cover1 = findViewById<ImageView>(R.id.cover_12_1)
        val cover2 = findViewById<ImageView>(R.id.cover_12_2)
        val cover3 = findViewById<ImageView>(R.id.cover_12_1ph)
        val cover4 = findViewById<ImageView>(R.id.cover_12_2ph)

        window.decorView.apply {
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


        puzzleBase.visibility = View.INVISIBLE
        cover1.visibility = View.INVISIBLE
        cover2.visibility = View.INVISIBLE
        cover3.visibility = View.INVISIBLE
        cover4.visibility = View.INVISIBLE

        startButton.setOnClickListener {
            startButton.visibility = View.INVISIBLE
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

            puzzleBase.visibility = View.VISIBLE
            cover1.visibility = View.VISIBLE
            cover2.visibility = View.VISIBLE
            cover3.visibility = View.VISIBLE
            cover4.visibility = View.VISIBLE

            findViewById<RelativeLayout>(R.id.container).setBackgroundColor(0xFFFFFFFF.toInt())

        }
        mainMenuButton.setOnClickListener {
            startButton.visibility = View.VISIBLE
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
            puzzleBase.visibility = View.INVISIBLE
            cover1.visibility = View.INVISIBLE
            cover2.visibility = View.INVISIBLE
            cover3.visibility = View.INVISIBLE
            cover4.visibility = View.INVISIBLE

            findViewById<RelativeLayout>(R.id.container).setBackgroundColor(0xFF085747.toInt())

        }
        button1.setOnClickListener {
            //topButton.setBackgroundColor(Color.GREEN)
            placePiece(0)
            SPChecker(0)
        }
        button2.setOnClickListener {
            //botButton.setBackgroundColor(Color.YELLOW)
            placePiece(1)
            SPChecker(1)
        }
        button3.setOnClickListener {
            placePiece(2)
            SPChecker(2)
        }

        button4.setOnClickListener {
            placePiece(3)
            SPChecker(3)
        }

        button5.setOnClickListener {
            placePiece(4)
            SPChecker(4)
        }

        button6.setOnClickListener {
            placePiece(5)
            SPChecker(5)
        }

        button7.setOnClickListener {
            placePiece(6)
            SPChecker(6)
        }

        button8.setOnClickListener {
            placePiece(7)
            SPChecker(7)
        }

        button9.setOnClickListener {
            placePiece(8)
            SPChecker(8)
        }

        button10.setOnClickListener {
            placePiece(9)
            SPChecker(9)
        }

        button11.setOnClickListener {
            placePiece(10)
            SPChecker(10)
        }
        button12.setOnClickListener {
            placePiece(11)
            SPChecker(11)
        }
        resetButton.setOnClickListener {
            if (!stack.isEmpty()) {
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
        importButton.setOnClickListener {
            readInfo()
            pNum = (pNum + 1) % 2
        }
        temp.setOnClickListener {
            mediaPlayer?.run { stop() }
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
        if (SPNum != 0) {
            initMP(SPNum)
            mediaPlayer?.start()
        }
        return true
    }
    fun placePiece(x: Int): Boolean {
        if(PieceTracker[x])
            return true
        PieceTracker[x] = true
        var color: Int = 0xFFFFFFFF.toInt()
        if (SPData[x] == 0) {
            color = 0xFFFF0000.toInt()
        }
        else if (SPData[x] == 1) {
            color = 0xFF00FF00.toInt()
        }
        else if (SPData[x] == 2) {
            color = 0xFF0000FF.toInt()
        }
        when (x) {
            0 -> {
                //findViewById<Button>(R.id.button1).setBackgroundColor(color)
                findViewById<ImageView>(R.id.cover_12_1).visibility = View.INVISIBLE
            }
            1 -> {
                //findViewById<Button>(R.id.button2).setBackgroundColor(color)
                findViewById<ImageView>(R.id.cover_12_2).visibility = View.INVISIBLE
            }
            2 -> findViewById<Button>(R.id.button3).setBackgroundColor(color)
            3 -> findViewById<Button>(R.id.button4).setBackgroundColor(color)
            4 -> findViewById<Button>(R.id.button5).setBackgroundColor(color)
            5 -> findViewById<Button>(R.id.button6).setBackgroundColor(color)
            6 -> findViewById<Button>(R.id.button7).setBackgroundColor(color)
            7 -> findViewById<Button>(R.id.button8).setBackgroundColor(color)
            8 -> findViewById<Button>(R.id.button9).setBackgroundColor(color)
            9 -> findViewById<Button>(R.id.button10).setBackgroundColor(color)
            10 -> findViewById<Button>(R.id.button11).setBackgroundColor(color)
            11 -> findViewById<Button>(R.id.button12).setBackgroundColor(color)
        }
        stack.push(x)
        return true
    }
    fun removePiece(x: Int): Boolean {
        PieceTracker[x] = false

        when (x) {
            0 -> {
                findViewById<Button>(R.id.button1).setBackgroundColor(Color.TRANSPARENT)
                findViewById<ImageView>(R.id.cover_12_1).visibility = View.VISIBLE
            }
            1 -> {
                findViewById<Button>(R.id.button2).setBackgroundColor(Color.TRANSPARENT)
                findViewById<ImageView>(R.id.cover_12_2).visibility = View.VISIBLE
            }
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

    fun readInfo() {
        // Specify the path to your text file
        var filePath: String = "p$pNum/data.txt"
        var imgPath: String = "p$pNum/TestBase$pNum.png"
        val imgStream = assets.open(imgPath)
        val imgDrawable = Drawable.createFromStream(imgStream, null)

        findViewById<ImageView>(R.id.puzzleBase).setImageDrawable(imgDrawable)

        val lines = applicationContext.assets.open(filePath).bufferedReader().use {
            it.readLines()
        }

        if (lines.size >= 3) {
            // Parse the values from the lines
            numPieces = lines[0].toIntOrNull() ?: 0
            numSPs = lines[1].toIntOrNull() ?: 0
            // Leave as string, convert to charArray, then do individual char to number and fill in SPData
            val tempNum = lines[2]
            val numChars = tempNum.toCharArray()
            for (i in numChars.indices) {
                SPData[i] = Character.getNumericValue(numChars[i])
            }
        }
        else {
            println("Invalid file format: Not enough lines in the file.")
        }
    }

    private fun initMP(x: Int): Boolean {
        // Release existing MediaPlayer if it exists
        mediaPlayer?.release()

        if (x > numSPs) return false
        // Create a new MediaPlayer instance
        mediaPlayer = MediaPlayer().apply {
            try {
                // Open the audio file based on the boolean variable
                val assetFileName = "p$pNum/audio/a$x.mp3"
                val assetFileDescriptor: AssetFileDescriptor = assets.openFd(assetFileName)
                setDataSource(assetFileDescriptor.fileDescriptor, assetFileDescriptor.startOffset, assetFileDescriptor.length)
                prepare()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release the MediaPlayer when the activity is destroyed
        mediaPlayer?.release()
    }
}
