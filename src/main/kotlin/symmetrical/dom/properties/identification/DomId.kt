package symmetrical.dom.properties.identification

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion
import symmetrical.dom.DomProperty

class DomId(
    private val fermion: IFermion = Fermion()
) : DomProperty(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    ) init {
        setProperty("id")
    }
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