package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class AntiColor(
    private val fermion: IFermion = Fermion(AntiColor::class),
) : ChromoCharge(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(AntiColor::class),
    )
    private fun check(photon: Photon) : Unit {
        val classId = fermion.getClassId()

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
        return fermion.getClassId()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : AntiColor {
        super.i()
        return this
    }
    override fun clone() : ChromoCharge {
        return AntiColor()
    }
}