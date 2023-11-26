package symmetrical.cosmic._physics._subatomic.matter.colors.manifestations

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class CRLFTerminatedColor(
    private val luminescent: ILuminescent = Luminescent(CRLFTerminatedColor::class),
): Green(),
    ILuminescent by luminescent
{

    constructor() : this(
        Luminescent(CRLFTerminatedColor::class),
    ) {
        luminescent.setKClass(CRLFTerminatedColor::class)
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
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