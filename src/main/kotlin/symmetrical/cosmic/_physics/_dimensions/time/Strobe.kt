package symmetrical.cosmic._physics._dimensions.time

import asymmetrical.machine.time.RequestAnimationFrame
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._creation.Universe
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class Strobe (
    private val entanglement:IQuantumEntanglement

) :
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    ) {}

    private val requestAnimationFrame = RequestAnimationFrame().i(this)

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Strobe::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : Strobe {
        return this
    }
    fun frame(timestamp:Double): Unit {
        return
    }
    fun start() : Strobe {
        requestAnimationFrame.start()
        return this
    }
}