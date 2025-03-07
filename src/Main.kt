/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*
import javax.swing.event.DocumentListener


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var helloButton: JButton
    private lateinit var byeButton: JButton
    private lateinit var textField: JTextField

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 500)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val buttonFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)
        val headerFont = Font(Font.SANS_SERIF, Font.PLAIN, 40)
        greetingLabel = JLabel("Hello World!")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.font = headerFont
        greetingLabel.bounds = Rectangle(50, 50, 500, 100)
        add(greetingLabel)

        textField = JTextField()
        textField.bounds = Rectangle(50, 150, 500, 100)
        textField.horizontalAlignment = SwingConstants.CENTER
        textField.addActionListener(this)
        textField.addKeyListener(this)
        add(textField)

        helloButton = JButton("Click Me!")
        helloButton.bounds = Rectangle(50,300,240,100)
        helloButton.font = buttonFont
        helloButton.foreground = Color.MAGENTA
        helloButton.background = Color.CYAN
        helloButton.addActionListener(this)     // Handle any clicks
        add(helloButton)

        byeButton = JButton("Yes!")
        byeButton.bounds = Rectangle(310,300,240,100)
        byeButton.font = buttonFont
        byeButton.foreground = Color.MAGENTA
        byeButton.background = Color.CYAN
        byeButton.addActionListener(this)     // Handle any clicks
        add(byeButton)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            textField -> {
                println("[CONSOLE] Name Changed")
            }

            helloButton -> {
                greetingLabel.foreground = Color.GREEN
                if (textField.text == "") {
                    greetingLabel.text = "Hello World!"
                }
                else{
                    greetingLabel.text = "Hello, ${textField.text}!"
                }
            }

            byeButton -> {
                greetingLabel.foreground = Color.RED
                if (textField.text == "") {
                    greetingLabel.text = "Good Bye World!"
                }
                else{
                    greetingLabel.text = "Good Bye, ${textField.text}!"
                }
            }
        }
    }

    override fun keyTyped(e: KeyEvent?) {
        println("Key Typed: ${e?.keyChar}")
    }

    override fun keyPressed(e: KeyEvent?) {
        println("Key Pressed: ${e?.keyCode}")

    }

    override fun keyReleased(e: KeyEvent?) {
        println("Key Released: ${e?.keyCode}")

        if(e?.keyCode in KeyEvent.VK_A..KeyEvent.VK_Z ){
            println("Letter Key")
        }
        else{
            e?.consume()
        }
    }

}

