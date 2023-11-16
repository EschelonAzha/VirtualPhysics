package symmetrical.dom.properties.identification

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement
import symmetrical.dom.DomProperty

class DomId(private val entanglement:IQuantumEntanglement=QuantumEntanglement()) : DomProperty(), IQuantumEntanglement by entanglement {

    constructor() : this(QuantumEntanglement())
    constructor(height:Int) : this() {
        setProperty("id", height.toString())
    }

    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName)
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(DomId::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}