package asymmetrical.machine.time


import symmetrical.cosmic._physics._dimensions.time.IRequestAnimationFrame
import symmetrical.cosmic._physics._dimensions.time.Strobe
import java.util.*


class RequestAnimationFrame : TimerTask, symmetrical.cosmic._physics._dimensions.time.IRequestAnimationFrame {
    var timer: Timer = Timer()
    private lateinit var strobe: symmetrical.cosmic._physics._dimensions.time.Strobe
    constructor() {
    }
    fun i(strobe: symmetrical.cosmic._physics._dimensions.time.Strobe) : symmetrical.cosmic._physics._dimensions.time.IRequestAnimationFrame {
        this.strobe = strobe;
        return this;
    }
    private fun frame(timestamp:Double):Unit {
        this.strobe.frame(timestamp)
    }
    override fun start() : Unit {
        timer.schedule(this,0, 16)
    }
    override fun stop() : Unit {
        timer.cancel()
    }
    override fun run() :Unit {

        this.frame(System.currentTimeMillis().toDouble())
    }
}