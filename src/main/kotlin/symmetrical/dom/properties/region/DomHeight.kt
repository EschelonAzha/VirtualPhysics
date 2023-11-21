package symmetrical.dom.properties.region

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion
import symmetrical.dom.DomProperty

class DomHeight(
    private val fermion: IFermion = Fermion(DomHeight::class),
) : DomProperty(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(DomHeight::class),
    )
    init {
        setProperty("height")
    }
    constructor(height:Int) : this() {
        setProperty("height", height.toString())
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
        return fermion.getClassId()+super.emit().radiate()
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
}