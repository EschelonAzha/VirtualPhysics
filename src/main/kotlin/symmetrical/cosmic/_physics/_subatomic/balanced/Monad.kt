package symmetrical.cosmic._physics._subatomic.balanced


import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

open class Monad(
    private val matter: IMatter = Matter(Monad::class, Monad::class),
) : Particle(),
    IMatter by matter,
    IEmitter
{
    constructor() : this(
        Matter(Monad::class, Monad::class),
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