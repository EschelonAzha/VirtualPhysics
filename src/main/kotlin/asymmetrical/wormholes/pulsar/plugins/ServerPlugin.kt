package asymmetrical.wormholes.pulsar.plugins

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet



abstract class ServerPlugin {
    object Static {
        const val TERMINATE = 0
        const val UPGRADE   = 1
    }
    protected lateinit var energy:Energy
    private   lateinit var outlet: IOutlet

    constructor() {

    }
    open fun i(energy: Energy, outlet: IOutlet) : ServerPlugin {
        this.energy     = energy
        this.outlet     = outlet
        return this
    }
    open fun run() : Int {
        return -1
    }
    open fun getOutlet() : IOutlet {
        return outlet
    }
    open fun onOpen   ()                 : Unit {
       return
    }
    open fun onClose  ()                 : Unit {
        return
    }
    open fun onMessage(message:String)   : Boolean {
        return true
    }
    open fun send(message:String) : Boolean {
        return false
    }

}