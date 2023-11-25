package symmetrical.cosmic._physics._subatomic.bosons

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class Graviton(
    private val luminescent: ILuminescent = Luminescent(Graviton::class),
) : Particle(),
    ILuminescent by luminescent,
    Emitter
{
    constructor() : this(
        Luminescent(Graviton::class),
    )

    var center      : Graviton? = null
    var _attract    : Unit?     = null
    var radial      : Graviton? = null


    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        return photon.propagate()
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
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