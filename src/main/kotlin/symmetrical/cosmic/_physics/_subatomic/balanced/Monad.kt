package symmetrical.cosmic._physics._subatomic.balanced


import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiQuark
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

open class Monad(
    private val matter: IMatter = Matter(Monad::class, Monad::class, true),
) : Particle(),
    IMatter by matter,
    Emitter
{
    constructor() : this(
        Matter(Monad::class, Monad::class, true),
    )


    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        return photon.propagate()
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return matter.getClassId()
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }

    fun i() : Monad {
        return this
    }
}