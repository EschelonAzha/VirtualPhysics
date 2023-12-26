package symmetrical.cosmic.cosmology

import asymmetrical.wormholes.pulsar.Nebula
import websites._phases.LoginPhase


open class NebulaPhases : Nebula {

    private var phase: INebula = LoginPhase(this)
    constructor() {
    }

    override fun onClose() : Unit {
        phase.onClose()
        phase = phase.nextPhase()
        return
    }
    override fun onMessage(payload:String) : Boolean {
        val result:Boolean = phase.onMessage(payload)
        phase = phase.nextPhase()
        return result
    }
    override fun onOpen() : Unit {
        phase.onOpen()
    }


}