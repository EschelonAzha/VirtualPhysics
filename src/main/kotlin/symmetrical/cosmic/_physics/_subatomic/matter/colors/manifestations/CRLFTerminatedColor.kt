package symmetrical.cosmic._physics._subatomic.matter.colors.manifestations

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class CRLFTerminatedColor(
    private val fermion: IQuantumEntanglement
): Green(),
    IQuantumEntanglement by fermion
{

    constructor() : this(
        QuantumEntanglement()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(CRLFTerminatedColor::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
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