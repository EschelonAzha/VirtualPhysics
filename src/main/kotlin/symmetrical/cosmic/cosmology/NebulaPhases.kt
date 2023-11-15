package symmetrical.cosmic.cosmology

import asymmetrical.wormholes.pulsar.Nebula
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import websites._phases.LoginPhase


open class NebulaPhases : Nebula {

    private var phase: INebula = LoginPhase(this)
    constructor() {
    }

    override fun onOpen() : Unit {
        phase.onOpen()
    }
    override fun onMessage(payload:String) : Boolean {
        val result:Boolean = phase.onMessage(payload)
        phase = phase.nextPhase()
        return result
    }
    override fun onClose() : Unit {
        phase.onClose()
        phase = phase.nextPhase()
        return
    }
}