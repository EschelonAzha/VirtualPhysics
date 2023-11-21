package symmetrical.dom.properties.style

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion
import symmetrical.dom.DomProperty

class DomStyle(
    private val fermion: IFermion = Fermion(DomStyle::class),
) : DomProperty(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(DomStyle::class),
    )
    init {
        setProperty("style")
    }
    constructor(style:Int) : this() {
        setProperty("style", style.toString())
    }

    private fun check(photon: Photon) : Unit {
        val classId = fermion.getClassId()

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
        return fermion.getClassId()+remainder
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
}