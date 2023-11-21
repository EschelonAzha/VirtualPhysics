package symmetrical.cosmic._physics._subatomic.bosons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


class Graviton(
    private val fermion: IFermion = Fermion(Graviton::class),
) : Particle(),
    IFermion by fermion,
    Emitter
{
    constructor() : this(
        Fermion(Graviton::class),
    )

    var center      : Graviton? = null
    var _attract    : Unit?     = null
    var radial      : Graviton? = null


    override fun absorb(photon: Photon) : Photon {
        fermion.check(photon);

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