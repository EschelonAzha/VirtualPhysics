package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


class Red_AntiRed (
    private val fermion: IFermion = Fermion(),
) : Gluon(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    ) init {
        color       = Red()
        antiColor   = AntiRed()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Red_AntiRed::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Red_AntiRed {
        super.i()
        return this
    }
    override fun getAntiValue() : Any? {
        return color._value
    }
    override fun setValue(value:Any?) : Gluon {
        color.setValue(value)

        return this
    }
    fun red(charge: Gluon) : Red_AntiRed {
        return this
    }
}