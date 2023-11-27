package symmetrical.cosmic._physics._subatomic.bosons

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


class Graviton(
    private val antiMatter: IAntiMatter = AntiMatter(Graviton::class),
) : Particle(),
    IAntiMatter by antiMatter,
    Emitter
{
    constructor() : this(
        AntiMatter(Graviton::class),
    )

    var center      : Graviton? = null
    var _attract    : Unit?     = null
    var radial      : Graviton? = null


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
    fun i(center: Graviton, attract:Unit, radial: Graviton) : Graviton {
        this.center     = center
        this._attract   = attract
        this.radial     = radial
        return this
    }

    fun attract() : Graviton {
        return this
    }
}