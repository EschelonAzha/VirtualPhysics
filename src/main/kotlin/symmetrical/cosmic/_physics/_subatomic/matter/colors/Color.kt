package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class Color(
    private val fermion: IFermion = Fermion()
): ChromoCharge(),
    IFermion by fermion {

    constructor() : this(
        Fermion()
    ) {
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Color::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Color {
        super.i()
        return this
    }
}