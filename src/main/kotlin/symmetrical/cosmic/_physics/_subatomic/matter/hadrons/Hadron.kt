package symmetrical.cosmic._physics._subatomic.matter.hadrons

import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


open class Hadron(
    private val luminescent: ILuminescent = Luminescent(Hadron::class),
) : ParticleBeam(),
    ILuminescent by luminescent,
    Emitter
{
    constructor() : this(
        Luminescent(Hadron::class),
    )


    object Static {
        const val LAST : Int = ParticleBeam.Static.LAST

    }



    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        clear()
        val remainder = super.absorb(photon.propagate())
        shrink()
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val classId = luminescent.getClassId()
        return classId+super.emit().radiate()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i(size:Int) : Hadron {
        return this
    }
}