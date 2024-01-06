package symmetrical.cosmic.physics.subatomic.balanced


import symmetrical.cosmic.physics.subatomic.bosons.IEmitter
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

open class Monad(
    private val matter: IMatter = Matter(Monad::class, Monad::class),
) : symmetrical.cosmic.physics.subatomic.balanced.Particle(),
    IMatter by matter,
    IEmitter
{
    constructor() : this(
        Matter(Monad::class, Monad::class),
    )
    fun i() : Monad {
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }

    private fun radiate() : String {
        return matter.getClassId()+
                super.emit().radiate()
    }
}