package symmetrical.cosmic._physics._subatomic.balanced


import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class Monad(
    private val antiMatter: IAntiMatter = AntiMatter(Monad::class),
) : Particle(),
    IAntiMatter by antiMatter,
    Emitter
{
    constructor() : this(
        AntiMatter(Monad::class),
    )


    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return photon.propagate()
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }

    fun i() : Monad {
        return this
    }
}