package symmetrical.cosmic._physics._subatomic.matter.bosons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


class WBosonMinus(
    private val fermion: IFermion = Fermion(),
) : Particle(),
    IFermion by fermion,
    Emitter
{
    // Carries the weak force
    // Spin 1
    constructor() : this(
        Fermion()
    )

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

        return photon.propagate()
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(WBosonMinus::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : WBosonMinus {
        return this
    }
}