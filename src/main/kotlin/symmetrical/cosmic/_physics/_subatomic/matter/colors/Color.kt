package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class Color(
    private val fermion: IFermion = Fermion(Color::class),
): ChromoCharge(),
    IFermion by fermion {

    constructor() : this(
        Fermion(Color::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Color {
        super.i()
        return this
    }
}