package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.color.QCD
import symmetrical.cosmic._physics._subatomic.bosons.gluons.Green_AntiGreen
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

// FORMATTED VALUE
open class Green (
    private val fermion: IFermion = Fermion(Green::class),
):Color(),
    IFermion by fermion
{  // Int
    constructor() : this(
        Fermion(Green::class),
    )
    init {
        color = GREEN
    }


    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Green {
        super.i()
        return this
    }
    override fun clone() : Green {
        var result      = Green()
        result.setValue(_value)
        return result
    }
    open fun green(charge: Gluon) : Green_AntiGreen {
        var gluon               = Green_AntiGreen()
        gluon.antiColor.setValue(charge.getAntiValue())
        gluon.color.setValue    (format(charge.getAntiValue()))
        return gluon
    }

    open fun format(redValue:Any?) : Any? {
        return QCD().green(redValue)
    }
}