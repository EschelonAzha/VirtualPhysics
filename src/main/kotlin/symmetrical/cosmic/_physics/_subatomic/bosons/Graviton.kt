package symmetrical.cosmic._physics._subatomic.bosons

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


class Graviton {
    constructor()

    var center      : Graviton? = null
    var _attract    : Unit?     = null
    var radial      : Graviton? = null

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