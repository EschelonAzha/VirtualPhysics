package asymmetrical.wormholes.pulsar.plugins

import asymmetrical.machine.config.Config
import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet

class WaitForData {
    object Static {
        const val TERMINATE         = -1;
        const val NO_DATA           = 0;
        const val PING_REQUIRED     = 1
        const val DATA_AVAILABLE    = 2;
    }
    private val energy          : Energy
    private val outlet          : IOutlet
    private var pingRequired    : Int = 0
    private var tries           : Int = 0


    constructor(energy: Energy, outlet: IOutlet) {
        this.outlet = outlet
        this.energy = energy
    }

    fun wait() : Int {
        val dataAvailable = outlet.read()
        if (dataAvailable == -1)
            return Static.TERMINATE

        if (dataAvailable==0) {
            tries++
            pingRequired++
            energy.pause()
            if (isPingRequired()) {
                pingRequired = 0
                return Static.PING_REQUIRED
            }
            if (isTimeout()) {
                return Static.TERMINATE
            }
            else return Static.NO_DATA
        }
        reset()
        return Static.DATA_AVAILABLE
    }

    private fun isPingRequired() : Boolean {
        val threadSleep : Long  = Config.getThreadSleep()
        var webTimeout  : Long  = Config.getPingRequired()
        return pingRequired > webTimeout / threadSleep
    }
    private fun isTimeout() : Boolean {
        val threadSleep : Long  = Config.getThreadSleep()
        var webTimeout  : Long  = Config.getWebTimeout()
        return tries > webTimeout / threadSleep
    }
    private fun reset() : WaitForData {
        tries = 0;
        pingRequired = 0
        return this
    }
}