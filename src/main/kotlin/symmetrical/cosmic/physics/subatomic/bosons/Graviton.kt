package symmetrical.cosmic.physics.subatomic.bosons

/*
https://en.wikipedia.org/wiki/Graviton
 */

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