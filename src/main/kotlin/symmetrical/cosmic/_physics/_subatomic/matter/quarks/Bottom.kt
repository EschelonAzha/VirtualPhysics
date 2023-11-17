package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class Bottom(
    private val entanglement:IQuantumEntanglement = QuantumEntanglement()
) : Quark(),
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )

    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Bottom::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Bottom {
        super.i()
        return this
    }
}