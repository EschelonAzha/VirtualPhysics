package symmetrical.dom.properties.style

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement
import symmetrical.dom.DomProperty

class DomStyle(private val entanglement: IQuantumEntanglement = QuantumEntanglement()) : DomProperty(), IQuantumEntanglement by entanglement {

    constructor() : this(QuantumEntanglement()) {
        setProperty("style")
    }
    constructor(style:Int) : this() {
        setProperty("style", style.toString())
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
        val (domPropertyId, remainder) = Strings.remainder(2, super.emit().radiate())
        return getLocalClassId()+remainder
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(DomStyle::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}