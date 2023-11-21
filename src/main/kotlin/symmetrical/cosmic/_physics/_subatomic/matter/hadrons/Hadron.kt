package symmetrical.cosmic._physics._subatomic.matter.hadrons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class Hadron(
    private val fermion: IFermion = Fermion(Hadron::class),
) : ParticleBeam(),
    IFermion by fermion,
    Emitter
{
    constructor() : this(
        Fermion(Hadron::class),
    )


    object Static {
        const val LAST : Int = ParticleBeam.Static.LAST

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

        clear()
        val remainder = super.absorb(photon.propagate())
        shrink()
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val classId = fermion.getClassId()
        return classId+super.emit().radiate()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    fun i(size:Int) : Hadron {
        return this
    }
}