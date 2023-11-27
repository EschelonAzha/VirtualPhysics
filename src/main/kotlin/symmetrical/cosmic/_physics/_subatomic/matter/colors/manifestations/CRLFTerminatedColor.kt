package symmetrical.cosmic._physics._subatomic.matter.colors.manifestations

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class CRLFTerminatedColor(
    private val antiMatter: IAntiMatter = AntiMatter(CRLFTerminatedColor::class),
): Green(),
    IAntiMatter by antiMatter
{

    constructor() : this(
        AntiMatter(CRLFTerminatedColor::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
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