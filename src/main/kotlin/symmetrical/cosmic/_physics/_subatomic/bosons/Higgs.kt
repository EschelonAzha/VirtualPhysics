package symmetrical.cosmic._physics._subatomic.bosons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Higgs(
    private val fermion: IFermion = Fermion(),
) : Particle(),
    IFermion by fermion,
    Emitter
{
    constructor() : this(
        Fermion()
    )

    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName);
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Higgs::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : Higgs {
        return this
    }
}