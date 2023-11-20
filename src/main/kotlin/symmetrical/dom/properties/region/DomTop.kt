package symmetrical.dom.properties.region

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement
import symmetrical.dom.DomProperty
import symmetrical.dom.properties.style.DomStyle

class DomTop(
    private val fermion: IQuantumEntanglement = QuantumEntanglement()
) : DomProperty(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    ) init {
        setProperty("top")
    }
    constructor(height:Int) : this() {
        setProperty("top", height.toString())
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
        return Absorber.getClassId(DomStyle::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}