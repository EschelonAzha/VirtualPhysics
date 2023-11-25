package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class CRLFTerminatedMomentum(
    private val luminescent: ILuminescent = Luminescent(CRLFTerminatedMomentum::class),
) : AngularMomentum(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(CRLFTerminatedMomentum::class),
    )
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun format(wavelength: Wavelength) : String {
        return Strings.crlfTerminated(wavelength.toString())
    }
}