package symmetrical.cosmic._physics._subatomic.matter.colors.manifestations

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class CRLFTerminatedColor(
    private val fermion: IFermion = Fermion(CRLFTerminatedColor::class),
): Green(),
    IFermion by fermion
{

    constructor() : this(
        Fermion(CRLFTerminatedColor::class),
    ) {
        fermion.setKClass(CRLFTerminatedColor::class)
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun clone() : CRLFTerminatedColor {
        var result      = CRLFTerminatedColor()
        result.setValue(_value)
        return result
    }
    override fun format(redValue:Any?) : Any? {
        return Strings.crlfTerminated(redValue.toString())
    }

}