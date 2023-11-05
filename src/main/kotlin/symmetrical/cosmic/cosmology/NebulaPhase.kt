package symmetrical.cosmic.cosmology

import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet

open class NebulaPhase : INebula   {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    private val parent:INebula
    private var nextPhase   :INebula
    constructor(parent:INebula) {
        this.parent    = parent
        this.nextPhase = this
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    fun getParent() : INebula {
        return parent
    }
    override fun nextPhase() : INebula {
        return this
    }
    override fun getOutlet() : IOutlet {
        return parent.getOutlet()
    }
    override fun onOpen   ()                 : Unit {

    }
    override fun onClose  ()                 : Unit {

    }
    override fun onMessage(message:String)   : Boolean {
        return true
    }
    override fun send     (message:String)   : Boolean {
        return parent.send(message)
    }
}