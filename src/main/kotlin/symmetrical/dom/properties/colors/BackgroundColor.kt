package symmetrical.dom.properties.colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion
import symmetrical.dom.DomProperty

class BackgroundColor(
    private val fermion: Fermion = Fermion()
) : DomProperty(),
    IFermion by fermion
{

    constructor() : this(
        Fermion()
    ) init {
        setProperty("backgroundColor")
    }
    constructor(height:Int) : this() {
        getValue()!!.setQuarkValue(height.toString())
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
        return Absorber.getClassId(BackgroundColor::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}