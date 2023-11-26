package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class Red_AntiRed (
    private val luminescent: ILuminescent = Luminescent(Red_AntiRed::class),
) : Gluon(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Red_AntiRed::class),
    )   init {
        color       = Red()
        antiColor   = AntiRed()
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
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