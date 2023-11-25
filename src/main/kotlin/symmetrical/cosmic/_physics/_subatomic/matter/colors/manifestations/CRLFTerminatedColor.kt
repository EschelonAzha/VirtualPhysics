package symmetrical.cosmic._physics._subatomic.matter.colors.manifestations

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class CRLFTerminatedColor(
    private val fermion: ILuminescent = Luminescent(CRLFTerminatedColor::class),
): Green(),
    ILuminescent by fermion
{

    constructor() : this(
        Luminescent(CRLFTerminatedColor::class),
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